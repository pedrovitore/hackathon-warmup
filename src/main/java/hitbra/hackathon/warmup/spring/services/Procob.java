package hitbra.hackathon.warmup.spring.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import hitbra.hackathon.warmup.spring.model.ProcobVeiculoResponse;


/**
 *
 * @author Pedro
 */
@Service
public class Procob {

    public static final String HOST = "https://api.procob.com";
    
    public ProcobVeiculoResponse getDadosVeiculo(String placa) {
    	UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("https").host("api.procob.com").path("/veiculos/v2/V0001")
			      .query("bin=SIM")
			      .query("dpvat=SIM")
			      .query("gravames=SIM")
			      .query("leilao=SIM")
			      .query("precificador=SIM")
			      .query("sinistro=SIM")
			      .query("placa="+placa)
			      .buildAndExpand();
			 
		ResponseEntity<ProcobVeiculoResponse> response = Procob.getResponse(uriComponents.toUriString());
		
		return response.getBody();
    }
    
   
    private static void printJsonString(InputStream conInputString) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(conInputString));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response.toString());
    }
    
    private static ResponseEntity<ProcobVeiculoResponse> getResponse(String url) {
    	RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("sandbox@procob.com", "TesteApi"));


		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(0, converter);

		ResponseEntity<ProcobVeiculoResponse> response = restTemplate.exchange(
				url,
				HttpMethod.GET, 
				null,
				ProcobVeiculoResponse.class);
		return response;
    }
}