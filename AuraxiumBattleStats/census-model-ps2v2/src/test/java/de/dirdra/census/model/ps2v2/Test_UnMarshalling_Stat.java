package de.dirdra.census.model.ps2v2;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dirdra.census.model.ps2v2.Constants;

@RunWith(Parameterized.class)
public class Test_UnMarshalling_Stat {
	private static final Logger LOG = LoggerFactory.getLogger(Test_UnMarshalling_Stat.class);

	private static final String resourcePrefix = "examples/ps2v2/stat/";
	private static final String testFolderName = "src/test/resources/" + resourcePrefix;

	private static JAXBContext context;
	private static Unmarshaller unmarshaller;
	
	private String resourcename;
	
	@Parameters(name = "{0}")
	public static Collection<Object[]> getParameters() {
		Collection<Object[]> result = new LinkedList<Object[]>();
		File exampleFolder = new File(testFolderName);
		
		for (File file: exampleFolder.listFiles()) {
			String name = file.getName();
			LOG.debug("adding file for test > {}", name);
			result.add(new Object[] {name});
		}
		
		try {
			context = JAXBContext.newInstance(Constants.CONTEXT_PATH);
			unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			LOG.error("Fehler bei Parametererstellung", e);
			return null;
		}
		
		return result;
	}
	
	public Test_UnMarshalling_Stat(String filename) throws JAXBException {
		resourcename = resourcePrefix + filename;
		LOG.debug("resourcename > {}", resourcename);
	}

	@Before
	public void setup() throws Exception {
	}
	
	@Test
	public void testUnmarshal() throws Exception {
		unmarshaller.unmarshal(ClassLoader.getSystemClassLoader().getResourceAsStream(resourcename));
	}
}
