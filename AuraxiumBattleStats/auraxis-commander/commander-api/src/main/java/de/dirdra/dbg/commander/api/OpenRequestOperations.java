package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.Request;
import de.dirdra.dbg.commander.model.RequestResponse;

public interface OpenRequestOperations {
	RequestResponse requestAntiAirSupport(Request request);
	RequestResponse requestAntiVehicleSupport(Request request);
	RequestResponse requestAniInfanctrySupport(Request request);
	RequestResponse requestSpawnPoint(Request request);
	RequestResponse requestVehicleAmmo(Request request);
	RequestResponse requestVehicleRepair(Request request);
	
	RequestResponse requestGunner(Request request);
}
