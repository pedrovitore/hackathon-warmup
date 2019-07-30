package hitbra.hackathon.warmup.spring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcobLeiloesResponse {
	
	private String veiculo;
	private String leilao;
	private String lote;
	private String marca;
	private String modelo;
	private int ano_modelo;
	private int ano_fabricacao;
	private String placa;
	private String chassi;
	private String cor;
	private String combustivel;
	private String categoria;
	private String geral;
	private String motor;
	private int quantidade_eixo;
    private String patio;
    private String leiloeiro;
    private Date data;
    private String comitente;
    private String cambio;
    private String renavam;
    
    
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getLeilao() {
		return leilao;
	}
	public void setLeilao(String leilao) {
		this.leilao = leilao;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
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
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getGeral() {
		return geral;
	}
	public void setGeral(String geral) {
		this.geral = geral;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public int getQuantidade_eixo() {
		return quantidade_eixo;
	}
	public void setQuantidade_eixo(int quantidade_eixo) {
		this.quantidade_eixo = quantidade_eixo;
	}
	public String getPatio() {
		return patio;
	}
	public void setPatio(String patio) {
		this.patio = patio;
	}
	public String getLeiloeiro() {
		return leiloeiro;
	}
	public void setLeiloeiro(String leiloeiro) {
		this.leiloeiro = leiloeiro;
	}
	public Date getData() {
		return data;
	}
	public void setData(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(data);
		this.data = parsedDate;
	}
	public String getComitente() {
		return comitente;
	}
	public void setComitente(String comitente) {
		this.comitente = comitente;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public int getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(int ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public int getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
    
    
}
