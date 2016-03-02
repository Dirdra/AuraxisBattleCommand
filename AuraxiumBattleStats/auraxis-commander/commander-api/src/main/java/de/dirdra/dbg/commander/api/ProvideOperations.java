package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.offer.AirSupportOffer;
import de.dirdra.dbg.commander.model.offer.Offer;
import de.dirdra.dbg.commander.model.offer.ProvideResponse;

/**
 * Operation for providing diffrent services
 * 
 * @author Dirdra
 *
 */
public interface ProvideOperations {
	ProvideResponse provideAirSupport(AirSupportOffer offer);
	ProvideResponse provideTankSupport(Offer offer);
	ProvideResponse provideMaxSupport(Offer offer);
	ProvideResponse provideVehicleRepair(Offer offer);
	ProvideResponse provideVehicleAmmo(Offer offer);
	ProvideResponse provideGunnerSupport(Offer offer);
	
//	ProvideResponse provideSpawn(Offer offer);
}
