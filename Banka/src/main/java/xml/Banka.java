package xml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import xml.ws.mt103.TSWIFTIRacun;

@Entity
public class Banka {
	
	@GeneratedValue
	@Id
	private Long id;
	@Column
	private String port;
	@OneToOne
	@JsonIgnore
	private TFirma firma;
	@OneToOne
	@JoinColumn(name = "racun_id")
	private TSWIFTIRacun racun;
	
	public Banka(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}

	public TFirma getFirma() {
		return firma;
	}

	public void setFirma(TFirma firma) {
		this.firma = firma;
	}

	public TSWIFTIRacun getRacun() {
		return racun;
	}

	public void setRacun(TSWIFTIRacun racun) {
		this.racun = racun;
	}

	
}
