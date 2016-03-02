package de.dirdra.planetside2.pushService.impl;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dirdra.planetside2.pushService.PushserviceClient;
import de.dirdra.planetside2.pushService.WebsocketHandler;

@ClientEndpoint
public class PushserviceClientImpl implements PushserviceClient {
	private static Logger LOG = LoggerFactory.getLogger(PushserviceClientImpl.class);
	
	private static String DEFAULT_URL = "wss://push.planetside2.com/streaming?environment=ps2&service-id=s:example";
	
	private ClientManager clientManager;
	private Session session;
	private boolean running;
	private CountDownLatch latch;
	
	private WebsocketHandler callbackHandler;
	private String url;
	
	public PushserviceClientImpl() {
		clientManager = ClientManager.createClient();
	}

	@Override
	public void setCallbackHandler(WebsocketHandler handler) {
		callbackHandler = handler;
	}

	@Override
	public void setURL(String url) {
		this.url = url;
	}

	@Override
	public synchronized void start() {
		if (!running) {
			clientManager = ClientManager.createClient();
			URI uri = URI.create(url);
			try {
				session = clientManager.connectToServer(PushserviceClientImpl.class, uri);
				latch = new CountDownLatch(1);
				running  = true;
			} catch (DeploymentException | IOException e) {
				// TODO Auto-generated catch block
				LOG.error("Fehler beim Herstellen der Verbindung", e);
			}
		} else {
			//TODO Fehler werfen das Verbindung bereits besteht???
			LOG.warn("service läuft bereits");
		}
	}

	@Override
	public synchronized void stop() {
		if (running) {
			try {
				session.close();
				latch.await(30, TimeUnit.SECONDS);
				running = false;
			} catch (IOException | InterruptedException e)  {
				//TODO 
				LOG.error("Fehler beim schliesen der Verbindung", e);
			}
		} else {
			//TODO Meldung machen das keine Verbindung existiert
			LOG.warn("service läuft nicht");
		}
	}
	
	@Override
	public void sendMessage(String message) throws IOException {
		if (!running) {
			//TODO Meldung machen das keine Verbindung existiert
			LOG.warn("service läuft nicht");
		} else {
			session.getBasicRemote().sendText(message);
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		if (callbackHandler != null) {
			callbackHandler.onOpen(session);
		}
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		if (callbackHandler != null) {
			callbackHandler.onError(session, throwable);
		}
	}
	
	@OnMessage
	public String onMessage(String message, Session session) {
		if (callbackHandler != null) {
			callbackHandler.onMessage(message, session);
		}
		
		return message;
	}
	
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		if (callbackHandler != null) {
			callbackHandler.onClose(session, closeReason);
		}
		latch.countDown();
	}

}
