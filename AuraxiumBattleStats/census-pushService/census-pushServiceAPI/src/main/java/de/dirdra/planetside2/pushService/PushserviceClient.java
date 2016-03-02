package de.dirdra.planetside2.pushService;

import java.io.IOException;

public interface PushserviceClient {
	void setCallbackHandler(WebsocketHandler handler);
	void setURL(String url);
	
	void start();
	void stop();
	void sendMessage(String message) throws IOException;
}
