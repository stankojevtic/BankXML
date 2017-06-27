package xml.ws.klijent;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import xml.Banka;
import xml.ws.mt102.MT102Request;
import xml.ws.mt102.MT102Response;
import xml.ws.mt102.TPojedinacnoPlacanje;
import xml.ws.nalogzaprenos.NalogZaPrenosRequest;
import xml.ws.nalogzaprenos.TNalog;

@Component
@Scope
public class MT102Klijent extends WebServiceGatewaySupport {

	private ArrayList<TPojedinacnoPlacanje> stavke = new ArrayList<TPojedinacnoPlacanje>();
	
	public void sendMT102(NalogZaPrenosRequest request, Banka duznik, Banka poverioc){

		MT102Request req = new MT102Request();
		req.setIDPoruke("slanje od  banke a do banke b");
		req.setBankaDuznika(duznik.getRacun());
		req.setBankaPoverioca(poverioc.getRacun());
		req.setSifraValute(request.getOznakaValute());
		req.setDatum(request.getNalog().getDatumNaloga());
		
		TPojedinacnoPlacanje t = new TPojedinacnoPlacanje();
		TNalog nalog = request.getNalog();
		t.setDuznik(nalog.getDuznik());
		t.setDatumNaloga(nalog.getDatumNaloga());
		t.setDuznikRacun(t.getDuznikRacun());
		t.setIznos(nalog.getIznos());
		t.setPoverilacRacun(t.getPoverilacRacun());
		t.setPrimalac(nalog.getPrimalac());
		t.setSifraValute(request.getOznakaValute());
		t.setSvrhaPlacanja(nalog.getSvrhaPlacanja());
		t.setIDNalogaZaPlacanje(nalog.getPoverilacRacun().getRacun());
		req.getPojedinacnoPlacanje().addAll(stavke);
		BigDecimal ukupno = ukupanIznos();
		stavke.add(t);
		req.setUkupanIznos(ukupno);
		
		if(stavke.size()==2){
			stavke.clear();
			Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
			marshaller.setClassesToBeBound(MT102Request.class, MT102Response.class);
			getWebServiceTemplate().setMarshaller(marshaller);
			getWebServiceTemplate().setUnmarshaller(marshaller);
			String putanja = "http://localhost:9999/ws/MT102/";
			getWebServiceTemplate().setDefaultUri(putanja);
			getWebServiceTemplate().marshalSendAndReceive(req);
		}
	}
	
		public BigDecimal ukupanIznos(){
			
			BigDecimal temp = new BigDecimal(0);
			for(int i=0; i<stavke.size(); i++){
				temp.add(stavke.get(i).getIznos());
			}
			return temp;
		}

}
