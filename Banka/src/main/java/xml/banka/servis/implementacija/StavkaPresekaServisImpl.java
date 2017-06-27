package xml.banka.servis.implementacija;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.banka.repozitorijum.StavkaPresekaRepozitorijum;
import xml.banka.servis.StavkaPresekaServis;
import xml.ws.izvod.TStavkaPreseka;

@Service
public class StavkaPresekaServisImpl implements StavkaPresekaServis{

	@Autowired
	private StavkaPresekaRepozitorijum repozitorijum;
	
	@Override
	public void save(TStavkaPreseka stavka) {
		repozitorijum.save(stavka);
	}

	@Override
	public ArrayList<TStavkaPreseka> findStavke(Date date, String racun, int presek) {
		
		ArrayList<TStavkaPreseka> stavke = (ArrayList<TStavkaPreseka>) repozitorijum.findAll();
		ArrayList<TStavkaPreseka> temp = new ArrayList<TStavkaPreseka>();
		
		 Calendar cal = Calendar.getInstance();
		 Calendar cal2 = Calendar.getInstance();
		 cal.setTime(date);
		 cal.set(Calendar.HOUR_OF_DAY, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND, 0);
		 cal.set(Calendar.MILLISECOND, 0);
		 cal2.set(Calendar.HOUR_OF_DAY, 0);
		 cal2.set(Calendar.MINUTE, 0);
		 cal2.set(Calendar.SECOND, 0);
		 cal2.set(Calendar.MILLISECOND, 0);
		 
		
		for(int i=0; i<stavke.size(); i++){
			Date date2 = stavke.get(i).getNalog().getDatumNaloga();
			String racun2 = stavke.get(i).getNalog().getDuznikRacun().getRacun();
			cal2.setTime(date2);
			System.out.println(cal.getTime());
			System.out.println(cal2.getTime());
			if(cal.getTime().equals(cal2.getTime())){
				if(racun2.equals(racun))
					temp.add(stavke.get(i));
			}
				
		}
		stavke = new ArrayList<TStavkaPreseka>();
		if(temp.size() > 2*presek-2 && temp.size() > 2*presek-1){
			stavke.add(temp.get(2*presek-2));
			stavke.add(temp.get(2*presek-1));
		}
		return stavke;
	}

	
	
}
