package de.dirdra.dbg.commander.api;

import de.dirdra.dbg.commander.model.DrawResponse;
import de.dirdra.dbg.commander.model.GraphicOrder;

public interface DrawOperations {
	DrawResponse addGraphicOrder(GraphicOrder order);
	DrawResponse removeGraphicOrder(GraphicOrder order);
}
