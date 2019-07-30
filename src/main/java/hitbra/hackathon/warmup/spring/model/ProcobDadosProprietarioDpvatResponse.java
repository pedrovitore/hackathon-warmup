package hitbra.hackathon.warmup.spring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcobDadosProprietarioDpvatResponse {

	 private String documento;
	 private String tipo_documento;
	 private String nome;
	 private Date data_nascimento;
	 private int idade;
	 private String signo;
	 private String obito;
	 private String sexo;
	 private String uf;
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(data_nascimento);
		this.data_nascimento = parsedDate;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public String getObito() {
		return obito;
	}
	public void setObito(String obito) {
		this.obito = obito;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	 
	 
}
