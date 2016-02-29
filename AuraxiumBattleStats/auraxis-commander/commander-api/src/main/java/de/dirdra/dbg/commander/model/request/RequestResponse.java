package de.dirdra.dbg.commander.model.request;

/**
 * response for a sent request
 * 
 * @author Dirdra
 *
 */
public interface RequestResponse {
	/**
	 * ID of the sent request
	 * 
	 * @return null if the request was not accepted
	 */
	Long getRequestID();

	/**
	 * responsestatus of the request
	 * 
	 * @return TODO description follows; ok, fail, fail because of ...
	 */
	int getRequestStatus();
}
