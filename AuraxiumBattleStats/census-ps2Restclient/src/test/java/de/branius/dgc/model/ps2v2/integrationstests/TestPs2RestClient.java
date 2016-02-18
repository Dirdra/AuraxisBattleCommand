package de.branius.dgc.model.ps2v2.integrationstests;

import javax.xml.bind.JAXBException;

import org.apache.camel.CamelContext;
import org.apache.camel.component.restlet.RestletComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.restlet.Component;

import de.brainius.dgc.api.ps2v2.impl.rest.Ps2RestClient;
import de.brainius.dgc.ps2.census.model.ps2v2.SingleCharacterByIdList;
import de.branius.dgc.api.ps2v2.test.TestConstants;

public class TestPs2RestClient {
	private Ps2RestClient unitUnderTest;
	private CamelContext camelContext;
	private static final String DIRDRA_CHARID = "5428011263306871633";
	
	public TestPs2RestClient() {
		camelContext = new DefaultCamelContext();		
		camelContext.addComponent("restlet", new RestletComponent(new Component()));
	}
	
	@Before
	public void setup() throws JAXBException {
		unitUnderTest = new Ps2RestClient(camelContext);
		unitUnderTest.setCensusServerAdress(TestConstants.CENSUSSERVERADDR);
		unitUnderTest.setPs2namespace(TestConstants.PS2NAMESPACE);
		unitUnderTest.setServiceID(TestConstants.SERVICEID);
	}
	
	@Test
	public void testGetCharDirdra() throws Exception {
		SingleCharacterByIdList response = unitUnderTest.getData("single_character_by_id", SingleCharacterByIdList.class, "id="+DIRDRA_CHARID);
		
		Assert.assertEquals("Dirdra", response.getSingleCharacterById().get(0).getName().getFirst());
	}
}
