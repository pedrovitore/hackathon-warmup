package hitbra.hackathon.warmup.spring.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProcobDetalhesDpvatResponse {

	private String placa;
	private String renavam;
	private String chassi;
	private String nome_proprietario;
	private String documento_proprietario;
	private String uf;
	private int ano_exercicio;
	private Date data_emissao_guia;
	private Date data_processamento;
	private String banco;
	private double saldo;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getNome_proprietario() {
		return nome_proprietario;
	}
	public void setNome_proprietario(String nome_proprietario) {
		this.nome_proprietario = nome_proprietario;
	}
	public String getDocumento_proprietario() {
		return documento_proprietario;
	}
	public void setDocumento_proprietario(String documento_proprietario) {
		this.documento_proprietario = documento_proprietario;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getAno_exercicio() {
		return ano_exercicio;
	}
	public void setAno_exercicio(int ano_exercicio) {
		this.ano_exercicio = ano_exercicio;
	}
	public Date getData_emissao_guia() {
		return data_emissao_guia;
	}
	public void setData_emissao_guia(String data_emissao_guia) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(data_emissao_guia);
		this.data_emissao_guia = parsedDate;
	}
	public Date getData_processamento() {
		return data_processamento;
	}
	public void setData_processamento(String data_processamento) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(data_processamento);
		this.data_processamento = parsedDate;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) throws ParseException {
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "br"));
		double parsedNumber = nf.parse(saldo).doubleValue();
		this.saldo = parsedNumber;
	}
	
	
}
