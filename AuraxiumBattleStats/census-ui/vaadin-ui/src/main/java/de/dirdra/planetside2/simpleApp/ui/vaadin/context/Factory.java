package de.dirdra.planetside2.simpleApp.ui.vaadin.context;

import javax.xml.bind.JAXBException;

import org.apache.camel.CamelContext;
import org.apache.camel.component.restlet.RestletComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.restlet.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.brainius.dgc.api.ps2v2.impl.rest.Ps2RestClient;
import de.dirdra.planetside2.census.api.CensusDataApi;

public class Factory {
	private static final Logger LOG = LoggerFactory.getLogger(Factory.class);
	
	private static CamelContext camelContext;
	
	private static Ps2RestClient  censusDataApi;
	
	public static CensusDataApi getCensusDataApi() {
		if (censusDataApi == null) {
			try {
				censusDataApi = new Ps2RestClient(getCamelContext());
			} catch (JAXBException e) {
				LOG.error("Error while creating censusAPI-Client", e);
				throw new RuntimeException(e);
			}
			//TODO darf hier nicht stehen, sondern muss konfigurierbar sein
			censusDataApi.setCensusServerAdress("census.daybreakgames.com");
			censusDataApi.setPs2namespace("ps2:v2");
			censusDataApi.setServiceID("s:dirdraDev");
		}
		
		return censusDataApi;
	}
	
	public static CamelContext getCamelContext() {
		if (camelContext == null) {
			camelContext = new DefaultCamelContext();
			camelContext.addComponent("restlet", new RestletComponent(new Component()));
		}
		
		return camelContext;
	}
}
