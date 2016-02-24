package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.GroupRequest;
import de.dirdra.dbg.commander.model.GroupRequestResponse;

public interface GroupRequestOperations {
	//Infantry
	GroupRequestResponse requestInfiltrator(GroupRequest groupRequest);
	GroupRequestResponse requestLightAssault(GroupRequest groupRequest);
	GroupRequestResponse requestMedic(GroupRequest groupRequest);
	GroupRequestResponse requestEngineer(GroupRequest groupRequest);
	GroupRequestResponse requestHeavyAssault(GroupRequest groupRequest);
	GroupRequestResponse requestMaxUnit(GroupRequest groupRequest);
	GroupRequestResponse requestCustomeInfatry(GroupRequest groupRequest);
	
	//Vehicle
	GroupRequestResponse requestFlash(GroupRequest groupRequest);
	GroupRequestResponse requestHarasser(GroupRequest groupRequest);
	GroupRequestResponse requestSunderer(GroupRequest groupRequest);
	GroupRequestResponse requestLightning(GroupRequest groupRequest);
	GroupRequestResponse requestMBT(GroupRequest groupRequest);
	GroupRequestResponse requestESF(GroupRequest groupRequest);
	GroupRequestResponse requestLiberator(GroupRequest groupRequest);
	GroupRequestResponse requestGalaxy(GroupRequest groupRequest);
	GroupRequestResponse requestCustomeVehicle(GroupRequest groupRequest);
	
	GroupRequestResponse requestCustomeGroup(GroupRequest groupRequest);
	
	//Rally
	GroupRequestResponse orderRallyPoint(GroupRequest groupRequest);
	GroupRequestResponse joinRallyPoint(GroupRequest groupRequest);
}
