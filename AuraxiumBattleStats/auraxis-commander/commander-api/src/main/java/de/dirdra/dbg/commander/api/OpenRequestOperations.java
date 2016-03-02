package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.SimpleUserRequest;
import de.dirdra.dbg.commander.model.request.AntiAirRequest;
import de.dirdra.dbg.commander.model.request.RequestResponse;

public interface OpenRequestOperations {
	RequestResponse requestAntiAirSupport(AntiAirRequest request);
	RequestResponse requestAntiVehicleSupport(SimpleUserRequest request);
	RequestResponse requestAniInfanctrySupport(SimpleUserRequest request);
	RequestResponse requestSpawnPoint(SimpleUserRequest request);
	RequestResponse requestVehicleAmmo(SimpleUserRequest request);
	RequestResponse requestVehicleRepair(SimpleUserRequest request);
	
	RequestResponse requestGunner(SimpleUserRequest request);
	
	RequestResponse registerForRequests(SimpleUserRequest request);
}
