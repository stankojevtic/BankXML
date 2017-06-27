//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.26 at 05:05:40 PM CEST 
//


package xml.ws.mt103;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import xml.Banka;


/**
 * <p>Java class for TSWIFTIRacun complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TSWIFTIRacun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SWIFT" type="{http://xml/ws/MT103}TSWIFT"/>
 *         &lt;element name="ObracunskiRacun" type="{http://xml/ws/NalogZaPrenos}TBrojRacuna"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TSWIFTIRacun", propOrder = {
    "swift",
    "obracunskiRacun"
})
@Entity
public class TSWIFTIRacun {

	@GeneratedValue
	@Id
	@XmlTransient
	private Long id;
    @XmlElement(name = "SWIFT", required = true)
    @Column
    protected String swift;
    @XmlElement(name = "ObracunskiRacun", required = true)
    @Column
    protected String obracunskiRacun;
    @OneToOne
    @JsonIgnore
    @XmlTransient
    private Banka banka;
    

    /**
     * Gets the value of the swift property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFT() {
        return swift;
    }

    /**
     * Sets the value of the swift property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFT(String value) {
        this.swift = value;
    }

    /**
     * Gets the value of the obracunskiRacun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObracunskiRacun() {
        return obracunskiRacun;
    }

    /**
     * Sets the value of the obracunskiRacun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObracunskiRacun(String value) {
        this.obracunskiRacun = value;
    }

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}
    
    

}
