package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.RallyJoin;
import de.dirdra.dbg.commander.model.RallyJoinResponse;
import de.dirdra.dbg.commander.model.RallyRequest;
import de.dirdra.dbg.commander.model.RallyPostResponse;

public interface RallyPointOperations {
	RallyPostResponse postTankRallyPoint(RallyRequest rallyRequest);
	RallyJoinResponse joinTankRallyPoint(RallyJoin rallyJoin);
	
	RallyPostResponse postAirRallyPoint(RallyRequest rallyRequest);
	RallyJoinResponse joinAirRallyPoint(RallyJoin rallyJoin);
}
