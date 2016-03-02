package de.dirdra.dbg.commander.model.common;

/**
 * configuration of a vehicle
 * 
 * @author Dirdra
 *
 */
public interface VehicleConfiguration {
	/**
	 * information about the primary weapon
	 * 
	 * @return null if it has no system
	 */
	WeaponInformation getPrimaryWeapon();

	/**
	 * information about the secondary weapon
	 * 
	 * @return null if it has no system
	 */
	WeaponInformation getSecondary();

	/**
	 * information about utilitysystem
	 * 
	 * @return null if it has no system
	 */
	UtilitySystemInformation getUtilitySystem();

	/**
	 * information about the defensesystem
	 * 
	 * @return null if it has no system
	 */
	DefenseSystemInformation getDefenseSystem();

	/**
	 * information about the chassi
	 * 
	 * @return null if it has no system
	 */
	ChassisSystemInformation getChassiSystem();
}
