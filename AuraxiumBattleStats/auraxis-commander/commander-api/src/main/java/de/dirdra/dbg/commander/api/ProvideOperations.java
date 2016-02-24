package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.Offer;
import de.dirdra.dbg.commander.model.ProvideResponse;

/**
 * Operation for providing diffrent services
 * 
 * @author Dirdra
 *
 */
public interface ProvideOperations {
	ProvideResponse provideAntiAirSupport(Offer offer);
	ProvideResponse provideAntiTankSupport(Offer offer);
	ProvideResponse provideMaxSupport(Offer offer);
	ProvideResponse provideVehicleRepair(Offer offer);
	ProvideResponse provideVehicleAmmo(Offer offer);
	ProvideResponse provideGunnerSupport(Offer offer);
}
