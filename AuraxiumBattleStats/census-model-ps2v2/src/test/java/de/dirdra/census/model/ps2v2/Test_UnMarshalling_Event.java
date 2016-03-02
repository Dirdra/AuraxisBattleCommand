package de.dirdra.census.model.ps2v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dirdra.census.model.ps2v2.CommandType;
import de.dirdra.census.model.ps2v2.EventNames;
import de.dirdra.census.model.ps2v2.EventResponseType;

public class Test_UnMarshalling_Event extends CamelTestSupport {
	private static final Logger LOG = LoggerFactory.getLogger(Test_UnMarshalling_Event.class);

	private static final String FROM_COMMAND = "direct:testSendUnmarshal";
	private static final String FROM_RESPONSE = "direct:testResponseUnmarshal";

	private static final File TESTFOLDER_JSON_EVENTS = new File("src/test/resources/examples/ps2v2/event");

	@Before
	public void setup() throws Exception {
		super.setUp();
	}

	@Test
	public void testSubscription1() throws Exception {
		String inputStr = getTestfileLines("subscription1.json").get(0);
		
		CommandType response = template.requestBody(FROM_COMMAND, inputStr, CommandType.class);
		
		assertEquals("event", response.getService());
		assertEquals("subscribe", response.getAction());
		assertEquals("5428010618015189713", response.getCharacters().get(0));
		assertEquals(1, response.getCharacters().size());
		assertEquals(EventNames.DEATH, response.getEventNames().get(0));
		assertEquals(1, response.getEventNames().size());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testSubscription2() throws Exception {
		String inputStr = getTestfileLines("subscription2.json").get(0);
		
		CommandType response = template.requestBody(FROM_COMMAND, inputStr, CommandType.class);
		
		assertEquals("event", response.getService());
		assertEquals("subscribe", response.getAction());
		assertEquals("1", response.getWorlds().get(0));
		assertEquals(1, response.getWorlds().size());
		assertEquals(EventNames.PLAYER_LOGIN, response.getEventNames().get(0));
		assertEquals(1, response.getEventNames().size());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testSubscription3() throws Exception {
		String inputStr = getTestfileLines("subscription3.json").get(0);
		
		CommandType response = template.requestBody(FROM_COMMAND, inputStr, CommandType.class);
		
		assertEquals("event", response.getService());
		assertEquals("subscribe", response.getAction());
		assertEquals("all", response.getCharacters().get(0));
		assertEquals(1, response.getCharacters().size());
		assertEquals("all", response.getWorlds().get(0));
		assertEquals(1, response.getWorlds().size());
		assertEquals(EventNames.ALL, response.getEventNames().get(0));
		assertEquals(1, response.getEventNames().size());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testSubscription4() throws Exception {
		String inputStr = getTestfileLines("subscription4.json").get(0);
		
		CommandType response = template.requestBody(FROM_COMMAND, inputStr, CommandType.class);
		
		assertEquals("event", response.getService());
		assertEquals("subscribe", response.getAction());
		assertEquals("1", response.getCharacters().get(0));
		assertEquals("2", response.getCharacters().get(1));
		assertEquals(2, response.getCharacters().size());
		assertEquals(EventNames.BATTLE_RANK_UP, response.getEventNames().get(0));
		assertEquals(EventNames.DEATH, response.getEventNames().get(1));
		assertEquals(EventNames.FACILITY_CONTROL, response.getEventNames().get(2));
		assertEquals(EventNames.GAIN_EXPERIENCE, response.getEventNames().get(3));
		assertEquals(EventNames.ITEM_ADDED, response.getEventNames().get(4));
		assertEquals(EventNames.METAGAME_EVENT, response.getEventNames().get(5));
		assertEquals(EventNames.PLAYER_FACILITY_CAPTURE, response.getEventNames().get(6));
		assertEquals(EventNames.PLAYER_FACILITY_DEFEND, response.getEventNames().get(7));
		assertEquals(EventNames.PLAYER_LOGIN, response.getEventNames().get(8));
		assertEquals(EventNames.PLAYER_LOGOUT, response.getEventNames().get(9));
		assertEquals(EventNames.SKILL_ADDED, response.getEventNames().get(10));
		assertEquals(EventNames.VEHICLE_DESTROY, response.getEventNames().get(11));
		assertEquals("1", response.getWorlds().get(0));
		assertEquals("2", response.getWorlds().get(1));
		assertEquals(2, response.getWorlds().size());
		assertEquals(12, response.getEventNames().size());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testClearSubscription1() throws Exception {
		String inputStr = getTestfileLines("clearSubscription1.json").get(0);
		
		CommandType response = template.requestBody(FROM_COMMAND, inputStr, CommandType.class);
		
		assertEquals("event", response.getService());
		assertEquals("clearSubscribe", response.getAction());
		assertEquals("1", response.getCharacters().get(0));
		assertEquals("2", response.getCharacters().get(1));
		assertEquals(2, response.getCharacters().size());
		assertEquals("1", response.getWorlds().get(0));
		assertEquals("2", response.getWorlds().get(1));
		assertEquals(2, response.getWorlds().size());
		assertEquals(EventNames.BATTLE_RANK_UP, response.getEventNames().get(0));
		assertEquals(EventNames.DEATH, response.getEventNames().get(1));
		assertEquals(EventNames.FACILITY_CONTROL, response.getEventNames().get(2));
		assertEquals(EventNames.GAIN_EXPERIENCE, response.getEventNames().get(3));
		assertEquals(EventNames.ITEM_ADDED, response.getEventNames().get(4));
		assertEquals(EventNames.METAGAME_EVENT, response.getEventNames().get(5));
		assertEquals(EventNames.PLAYER_FACILITY_CAPTURE, response.getEventNames().get(6));
		assertEquals(EventNames.PLAYER_FACILITY_DEFEND, response.getEventNames().get(7));
		assertEquals(EventNames.PLAYER_LOGIN, response.getEventNames().get(8));
		assertEquals(EventNames.PLAYER_LOGOUT, response.getEventNames().get(9));
		assertEquals(EventNames.SKILL_ADDED, response.getEventNames().get(10));
		assertEquals(EventNames.VEHICLE_DESTROY, response.getEventNames().get(11));
		assertEquals(12, response.getEventNames().size());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testClearSubscription2() throws Exception {
		String inputStr = getTestfileLines("clearSubscription2.json").get(0);
		
		CommandType response = template.requestBody(FROM_COMMAND, inputStr, CommandType.class);
		
		assertEquals("event", response.getService());
		assertEquals("clearSubscribe", response.getAction());
		assertEquals(true, response.isAll());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testCommand1() throws Exception {
		String inputStr = getTestfileLines("command1.json").get(0);
		
		CommandType response = template.requestBody(FROM_COMMAND, inputStr, CommandType.class);
		
		assertEquals("event", response.getService());
		assertEquals("echo", response.getAction());
		assertEquals("test", response.getPayload().getTest());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testPayload1() throws Exception {
		String inputStr = getTestfileLines("payload1.json").get(0);
		
		EventResponseType response = template.requestBody(FROM_RESPONSE, inputStr, EventResponseType.class);
		
		assertEquals("event", response.getService());
		assertEquals("serviceMessage", response.getType());
		assertEquals("5428010618015189713", response.getPayload().getAttackerCharacterId());
		assertEquals((Integer)26103, response.getPayload().getAttackerFireModeId());
		assertEquals((Integer)15, response.getPayload().getAttackerLoadoutId());
		assertEquals((Integer)0, response.getPayload().getAttackerVehicleId());
		assertEquals((Integer)26003, response.getPayload().getAttackerWeaponId());
		assertEquals("5428168624838258657", response.getPayload().getCharacterId());
		assertEquals((Integer)6, response.getPayload().getCharacterLoadoutId());
		assertEquals("Death", response.getPayload().getEventName());
		assertEquals((Integer)1, response.getPayload().getIsHeadshot());
		assertEquals(1392056954L, response.getPayload().getTimestamp());
		assertEquals((Integer)0, response.getPayload().getVehicleId());
		assertEquals(1, response.getPayload().getWorldId());
		assertEquals((Integer)2, response.getPayload().getZoneId());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testPayload2() throws Exception {
		String inputStr = getTestfileLines("payload2.json").get(0);
		
		EventResponseType response = template.requestBody(FROM_RESPONSE, inputStr, EventResponseType.class);
		
		assertEquals("event", response.getService());
		assertEquals("serviceMessage", response.getType());
		assertEquals("5428057349740067905", response.getPayload().getCharacterId());
		assertEquals("PlayerLogin", response.getPayload().getEventName());
		assertEquals(1397251287L, response.getPayload().getTimestamp());
		assertEquals(1, response.getPayload().getWorldId());
		
		LOG.info("repsonse > {}", response);		
	}
	
	@Test
	public void testTestpayload() throws Exception {
		List<String> inputStrs = getTestfileLines("payload2.json");
		
		for (String str: inputStrs) {
			EventResponseType response = template.requestBody(FROM_RESPONSE, str, EventResponseType.class);
			LOG.info("repsonse > {}", response);
		}				
	}

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				JacksonDataFormat dfCommandType = new JacksonDataFormat(CommandType.class);
				dfCommandType.setPrettyPrint(true);
				
				JacksonDataFormat dfEventResponse = new JacksonDataFormat(EventResponseType.class);
				dfCommandType.setPrettyPrint(true);

				//@formatter:off
				from(FROM_COMMAND)
					.unmarshal(dfCommandType);
				
				from(FROM_RESPONSE)
					.unmarshal(dfEventResponse);
				//@formatter:on
			}
		};
	}

	private BufferedReader getBufferedReaderForTestfile(String filename) throws FileNotFoundException {
		return new BufferedReader(new FileReader(new File(TESTFOLDER_JSON_EVENTS, filename)));
	}
	
	private List<String> getTestfileLines(String filename) throws IOException {
		BufferedReader reader = getBufferedReaderForTestfile(filename);
		
		List<String> lines = new LinkedList<String>();
		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		
		reader.close();
		
		return lines;
	}
}
