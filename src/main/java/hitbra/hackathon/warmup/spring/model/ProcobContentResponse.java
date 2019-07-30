package hitbra.hackathon.warmup.spring.model;

public class ProcobContentResponse {

	private ProcobBinResponse bin;
	private ProcobDpvatResponse dpvat;
	private ProcobGravamesResponse gravames;
	private ProcobLeilaoResponse leilao;
	private ProcobPrecificadorResponse precificador;
	private ProcobSinistroResponse sinistro;
	
	//GETTERS AND SETTERS
	public ProcobBinResponse getBin() {
		return bin;
	}

	public void setBin(ProcobBinResponse bin) {
		this.bin = bin;
	}

	public ProcobDpvatResponse getDpvat() {
		return dpvat;
	}

	public void setDpvat(ProcobDpvatResponse dpvat) {
		this.dpvat = dpvat;
	}

	public ProcobGravamesResponse getGravames() {
		return gravames;
	}

	public void setGravames(ProcobGravamesResponse gravames) {
		this.gravames = gravames;
	}

	public ProcobLeilaoResponse getLeilao() {
		return leilao;
	}

	public void setLeilao(ProcobLeilaoResponse leilao) {
		this.leilao = leilao;
	}

	public ProcobPrecificadorResponse getPrecificador() {
		return precificador;
	}

	public void setPrecificador(ProcobPrecificadorResponse precificador) {
		this.precificador = precificador;
	}

	public ProcobSinistroResponse getSinistro() {
		return sinistro;
	}

	public void setSinistro(ProcobSinistroResponse sinistro) {
		this.sinistro = sinistro;
	}
	
	
	
}
