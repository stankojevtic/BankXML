package xml.banka.repozitorijum;

import org.springframework.data.jpa.repository.JpaRepository;

import xml.ws.izvod.TStavkaPreseka;

public interface StavkaPresekaRepozitorijum extends JpaRepository<TStavkaPreseka, Long> {

}
