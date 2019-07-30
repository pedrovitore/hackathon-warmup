package hitbra.hackathon.warmup.spring.controllers;

import hitbra.hackathon.warmup.spring.model.ProcobContentResponse;
import hitbra.hackathon.warmup.spring.model.ProcobDadosGravamesResponse;
import hitbra.hackathon.warmup.spring.model.ProcobVeiculoResponse;
import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.model.VeiculoCompleto;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import hitbra.hackathon.warmup.spring.services.Procob;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/vehicles")
@Api(value = "/vehicles")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repo;
    @Autowired
    private Procob service;
    
    @GetMapping("/")
    public List<Veiculo> getByMarca(
            @ApiParam(value = "Marca do veículo", required = true) @RequestParam(value="marca") String marca) {
        
    	//Faz a consulta no banco de dados
		List<Veiculo> lista = repo.findByMarca(marca);
		
		//Lista que será retornada ao final da api
		List<VeiculoCompleto> listaFinal;

		//Itera sobre todos os veículos do banco e preenche com as informações encontradas dele na PROCOB Api.
		lista.forEach((Veiculo veiculo) -> {
			//Procura por essa placa no PROCOB
			ProcobVeiculoResponse veiculoResponse = service.getDadosVeiculo(veiculo.getPlaca(), "");
			
			//getDadosVeículo PRECISA FAZER FILTRO PELA PLACA E CHASSI!!!!
			//IMPLEMENTAR JÁ!!!!!!!
			//IMPLEMENTAR JÁ!!!!!!!
			//IMPLEMENTAR JÁ!!!!!!!
			//IMPLEMENTAR JÁ!!!!!!!
			//IMPLEMENTAR JÁ!!!!!!!
			
			ProcobContentResponse content = veiculoResponse.getContent();
			
			//Instância de veiculoCompleto que será adicionada à listaFinal
			VeiculoCompleto veiculoCompleto = new VeiculoCompleto();
			
			veiculoCompleto.setVeiculo(veiculo);
			
			//Gravames
			//Existe_informacao="SIM" significa que possui gravame
			if (content.getGravames().getExiste_informacao().equals("SIM")) {
				System.out.println("possui gravame");
				veiculoCompleto.setPossuiGravame(true);
				
				//Pega os dados dos gravames do carro (pode haver mais de um)
				ProcobDadosGravamesResponse[] dadosGravames = content.getGravames().getDados_gravames();
				ArrayList<Date> datasVigenciaContrato = new ArrayList<Date>();
				
				//Itera sobre todos os dados de gravame e salva a data de vigência em um ArrayList
				for (ProcobDadosGravamesResponse gravameAtual : dadosGravames ) {
					datasVigenciaContrato.add(gravameAtual.getData_vigencia_contrato());
				}
				
				//Seta no Veículo Completo a MAIOR data de vigência encontrada.
				veiculoCompleto.setDataVigenciaContratoGravame(Collections.max(datasVigenciaContrato));
			} else {
				veiculoCompleto.setPossuiGravame(false);

				//Seta Data de Vigência como null, já que não possui gravame.
				veiculoCompleto.setDataVigenciaContratoGravame(null);
			}
			
			//System.out.println(content.getBin().getMarca());
		});
		
		return lista;
		
    }
}