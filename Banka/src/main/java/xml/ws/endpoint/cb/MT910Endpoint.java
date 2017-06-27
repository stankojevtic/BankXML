package xml.ws.endpoint.cb;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import xml.ws.mt900.MT900Request;
import xml.ws.mt900.MT900Response;

@Endpoint
public class MT910Endpoint {

	private static final String NAMESPACE_URI = "http://xml/ws/MT910";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "MT910Request")
	@ResponsePayload
	public MT900Response delegate(@RequestPayload MT900Request request) {
		
		MT900Response response = new MT900Response();
		response.setOdgovor("Obavestenje o uplacivanju - MT910");
		return response;
		
	}
}
