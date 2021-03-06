//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.26 at 05:05:40 PM CEST 
//


package xml.ws.mt910;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import xml.ws.mt900.MT900Request;
import xml.ws.mt900.MT900Response;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xml.ws.mt910 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MT910Request_QNAME = new QName("http://xml/ws/MT910", "MT910Request");
    private final static QName _MT910Response_QNAME = new QName("http://xml/ws/MT910", "MT910Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xml.ws.mt910
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MT900Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml/ws/MT910", name = "MT910Request")
    public JAXBElement<MT900Request> createMT910Request(MT900Request value) {
        return new JAXBElement<MT900Request>(_MT910Request_QNAME, MT900Request.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MT900Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml/ws/MT910", name = "MT910Response")
    public JAXBElement<MT900Response> createMT910Response(MT900Response value) {
        return new JAXBElement<MT900Response>(_MT910Response_QNAME, MT900Response.class, null, value);
    }

}
