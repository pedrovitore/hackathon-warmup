package hitbra.hackathon.warmup.spring.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VeiculoCompleto {

	private String marca;
	

	private String modelo;
	private int ano;
	private double valorDeVenda;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	
	
	private Boolean possuiGravame;
	
	//Formata o resultado da data no arquivo JSON retornado pela API. Se não adicionar isso o spring retorna um número inteiro.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")	
	private Date dataVigenciaContratoGravame;
	
	private Boolean carroDeLeilao;
	private String descricaoConservacao;
	
	private Boolean dpvatEmDia;
	
	private Boolean possuiSinistro;
	
	private double preco_medio;

	

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
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
