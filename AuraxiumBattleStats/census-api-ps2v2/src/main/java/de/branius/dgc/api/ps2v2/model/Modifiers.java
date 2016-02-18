package de.branius.dgc.api.ps2v2.model;

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
