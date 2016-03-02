package de.dirdra.planetside2.census.api;

import de.dirdra.census.model.ps2v2.CharacterList;
import de.dirdra.planetside2.census.api.exception.CensusException;
import de.dirdra.planetside2.census.api.model.SearchPredicate;

/**
 * Api for requesting data
 * @author Sebastian
 *
 */
public interface CensusDataApi {
	/**
	 * Request data for a specific data
	 * @param subject e.g. images, item, single_character_by_id, ... 
	 * @param collection Class of the responsedata
	 * @param queryCommands parameters like c:limit=10,  c:includeNull=true.
	 * @throws CensusException when responseType is invalid or the request cause in an error
	 * @return null when there is no data
	 */
	<T> T getData(String collection, Class<T> responseType, String... queryCommands) throws CensusException;
	
	/**
	 * Search vor Characters with specific Constraints
	 * @param searchPredicats Predicats thats 
	 * @return Liste mit Charakteren
	 * @throws CensusException
	 */
	CharacterList searchCharacters(SearchPredicate... searchPredicats) throws CensusException;
}
