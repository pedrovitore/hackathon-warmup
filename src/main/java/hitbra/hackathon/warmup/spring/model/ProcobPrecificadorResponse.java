package hitbra.hackathon.warmup.spring.model;

public class ProcobPrecificadorResponse {

	private String existe_informacao;
	private String chassi;
	private String origem;
	private String regiao;
	private String pais;
	private String categoria;
	private String marca;
	private String modelo;
	private int ano;
	private String carroceria;
	private String versao;
	private String combustivel;
	private String local_fabricacao;
	private ProcobDadosPrecificacaoResponse dados_precificacao;
	
	
	public String getExiste_informacao() {
		return existe_informacao;
	}
	public void setExiste_informacao(String existe_informacao) {
		this.existe_informacao = existe_informacao;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public String getCarroceria() {
		return carroceria;
	}
	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getLocal_fabricacao() {
		return local_fabricacao;
	}
	public void setLocal_fabricacao(String local_fabricacao) {
		this.local_fabricacao = local_fabricacao;
	}
	public ProcobDadosPrecificacaoResponse getDados_precificacao() {
		return dados_precificacao;
	}
	public void setDados_precificacao(ProcobDadosPrecificacaoResponse dados_precificacao) {
		this.dados_precificacao = dados_precificacao;
	}
	
	
}
