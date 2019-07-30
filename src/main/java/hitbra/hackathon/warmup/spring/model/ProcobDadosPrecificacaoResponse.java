package hitbra.hackathon.warmup.spring.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ProcobDadosPrecificacaoResponse {

	private String codigo;
	private String marca;
	private String modelo;
	private Double preco_medio;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public Double getPreco_medio() {
		return preco_medio;
	}
	public void setPreco_medio(String preco_medio) throws ParseException {
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "br"));
		double parsedNumber = nf.parse(preco_medio).doubleValue();
		this.preco_medio = parsedNumber;
	}
	
	
}
