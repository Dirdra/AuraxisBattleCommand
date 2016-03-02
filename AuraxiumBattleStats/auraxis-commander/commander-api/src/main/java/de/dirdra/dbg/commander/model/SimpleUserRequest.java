package de.dirdra.dbg.commander.model;

/**
 * basic interface for a userrequest
 * 
 * @author Dirdra
 *
 */
public interface SimpleUserRequest {
	/**
	 * Information about sender of the request
	 * 
	 * @return
	 */
	OperationUser getRequester();

	/**
	 * Information about the location of the request
	 * 
	 * @return
	 */
	Location getRequestLocation();

	/**
	 * Short summary of the force which is attacking
	 * 
	 * @return short descriptive string; null when no description was set
	 */
	String getSummary();
}
