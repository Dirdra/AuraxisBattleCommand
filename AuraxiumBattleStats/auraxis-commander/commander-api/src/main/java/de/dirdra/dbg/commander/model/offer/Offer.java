package de.dirdra.dbg.commander.model.offer;

import de.dirdra.dbg.commander.model.OperationUser;

/**
 * general information about offer to grant
 * 
 * @author Dirdra
 *
 */
public interface Offer {
	/**
	 * information about provider 
	 * @return
	 */
	OperationUser getOfferProvider();

	/**
	 * short description of offer
	 * @return
	 */
	String getOfferSummary();
}
