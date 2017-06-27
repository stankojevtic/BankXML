package xml.banka.servis;

import java.util.ArrayList;
import java.util.Date;

import xml.ws.izvod.TStavkaPreseka;

public interface StavkaPresekaServis {

	public void save(TStavkaPreseka stavka);
	public ArrayList<TStavkaPreseka> findStavke(Date date, String racun, int presek);
}
