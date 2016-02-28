package de.dirdra.dbg.commander.model;

/**
 * Information about sender of a request
 * 
 * @author Dirdra
 *
 */
public interface OperationUser {
	/**
	 * id of the char
	 * 
	 * @return
	 */
	String getRequesterID();

	/**
	 * name of the char
	 * 
	 * @return
	 */
	String getName();
}
