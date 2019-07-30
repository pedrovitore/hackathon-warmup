package hitbra.hackathon.warmup.spring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcobDadosGravamesResponse {

	private int ano_modelo;
    private String remarcacao_chassi;
    private String chassi_retorno;
    private String codigo_agente;
    private String cgc_agente;
    private String cpfcnpj;
    private Date data_emissao;
    private Date data_inclusao_gravame;
    private Date data_vigencia_contrato;
    private String nome_agente;
    private String nome_financiado;
    private int numero_contrato;
    private int numero_restricao;
    private String placa;
    private String renavam;
    private String status_veiculo;
    private String tipo_restricao;
    private String uf_gravame;
    private String uf_placa;
	public int getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	public String getRemarcacao_chassi() {
		return remarcacao_chassi;
	}
	public void setRemarcacao_chassi(String remarcacao_chassi) {
		this.remarcacao_chassi = remarcacao_chassi;
	}
	public String getChassi_retorno() {
		return chassi_retorno;
	}
	public void setChassi_retorno(String chassi_retorno) {
		this.chassi_retorno = chassi_retorno;
	}
	public String getCodigo_agente() {
		return codigo_agente;
	}
	public void setCodigo_agente(String codigo_agente) {
		this.codigo_agente = codigo_agente;
	}
	public String getCgc_agente() {
		return cgc_agente;
	}
	public void setCgc_agente(String cgc_agente) {
		this.cgc_agente = cgc_agente;
	}
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	public Date getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(String data_emissao) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(data_emissao);
		this.data_emissao = parsedDate;
	}
	public Date getData_inclusao_gravame() {
		return data_inclusao_gravame;
	}
	public void setData_inclusao_gravame(String data_inclusao_gravame) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(data_inclusao_gravame);
		this.data_inclusao_gravame = parsedDate;
	}
	public Date getData_vigencia_contrato() {
		return data_vigencia_contrato;
	}
	public void setData_vigencia_contrato(String data_vigencia_contrato) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(data_vigencia_contrato);
		this.data_vigencia_contrato = parsedDate;
	}
	public String getNome_agente() {
		return nome_agente;
	}
	public void setNome_agente(String nome_agente) {
		this.nome_agente = nome_agente;
	}
	public String getNome_financiado() {
		return nome_financiado;
	}
	public void setNome_financiado(String nome_financiado) {
		this.nome_financiado = nome_financiado;
	}
	public int getNumero_contrato() {
		return numero_contrato;
	}
	public void setNumero_contrato(int numero_contrato) {
		this.numero_contrato = numero_contrato;
	}
	public int getNumero_restricao() {
		return numero_restricao;
	}
	public void setNumero_restricao(int numero_restricao) {
		this.numero_restricao = numero_restricao;
	}
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
	public String getStatus_veiculo() {
		return status_veiculo;
	}
	public void setStatus_veiculo(String status_veiculo) {
		this.status_veiculo = status_veiculo;
	}
	public String getTipo_restricao() {
		return tipo_restricao;
	}
	public void setTipo_restricao(String tipo_restricao) {
		this.tipo_restricao = tipo_restricao;
	}
	public String getUf_gravame() {
		return uf_gravame;
	}
	public void setUf_gravame(String uf_gravame) {
		this.uf_gravame = uf_gravame;
	}
	public String getUf_placa() {
		return uf_placa;
	}
	public void setUf_placa(String uf_placa) {
		this.uf_placa = uf_placa;
	}
    
    
}
