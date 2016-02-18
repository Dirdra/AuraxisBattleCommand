package de.brainius.dgc.ps2v2.pushService;

import javax.websocket.CloseReason;
import javax.websocket.Session;

public interface WebsocketHandler {
	void onOpen(Session session);
	void onMessage(String message, Session session);
	void onError(Session session, Throwable throwable);
	void onClose(Session session, CloseReason closeReason);
}
