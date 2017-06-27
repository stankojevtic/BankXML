package xml.ws.endpoint.firma;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import xml.banka.servis.StavkaPresekaServis;
import xml.ws.izvod.IzvodRequest;
import xml.ws.izvod.IzvodResponse;
import xml.ws.izvod.TStavkaPreseka;
import xml.ws.izvod.TZaglavljePreseka;
import xml.ws.izvod.TZahtev;

@Endpoint
public class IzvodEndpoint {

	private static final String NAMESPACE_URI = "http://xml/ws/Izvod";
	@Autowired
	private StavkaPresekaServis stavkaServis;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "IzvodRequest")
	@ResponsePayload
	public IzvodResponse primiNalog(@RequestPayload IzvodRequest request) {
		
		TZahtev zahtev = request.getZahtev();
		IzvodResponse response = new IzvodResponse();
		TZaglavljePreseka zaglavlje = new TZaglavljePreseka();
		zaglavlje.setZahtev(zahtev);
		ArrayList<TStavkaPreseka> stavke = stavkaServis.findStavke(zahtev.getDatum(), 
			zahtev.getBrojRacuna(), zahtev.getRedniBrojPreseka());
		
		response.setZaglavljePreseka(zaglavlje);
		response.getStavkaPreseka().addAll(stavke);
		return response;
	}
}
