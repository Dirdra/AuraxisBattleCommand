package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.GroupManagementOrder;
import de.dirdra.dbg.commander.model.GroupManagementResponse;

public interface GroupManagementOperations {
	GroupManagementResponse createGroup(GroupManagementOrder order);
	GroupManagementResponse addToGroup(GroupManagementOrder order);
	GroupManagementResponse removeFromGroup(GroupManagementOrder order);
	GroupManagementResponse deleteGroup(GroupManagementOrder order);
}
