package hitbra.hackathon.warmup.spring.model;

public class ProcobDpvatResponse {

	private String placa;
	private ProcobDetalhesDpvatResponse[] detalhes;
	private ProcobDadosProprietarioDpvatResponse[] dados_proprietario;
	private ProcobEnderecoProprietarioDpvatResponse[] endereco_proprietario;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public ProcobDetalhesDpvatResponse[] getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(ProcobDetalhesDpvatResponse[] detalhes) {
		this.detalhes = detalhes;
	}
	public ProcobDadosProprietarioDpvatResponse[] getDados_proprietario() {
		return dados_proprietario;
	}
	public void setDados_proprietario(ProcobDadosProprietarioDpvatResponse[] dados_proprietario) {
		this.dados_proprietario = dados_proprietario;
	}
	public ProcobEnderecoProprietarioDpvatResponse[] getEndereco_proprietario() {
		return endereco_proprietario;
	}
	public void setEndereco_proprietario(ProcobEnderecoProprietarioDpvatResponse[] endereco_proprietario) {
		this.endereco_proprietario = endereco_proprietario;
	}
	
	
}
