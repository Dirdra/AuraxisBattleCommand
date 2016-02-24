package de.dirdra.dbg.commander.model;

/**
 * 
 * @author Dirdra
 *
 */
public interface Request {
	Requester getRequester();
	Location getRequestLocation();
}
