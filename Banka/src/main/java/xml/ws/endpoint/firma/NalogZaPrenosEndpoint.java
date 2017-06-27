package xml.ws.endpoint.firma;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import xml.Banka;
import xml.TFirma;
import xml.banka.servis.FirmaServis;
import xml.banka.servis.RacunServis;
import xml.banka.servis.StavkaPresekaServis;
import xml.ws.izvod.TStavkaPreseka;
import xml.ws.klijent.MT102Klijent;
import xml.ws.klijent.MT103Klijent;
import xml.ws.nalogzaprenos.NalogZaPrenosRequest;

@Endpoint
public class NalogZaPrenosEndpoint {
	
	private static final String NAMESPACE_URI = "http://xml/ws/NalogZaPrenos";
	@Autowired
	private StavkaPresekaServis stavkaServis;
	@Autowired
	private RacunServis racunServis;
	@Autowired
	private FirmaServis firmaServis;
	@Autowired
	private MT102Klijent mt102;
	@Autowired
	private MT103Klijent mt103;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "NalogZaPrenosRequest")
	@ResponsePayload
	public void primiNalog(@RequestPayload NalogZaPrenosRequest request) {
		
		TStavkaPreseka stavka = new TStavkaPreseka();
		stavka.setSmer("a");
		request.getNalog().setDuznikRacun(racunServis.
				findByRacun(request.getNalog().getDuznikRacun().getRacun()));
		request.getNalog().setPoverilacRacun(racunServis.
				findByRacun(request.getNalog().getPoverilacRacun().getRacun()));
		stavka.setNalog(request.getNalog());
		stavkaServis.save(stavka);
		
		BigDecimal iznos = new BigDecimal("250000");
		String racun1 = request.getNalog().getDuznikRacun().getRacun();
		TFirma firma1 = firmaServis.findByRacun(racun1);
		Banka bank1 = firma1.getBanka();
		String racun2 = request.getNalog().getPoverilacRacun().getRacun();
		TFirma firma2 = firmaServis.findByRacun(racun2);
		Banka bank2 = firma2.getBanka();
		
		BigDecimal novac = firma1.getNovac().subtract(request.getNalog().getIznos());
		firmaServis.updateNovac(novac, firma1);
		
		if(bank1.getId().equals(bank2.getId())){
			novac = firma2.getNovac().add(request.getNalog().getIznos());
			firmaServis.updateNovac(novac, firma2);
		}else if(request.isHitno() || (request.getNalog().getIznos().compareTo(iznos) > 0) ){
			mt103.sendMT103(request, bank1, bank2);
		}else{
			mt102.sendMT102(request, bank1, bank2);
		}
	}


}
