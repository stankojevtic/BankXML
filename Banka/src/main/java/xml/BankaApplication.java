package xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class BankaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankaApplication.class, args);
		
		//MT102Request request102 = new MT102Request();
		//MT103Request request103 = new MT103Request();
		
		//BankaKlijent klijent = new BankaKlijent();
		//klijent.posaljiMT103(request103);
	}
}
