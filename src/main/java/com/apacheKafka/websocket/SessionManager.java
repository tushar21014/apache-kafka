package com.apacheKafka.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SessionManager {

	private final Set<WebSocketSession> manager = new CopyOnWriteArraySet<WebSocketSession>(); 
	
	public void addSession(WebSocketSession session)
	{
		manager.add(session);
	}
	
	public void removeSession(WebSocketSession session)
	{
		manager.remove(session);
	}
	
	public void broadcast(String message) {
	    for (WebSocketSession session : manager) {
	        try {
	            session.sendMessage(new TextMessage(message));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
