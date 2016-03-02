package de.branius.dgc.api.ps2v2.test.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.jemos.podam.api.PodamFactoryImpl;
import de.brainius.dgc.api.ps2v2.impl.model.SimplePredicate;
import de.dirdra.planetside2.census.api.model.Modifiers;

public class SimplePredicateTests {
	private SimplePredicate unitUnderTest;
	private PodamFactoryImpl factory = new PodamFactoryImpl();
	
	
	@Before
	public void setup() {
		unitUnderTest = new SimplePredicate();
	}
	
	@Test
	public void testSetGetPredicate_nullTest() {
		unitUnderTest.setPredicate(null);
		Assert.assertEquals("", unitUnderTest.getPredicat());
	}
	
	@Test
	public void testSetGetPredicate_valueTest() {
		String value = factory.manufacturePojo(String.class);
		unitUnderTest.setPredicate(value);
		Assert.assertSame(value, unitUnderTest.getPredicat());
	}
	
	@Test
	public void testGetSetModifier_nullIsEqualTest() {
		unitUnderTest.setModifier(null);
		Assert.assertEquals(Modifiers.EQUAL, unitUnderTest.getModifier());
	}
	
	@Test
	public void testGetSetModifier_valueTest() {
		Modifiers value = Modifiers.EQUAL;
		unitUnderTest.setModifier(value);
		Assert.assertEquals(value, unitUnderTest.getModifier());
	}
	
	@Test
	public void testGetSetValue_nullTest() {
		unitUnderTest.setValue(null);
		Assert.assertEquals("", unitUnderTest.getValue());
	}
	
	@Test
	public void testGetSetValue_valueTest() {
		String value = factory.manufacturePojo(String.class);
		unitUnderTest.setValue(value);
		Assert.assertEquals(value, unitUnderTest.getValue());
	}
	
	@Test
	public void testAsQuery() {
		String predicate = factory.manufacturePojo(String.class);
		Modifiers modifier = Modifiers.EQUAL;
		String value = factory.manufacturePojo(String.class);
		
		unitUnderTest.setModifier(modifier);
		unitUnderTest.setPredicate(predicate);
		unitUnderTest.setValue(value);
		
		Assert.assertEquals(predicate+modifier.getValue()+value, unitUnderTest.asQuery());
	}
}
