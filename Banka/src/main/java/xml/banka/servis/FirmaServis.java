package xml.banka.servis;

import java.math.BigDecimal;

import xml.TFirma;

public interface FirmaServis {

	public TFirma findByName(String name);
	public TFirma findByRacun(String name);
	public void updateNovac(BigDecimal novac, TFirma firma);
}
