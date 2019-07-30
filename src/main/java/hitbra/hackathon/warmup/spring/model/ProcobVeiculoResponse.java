package hitbra.hackathon.warmup.spring.model;


public class ProcobVeiculoResponse {
    private String code;
    private String message;
    private ProcobContentResponse content;
    

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