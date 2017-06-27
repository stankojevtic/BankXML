package xml.banka.servis.implementacija;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.TFirma;
import xml.banka.repozitorijum.FirmaRepozitorijum;
import xml.banka.servis.FirmaServis;

@Service
public class FirmaServisImpl implements FirmaServis {
	
	@Autowired
	private FirmaRepozitorijum repozitorijum;

	@Override
	public TFirma findByName(String name) {
		return repozitorijum.findByNaziv(name).get(0);
	}

	@Override
	public TFirma findByRacun(String name) {
		return repozitorijum.findByRacun(name);
	}

	@Override
	public void updateNovac(BigDecimal novac, TFirma firma) {
		repozitorijum.updateNovac(novac, firma.getId());
		
	}
}
