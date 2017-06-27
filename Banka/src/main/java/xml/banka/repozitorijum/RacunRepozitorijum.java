package xml.banka.repozitorijum;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import xml.ws.nalogzaprenos.TPodaciORacunu;

public interface RacunRepozitorijum extends JpaRepository<TPodaciORacunu, Long> {

	ArrayList<TPodaciORacunu> findByRacun(String racun);
}
