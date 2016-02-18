package de.brainius.dgc.census.model;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.brainius.dgc.ps2.census.model.ps2v2.CommandType;
import de.brainius.dgc.ps2.census.model.ps2v2.EventNames;

public class Test_Marshalling_Event extends CamelTestSupport {
	private static final Logger LOG = LoggerFactory.getLogger(Test_Marshalling_Event.class);

	private static final String FROM_COMMAND = "direct:commandIn";

	@Test
	public void testSubscription1() throws Exception {
		CommandType command = new CommandType();
		command.setService("event");
		command.setAction("subscripe");
		command.getCharacters().add("5428010618015189713");
		command.getEventNames().add(EventNames.DEATH);
		
		String response = template.requestBody(FROM_COMMAND, command, String.class);
		LOG.info("response > {}", response);
	}

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				JacksonDataFormat dfCommand = new JacksonDataFormat(CommandType.class);
				dfCommand.setInclude("NON_NULL");

				// @formatter:off
				from(FROM_COMMAND)
					.marshal(dfCommand);
				// @formatter:on
			}
		};
	}
}
