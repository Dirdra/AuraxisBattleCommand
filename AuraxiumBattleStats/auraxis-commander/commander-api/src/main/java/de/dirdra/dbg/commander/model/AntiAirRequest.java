package de.dirdra.dbg.commander.model;

/**
 * Desciption of anti-air request<br>
 * What is attacking?
 * 
 * @author Dirdra
 *
 */
public interface AntiAirRequest extends SimpleUserRequest {
	/**
	 * Short summary of the force which is attacking
	 * @return short descriptive string
	 */
	String getSummary();
	
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
