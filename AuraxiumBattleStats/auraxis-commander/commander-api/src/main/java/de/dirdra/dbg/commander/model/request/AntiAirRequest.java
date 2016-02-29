package de.dirdra.dbg.commander.model.request;

import de.dirdra.dbg.commander.model.SimpleUserRequest;

/**
 * Desciption of anti-air request<br>
 * What is attacking?
 * 
 * @author Dirdra
 *
 */
public interface AntiAirRequest extends SimpleUserRequest {	
	/**
	 * number of ESFs in the area
	 * @return
	 */
	int getESFCount();
	/**
	 * number of libarators in the area
	 * @return
	 */
	int getLiberatorCount();
	/**
	 * number of Galaxies in the area
	 * @return
	 */
	int getGalaxyCount();
}
