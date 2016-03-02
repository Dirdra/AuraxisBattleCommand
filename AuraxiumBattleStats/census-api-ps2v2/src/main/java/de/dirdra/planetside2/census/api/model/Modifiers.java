package de.dirdra.planetside2.census.api.model;

public enum Modifiers {
	EQUAL("="),
	LESS("<"),
	LESS_EQUAL("["),
	GREATER(">"),
	GREATER_EQUAL("]"),
	STARTWITH("^"),
	CONTAINS("*"),
	NOT("!");
	
	private String value;
	
	private Modifiers(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
