package hitbra.hackathon.warmup.spring.model;

public class ProcobScoreResponse {

	private String pontuacao;
	private String descricao_pontuacao;
	private int aceitacao;
	private int percentual_sobre_tabela_referencia;
	private String exige_vistoria_especial;
	public String getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getDescricao_pontuacao() {
		return descricao_pontuacao;
	}
	public void setDescricao_pontuacao(String descricao_pontuacao) {
		this.descricao_pontuacao = descricao_pontuacao;
	}
	public int getAceitacao() {
		return aceitacao;
	}
	public void setAceitacao(int aceitacao) {
		this.aceitacao = aceitacao;
	}
	public int getPercentual_sobre_tabela_referencia() {
		return percentual_sobre_tabela_referencia;
	}
	public void setPercentual_sobre_tabela_referencia(int percentual_sobre_tabela_referencia) {
		this.percentual_sobre_tabela_referencia = percentual_sobre_tabela_referencia;
	}
	public String getExige_vistoria_especial() {
		return exige_vistoria_especial;
	}
	public void setExige_vistoria_especial(String exige_vistoria_especial) {
		this.exige_vistoria_especial = exige_vistoria_especial;
	}
	
	
}
