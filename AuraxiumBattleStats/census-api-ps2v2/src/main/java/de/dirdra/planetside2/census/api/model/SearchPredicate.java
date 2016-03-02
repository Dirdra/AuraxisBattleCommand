package de.dirdra.planetside2.census.api.model;

public interface SearchPredicate {
	String getPredicat();
	String getValue();
	Modifiers getModifier();
	
	String asQuery();
}
