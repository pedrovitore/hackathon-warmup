package hitbra.hackathon.warmup.spring.model;

public class ProcobLeilaoResponse {

	private String existe_informacao;
	private ProcobLeiloesResponse[] leiloes;
	private ProcobScoreResponse score;
	
	public String getExiste_informacao() {
		return existe_informacao;
	}
	public void setExiste_informacao(String existe_informacao) {
		this.existe_informacao = existe_informacao;
	}
	public ProcobLeiloesResponse[] getLeiloes() {
		return leiloes;
	}
	public void setLeiloes(ProcobLeiloesResponse[] leiloes) {
		this.leiloes = leiloes;
	}
	public ProcobScoreResponse getScore() {
		return score;
	}
	public void setScore(ProcobScoreResponse score) {
		this.score = score;
	}
	
	
}
