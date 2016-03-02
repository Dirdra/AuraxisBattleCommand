package de.brainius.dgc.api.ps2v2.impl.model;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import de.dirdra.planetside2.census.api.model.Modifiers;
import de.dirdra.planetside2.census.api.model.SearchPredicate;

public class SimplePredicate implements SearchPredicate {
	private static final String DEFAULT_STRING = StringUtils.EMPTY;
	
	private String predicate = DEFAULT_STRING;
	private Modifiers modifier = Modifiers.EQUAL;
	private String value = DEFAULT_STRING;
	
	public SimplePredicate() {
	}
	
	public void setPredicate(String predicate) {
		this.predicate = Optional.ofNullable(predicate).orElse(DEFAULT_STRING);
	}

	@Override
	public String getPredicat() {
		return predicate;
	}
	
	public void setValue(String value) {
		this.value = Optional.ofNullable(value).orElse(DEFAULT_STRING);
	}

	@Override
	public String getValue() {
		return value;
	}
	
	public void setModifier(Modifiers modifier) {
		this.modifier = Optional.ofNullable(modifier).orElse(Modifiers.EQUAL);
	}

	@Override
	public Modifiers getModifier() {
		return modifier;
	}

	@Override
	public String asQuery() {
		return StringUtils.join(predicate, modifier.getValue(), value);
	}

}
