package xml.ws.endpoint.cb;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import xml.TFirma;
import xml.banka.servis.FirmaServis;
import xml.ws.mt103.MT103Request;
import xml.ws.mt103.MT103Response;

@Endpoint
public class MT103Endpoint {
	
	private static final String NAMESPACE_URI = "http://xml/ws/MT103";
	@Autowired
	private FirmaServis firmaServis;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "MT103Request")
	@ResponsePayload
	public MT103Response delegate(@RequestPayload MT103Request request) {
		
		String racun1 = request.getNalog().getPoverilacRacun().getRacun();
		TFirma firma1 = firmaServis.findByRacun(racun1);
		BigDecimal novac = firma1.getNovac().subtract(request.getNalog().getIznos());
		firmaServis.updateNovac(novac, firma1);
		
		MT103Response response = new MT103Response();
		response.setOdgovor("Dosao MT103");
		return response;
		
	}


}
