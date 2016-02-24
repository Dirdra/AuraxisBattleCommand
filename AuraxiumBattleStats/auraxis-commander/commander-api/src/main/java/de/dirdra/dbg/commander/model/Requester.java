package de.dirdra.dbg.commander.model;

/**
 * Information about sender of a request
 * 
 * @author Dirdra
 *
 */
public interface Requester {
	String getRequesterID();
	Group getGroup();
}
