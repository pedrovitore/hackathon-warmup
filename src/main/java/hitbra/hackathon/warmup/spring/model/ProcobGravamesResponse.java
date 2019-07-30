package hitbra.hackathon.warmup.spring.model;

public class ProcobGravamesResponse {

	private String existe_informacao;
	private String chassi;
	private ProcobDadosGravamesResponse[] dados_gravames;
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
	public ProcobDadosGravamesResponse[] getDados_gravames() {
		return dados_gravames;
	}
	public void setDados_gravames(ProcobDadosGravamesResponse[] dados_gravames) {
		this.dados_gravames = dados_gravames;
	}
	
	
}
