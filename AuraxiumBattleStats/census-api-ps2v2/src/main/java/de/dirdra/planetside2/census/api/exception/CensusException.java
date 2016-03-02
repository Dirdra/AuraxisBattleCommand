package de.dirdra.planetside2.census.api.exception;

public class CensusException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CensusException() {
		super();
	}

	public CensusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CensusException(String message, Throwable cause) {
		super(message, cause);
	}

	public CensusException(String message) {
		super(message);
	}

	public CensusException(Throwable cause) {
		super(cause);
	}
}
