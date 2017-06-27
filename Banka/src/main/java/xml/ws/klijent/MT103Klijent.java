package xml.ws.klijent;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import xml.Banka;
import xml.ws.mt103.MT103Request;
import xml.ws.mt103.MT103Response;
import xml.ws.nalogzaprenos.NalogZaPrenosRequest;

@Component
public class MT103Klijent  extends WebServiceGatewaySupport {

	public void sendMT103(NalogZaPrenosRequest request, Banka duznik, Banka poverioc){
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(MT103Request.class, MT103Response.class);

		MT103Request req = new MT103Request();
		req.setIDPoruke("slanje od  banke a do banke b");
		req.setBankaDuznika(duznik.getRacun());
		req.setBankaPoverioca(poverioc.getRacun());
		req.setNalog(request.getNalog());
		req.setSifraValute(request.getOznakaValute());
		
		getWebServiceTemplate().setMarshaller(marshaller);
		getWebServiceTemplate().setUnmarshaller(marshaller);
		String putanja = "http://localhost:9999/ws/MT103/";
		getWebServiceTemplate().setDefaultUri(putanja);
		Object o = getWebServiceTemplate().marshalSendAndReceive(req);
		MT103Response response = (MT103Response) o;
		System.out.println(response.getOdgovor());
		
	}
}