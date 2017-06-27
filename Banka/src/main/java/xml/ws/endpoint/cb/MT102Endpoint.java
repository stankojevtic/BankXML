package xml.ws.endpoint.cb;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import xml.TFirma;
import xml.banka.servis.FirmaServis;
import xml.ws.mt102.MT102Request;
import xml.ws.mt102.MT102Response;

@Endpoint
public class MT102Endpoint {


	private static final String NAMESPACE_URI = "http://xml/ws/MT102";
	@Autowired
	private FirmaServis firmaServis;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "MT102Request")
	@ResponsePayload
	public MT102Response delegate(@RequestPayload MT102Request request) {
		
		String racun1 = request.getPojedinacnoPlacanje().get(0).getPoverilacRacun().getRacun();
		TFirma firma1 = firmaServis.findByRacun(racun1);
		BigDecimal novac = firma1.getNovac().subtract(request.getUkupanIznos());
		firmaServis.updateNovac(novac, firma1);
		
		MT102Response response = new MT102Response();
		response.setOdgovor("Dosao MT102");
		return response;
	}
}
