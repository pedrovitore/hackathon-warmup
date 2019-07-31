package hitbra.hackathon.warmup.spring.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VeiculoCompleto {

	private Veiculo veiculo;
	
	private Boolean possuiGravame;
	
	//Formata o resultado da data no arquivo JSON retornado pela API. Se não adicionar isso o spring retorna um número inteiro.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataVigenciaContratoGravame;
	
	private Boolean carroDeLeilao;
	private String descricaoConservacao;
	
	private Boolean dpvatEmDia;
	
	private Boolean possuiSinistro;
	
	private double preco_medio;

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		//Adicionar aqui o logradouro completo como atributo nessa classe.
		this.veiculo = veiculo;
	}

	public Boolean getPossuiGravame() {
		return possuiGravame;
	}

	public void setPossuiGravame(Boolean possuiGravame) {
		this.possuiGravame = possuiGravame;
	}

	public Date getDataVigenciaContratoGravame() {
		return dataVigenciaContratoGravame;
	}

	public void setDataVigenciaContratoGravame(Date dataVigenciaContratoGravame) {
		this.dataVigenciaContratoGravame = dataVigenciaContratoGravame;
	}

	public Boolean getCarroDeLeilao() {
		return carroDeLeilao;
	}

	public void setCarroDeLeilao(Boolean carroDeLeilao) {
		this.carroDeLeilao = carroDeLeilao;
	}

	public String getDescricaoConservacao() {
		return descricaoConservacao;
	}

	public void setDescricaoConservacao(String descricaoConservacao) {
		this.descricaoConservacao = descricaoConservacao;
	}

	public Boolean getDpvatEmDia() {
		return dpvatEmDia;
	}

	public void setDpvatEmDia(Boolean dpvatEmDia) {
		this.dpvatEmDia = dpvatEmDia;
	}

	public Boolean getPossuiSinistro() {
		return possuiSinistro;
	}

	public void setPossuiSinistro(Boolean possuiSinistro) {
		this.possuiSinistro = possuiSinistro;
	}

	public double getPreco_medio() {
		return preco_medio;
	}

	public void setPreco_medio(double preco_medio) {
		this.preco_medio = preco_medio;
	}
	
	
	
}
