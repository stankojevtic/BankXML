package xml.banka.servis.implementacija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.banka.repozitorijum.RacunRepozitorijum;
import xml.banka.servis.RacunServis;
import xml.ws.nalogzaprenos.TPodaciORacunu;

@Service
public class RacunServisImpl implements RacunServis {

	@Autowired
	private RacunRepozitorijum repozitorijum;
	
	@Override
	public TPodaciORacunu findByRacun(String racun) {
		return repozitorijum.findByRacun(racun).get(0);
	}

}
