package xml;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServisConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "MT102")
	public DefaultWsdl11Definition mt102Wsdl11Definition(XsdSchema mt102Schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("MT102Port");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://xml/ws/MT102");
		wsdl11Definition.setSchema(mt102Schema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema mt102Schema() {
		return new SimpleXsdSchema(new ClassPathResource("seme/MT102.xsd"));
	}

	@Bean(name = "MT103")
	public DefaultWsdl11Definition mt103Wsdl11Definition(XsdSchema mt103Schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("MT103Port");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://xml/ws/MT103");
		wsdl11Definition.setSchema(mt103Schema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema mt103Schema() {
		return new SimpleXsdSchema(new ClassPathResource("seme/MT103.xsd"));
	}
	
	@Bean(name = "NalogZaPrenos")
	public DefaultWsdl11Definition nalogZaprenosWsdl11Definition(XsdSchema NalogZaPrenosSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("NalogZaPrenos");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://xml/ws/NalogZaPrenos");
		wsdl11Definition.setSchema(NalogZaPrenosSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema NalogZaPrenosSchema() {
		return new SimpleXsdSchema(new ClassPathResource("seme/NalogZaPrenos.xsd"));
	}
	
	@Bean(name = "Izvod")
	public DefaultWsdl11Definition izvodWsdl11Definition(XsdSchema IzvodSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("Izvod");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://xml/ws/Izvod");
		wsdl11Definition.setSchema(IzvodSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema IzvodSchema() {
		return new SimpleXsdSchema(new ClassPathResource("seme/PresekIzvoda.xsd"));
	}

}
