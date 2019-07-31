package hitbra.hackathon.warmup.spring.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hitbra.hackathon.warmup.spring.model.ProcobContentResponse;
import hitbra.hackathon.warmup.spring.model.ProcobDadosGravamesResponse;
import hitbra.hackathon.warmup.spring.model.ProcobDetalhesDpvatResponse;
import hitbra.hackathon.warmup.spring.model.ProcobVeiculoResponse;
import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.model.VeiculoCompleto;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import hitbra.hackathon.warmup.spring.services.Procob;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/vehicles")
@Api(value = "/vehicles")
public class VeiculoController {

	@Autowired
	private VeiculoRepository repo;
	@Autowired
	private Procob service;

	@GetMapping("/pesquisar")
	@ApiOperation("Busca em nossa base de dados por todos veículos disponíveis.")
	public List<VeiculoCompleto> getByMarca(
			@ApiParam(value = "(Opcional) Filtra veículos pela marca.", required = false) @RequestParam(value = "marca", required = false) String marca,
			@ApiParam(value = "(Opcional) Filtra veículos pelo ano.", required = false) @RequestParam(value = "ano", required = false) Integer ano,
			@ApiParam(value = "(Opcional) Filtra veículos pela cidade.", required = false) @RequestParam(value = "cidade", required = false) String cidade) {

		if (marca == null)
			marca = ".*";
		if (cidade == null) {
			cidade = ".*";
		} else {
			cidade = ".*" + cidade + ".*";
		}

		// Faz a consulta no banco de dados
		List<Veiculo> lista;
		if (ano == null) {
			lista = repo.findByMarcaRegexAndLocalRegexAndStatus(marca, cidade, "Disponível");
		} else {
			lista = repo.findByMarcaRegexAndAnoAndLocalRegexAndStatus(marca, ano, cidade, "Disponível");
		}

		// Popula a lista que será retornada ao final da api
		List<VeiculoCompleto> listaFinal = popularDadosVeiculo(lista);

		return listaFinal;

	}

	@PutMapping("/comprar/{id}")
	@ApiOperation("Compra um veículo pelo seu ID. Sujeito a verificação de disponibilidade do veículo antes da compra.")
	public ResponseEntity<?> update(@PathVariable("id") @ApiParam(value = "ID do veículo a ser comprado.", required = true) String id) {
		Veiculo veiculo = repo.findOne(id);
		
		if ( veiculo == null ) {
			return ResponseEntity.ok().body("Carro não encontrado na base de dados. Por favor verifique se o ID foi informado corretamente.");
		}
		
		System.out.println(veiculo.getStatus());
		if (veiculo.getStatus().equals("Indisponível")) {
			return ResponseEntity.ok().body("Este carro não se encontra mais disponível para venda.");
		} else {
			veiculo.setStatus("Indisponível");
		}

		repo.save(veiculo);
		
		return ResponseEntity.ok().body("Você acaba de comprar um " + veiculo.getModelo() + " por R$" + String.format("%.2f", veiculo.getValor()) + "." + System.lineSeparator() + "Parabéns!");
	}

	public List<VeiculoCompleto> popularDadosVeiculo(List<Veiculo> lista) {
		List<VeiculoCompleto> listaFinal = new ArrayList<VeiculoCompleto>();

		// Itera sobre todos os veículos da lista e preenche com as informações
		// encontradas dele na PROCOB Api.
		lista.forEach((Veiculo veiculo) -> {
			// Procura por essa placa no PROCOB
			ProcobVeiculoResponse veiculoResponse = service.getDadosVeiculo(veiculo.getPlaca());

			ProcobContentResponse content = veiculoResponse.getContent();

			// Instância de veiculoCompleto que será adicionada à listaFinal
			VeiculoCompleto veiculoCompleto = new VeiculoCompleto();

			// Setta o id
			veiculoCompleto.setId(veiculo.id);

			// Chama funçao veiculoCompleto
			preencheVeiculo(veiculoCompleto, veiculo);

			// Gravames
			preencheGravames(veiculoCompleto, content);

			// Leiloes
			preencheLeiloes(veiculoCompleto, content);

			// Dpvat
			preencheDpvat(veiculoCompleto, content);

			// Sinistro
			preencheSinistro(veiculoCompleto, content);

			// Preço Médio
			preenchePrecoMedio(veiculoCompleto, content);

			listaFinal.add(veiculoCompleto);
		});

		return listaFinal;
	}

	public void preencheGravames(VeiculoCompleto veiculoCompleto, ProcobContentResponse content) {
		// Existe_informacao="SIM" significa que possui gravame
		if (content.getGravames().getExiste_informacao().equals("SIM")) {
			System.out.println("possui gravame");
			veiculoCompleto.setPossuiGravame(true);

			// Pega os dados dos gravames do carro (pode haver mais de um)
			ProcobDadosGravamesResponse[] dadosGravames = content.getGravames().getDados_gravames();
			ArrayList<Date> datasVigenciaContrato = new ArrayList<Date>();

			// Itera sobre todos os dados de gravame e salva a data de vigência em um
			// ArrayList
			for (ProcobDadosGravamesResponse gravameAtual : dadosGravames) {
				datasVigenciaContrato.add(gravameAtual.getData_vigencia_contrato());
			}

			// Seta no Veículo Completo a MAIOR data de vigência encontrada.
			veiculoCompleto.setDataVigenciaContratoGravame(Collections.max(datasVigenciaContrato));
		} else {
			veiculoCompleto.setPossuiGravame(false);

			// Seta Data de Vigência como null, já que não possui gravame.
			veiculoCompleto.setDataVigenciaContratoGravame(null);
		}
	}

	public void preencheLeiloes(VeiculoCompleto veiculoCompleto, ProcobContentResponse content) {
		// Existe_informacao="SIM" significa que possui LEILÃO
		if (content.getLeilao().getExiste_informacao().equals("SIM")) {
			System.out.println("possui leilão");
			veiculoCompleto.setCarroDeLeilao(true);

			// Pega o estado de conservação do carro
			String estadoConservacao = content.getLeilao().getScore().getDescricao_pontuacao();
			veiculoCompleto.setDescricaoConservacao(estadoConservacao);
		} else {
			veiculoCompleto.setCarroDeLeilao(false);

			// Seta estado de conservação como vazio, já que não possui dados sobre leilão.
			veiculoCompleto.setDescricaoConservacao("");
		}
	}

	public void preencheDpvat(VeiculoCompleto veiculoCompleto, ProcobContentResponse content) {
		// Pega os detalhes dos pagamentos do dpvat (pode haver mais de um)
		ProcobDetalhesDpvatResponse[] dadosDpvat = content.getDpvat().getDetalhes();

		if (dadosDpvat.length == 0) {
			// Se dados está vazio significa que o Dpvat nunca foi pago.
			veiculoCompleto.setDpvatEmDia(false);
		} else {
			ArrayList<Integer> anosExercicioDpvat = new ArrayList<Integer>();

			// Itera sobre todos os pagamentos de DPVAT e salva o ano de exercício em um
			// ArrayList
			for (ProcobDetalhesDpvatResponse dpvat : dadosDpvat) {
				anosExercicioDpvat.add(dpvat.getAno_exercicio());
			}

			// Pega o ano do último Dpvat pago e do ano atual
			int anoExercicioDpvat = Collections.max(anosExercicioDpvat);
			int anoAtual = LocalDate.now().getYear();

			if (anoExercicioDpvat >= anoAtual) {
				veiculoCompleto.setDpvatEmDia(true);
			} else {
				veiculoCompleto.setDpvatEmDia(false);
			}

		}
	}

	public void preencheSinistro(VeiculoCompleto veiculoCompleto, ProcobContentResponse content) {
		// Existe_informacao="SIM" significa que possui SINISTRO
		if (content.getSinistro().getExiste_informacao().equals("SIM")) {
			System.out.println("possui Sinistro");
			veiculoCompleto.setPossuiSinistro(true);
		} else {
			veiculoCompleto.setPossuiSinistro(false);
		}
	}

	public void preenchePrecoMedio(VeiculoCompleto veiculoCompleto, ProcobContentResponse content) {
		// Existe_informacao="SIM" significa que possui PREÇO
		if (content.getPrecificador().getExiste_informacao().equals("SIM")) {
			System.out.println("possui informação de preço");
			veiculoCompleto.setPreco_medio(content.getPrecificador().getDados_precificacao().getPreco_medio());
		} else {
			veiculoCompleto.setPreco_medio(0.0);
		}
	}

	public void preencheVeiculo(VeiculoCompleto veiculoCompleto, Veiculo veiculo) {
		veiculoCompleto.setMarca(veiculo.getMarca());
		veiculoCompleto.setModelo(veiculo.getModelo());
		veiculoCompleto.setAno(veiculo.getAno());
		veiculoCompleto.setValorDeVenda(veiculo.getValor());
		String local = veiculo.getLocal();
		String logradouro = local.split(",")[0];
		String numero = local.split(",")[1].split("-")[0];
		String bairro = local.split(",")[1].split("-")[1];
		String cidade = local.split(",")[2].split("-")[0];
		String estado = local.split(",")[2].split("-")[1];
		veiculoCompleto.setLogradouro(logradouro);
		veiculoCompleto.setNumero(numero);
		veiculoCompleto.setBairro(bairro);
		veiculoCompleto.setCidade(cidade);
		veiculoCompleto.setEstado(estado);

	}
}