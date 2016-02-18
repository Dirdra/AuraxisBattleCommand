package de.branius.dgc.api.ps2v2.model;

public interface SearchPredicate {
	String getPredicat();
	String getValue();
	Modifiers getModifier();
	
	String asQuery();
}
