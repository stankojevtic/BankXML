package xml.banka.servis;

import xml.ws.nalogzaprenos.TPodaciORacunu;

public interface RacunServis  {

	public TPodaciORacunu findByRacun(String racun);
}
