package xml.banka.repozitorijum;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import xml.TFirma;

public interface FirmaRepozitorijum extends JpaRepository<TFirma, Long>{
	
	ArrayList<TFirma> findByNaziv(String naziv);
	TFirma findByRacun(String racun);
	@Modifying
	@Transactional
	@Query("update TFirma set novac = ? where id = ? ")
	public void updateNovac(BigDecimal novac, Long id);
}
