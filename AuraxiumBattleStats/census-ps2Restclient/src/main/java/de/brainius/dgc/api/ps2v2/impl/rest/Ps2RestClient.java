package de.brainius.dgc.api.ps2v2.impl.rest;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.brainius.dgc.ps2.census.model.ps2v2.CharacterList;
import de.branius.dgc.api.ps2v2.CensusDataApi;
import de.branius.dgc.api.ps2v2.exception.CensusException;
import de.branius.dgc.api.ps2v2.model.SearchPredicate;
import de.branius.dgc.model.ps2v2.Constants;

public class Ps2RestClient implements CensusDataApi {
	private static final Logger LOG = LoggerFactory.getLogger(Ps2RestClient.class);
	
	private static final String restComponente = "restlet";
	private static final String WEBPROTOCOL = "http";
	/**
	 * Template for endpoint<br>
	 * Params:<br>
	 * <ol>
	 * <li>restcomponent</li>
	 * <li>webprotocol</li>
	 * <li>servername</li>
	 * <li>serviceID</li>
	 * <li>verb</li>
	 * <li>ps2namespace</li>
	 * <li>query</li>
	 * </ol>
	 */
	private static final String ENDPOINT_TEMPLATE = "%s:%s://%s/%s/xml/%s/%s/%s";

	private static final String QUERY_COMMAND_SEPARATOR = "&";
	private static final String QUERY_COMMAND_APPENDER = "?";
	
	private CamelContext camelContext;	
	private ProducerTemplate producer;
	
	private String censusServerAdress;
	private String serviceID;
	private String ps2namespace;

	private JAXBContext jaxbContext;
	private Unmarshaller unmarshaller;
	
	public Ps2RestClient(CamelContext camelContext) throws JAXBException {
		producer = camelContext.createProducerTemplate();
		jaxbContext = JAXBContext.newInstance(Constants.CONTEXT_PATH);
		unmarshaller = jaxbContext.createUnmarshaller();
	}

	@SuppressWarnings("unchecked")
	public <T> T getData(String collection, Class<T> responseType, String... queryCommands) throws CensusException {
		LOG.debug("getData collection>{}, responseType>{}, queryCommands>{}", new Object[] {collection, responseType.getName(), queryCommands});
		String response = producer.requestBody(getEndpoint(collection, de.branius.dgc.api.ps2v2.Constants.VERB_GET, queryCommands), StringUtils.EMPTY, String.class);
		LOG.trace("dataresponse>{}", response);
		try {
			return responseType.cast( ((JAXBElement<T>) unmarshaller.unmarshal(new StringReader(response))).getValue());
		} catch (JAXBException exception) {
			throw new CensusException(exception);
		}
	}
	
	private String getEndpoint(String collection, String verb, String... queryCommands) {		
		String queryCommand = StringUtils.join(queryCommands, QUERY_COMMAND_SEPARATOR);
		String query = collection;
		if (queryCommand != null) {
			query = query + QUERY_COMMAND_APPENDER + queryCommand;
		}

		String endpoint = String.format(ENDPOINT_TEMPLATE, restComponente, WEBPROTOCOL, censusServerAdress, serviceID, verb, ps2namespace, query);
		LOG.debug("created endpoint>{}", endpoint);
		return endpoint;
	}

	public CamelContext getCamelContext() {
		return camelContext;
	}

	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	public String getCensusServerAdress() {
		return censusServerAdress;
	}

	public void setCensusServerAdress(String censusServerAdress) {
		this.censusServerAdress = censusServerAdress;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getPs2namespace() {
		return ps2namespace;
	}

	public void setPs2namespace(String ps2namespace) {
		this.ps2namespace = ps2namespace;
	}

	public static String getRestcomponente() {
		return restComponente;
	}

	@Override
	public CharacterList searchCharacters(SearchPredicate... searchPredicats) throws CensusException {
		// TODO Auto-generated method stub
		return null;
	}
}
