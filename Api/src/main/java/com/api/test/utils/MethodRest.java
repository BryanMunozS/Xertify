package com.api.test.utils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author Bryan Muñoz
 *
 * @param <T>
 */
@Component
public class MethodRest<T> {
	private HttpStatus status;
	private String server;
	private RestTemplate rest;
	private HttpHeaders headers;

	/**
	 * Metodo constructor de la clase
	 */
	public MethodRest() {

		CloseableHttpClient httpClient
	      = HttpClients.custom()
	        .setSSLHostnameVerifier(new NoopHostnameVerifier())
	        .build();
	    HttpComponentsClientHttpRequestFactory requestFactory 
	      = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
	    requestFactory.setHttpClient(httpClient);
		rest = new RestTemplate(requestFactory);
		
		headers = new HttpHeaders();
		server = ConstantsApi.SERVER;
		headers.add(ConstantsApi.HEADER_CONTENT_TYPE, ConstantsApi.HEADER_APP_JSON);
		headers.add(ConstantsApi.HEADER_ACCEPT, "*/*");
	}

	/**
	 * Metodo que permite realizar una peticion post a un servicio web
	 *
	 * @param dto El dto que se utilizara para realizar la peticion post
	 * @param c   la clase del dto para identificarlo
	 * @param uri la url a la que enviaremos el dto
	 * @return la respuesta de la api
	 */
	public T post(String dto, Class<T> type, String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>(dto, headers);
		ResponseEntity<T> responseEntity = rest.exchange(server + uri, HttpMethod.POST, requestEntity, type);
		setStatus(responseEntity.getStatusCode());
		return (T) responseEntity.getBody();
	}

	/**
	 * Metodo que permite realizar una peticion get a un servicio web
	 *
	 * @param uri url a la que se realizara la peticion
	 * @param c   clase para saber lo que devolvera la peticion
	 * @return una lista, objeto o consulta solicitada
	 */
	public T get(String uri, ParameterizedTypeReference<T> type) {
		HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
		ResponseEntity<T> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, type);
		this.setStatus(responseEntity.getStatusCode());
		return (T) responseEntity.getBody();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public RestTemplate getRest() {
		return rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}

}
