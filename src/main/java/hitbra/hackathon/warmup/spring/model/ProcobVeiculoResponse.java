package hitbra.hackathon.warmup.spring.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import hitbra.hackathon.warmup.spring.services.Procob;

public class ProcobVeiculoResponse {
    private String code;
    private String message;
    private ProcobContentResponse content;
    

	public static void main(String args[]) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("https").host("api.procob.com")
			      .path("/veiculos/v2/V0001").query("bin=SIM").query("dpvat=SIM").query("gravames=SIM").query("leilao=SIM").query("precificador=SIM").query("sinistro=SIM").buildAndExpand();
			 
		ResponseEntity<ProcobVeiculoResponse> response = Procob.getResponse(uriComponents.toUriString());
		System.out.println(response.getBody().getContent().getSinistro().getResposta());
		
	}

	//GETTERS AND SETTERS
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ProcobContentResponse getContent() {
		return content;
	}

	public void setContent(ProcobContentResponse content) {
		this.content = content;
	}

}