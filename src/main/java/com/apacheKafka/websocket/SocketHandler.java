package com.apacheKafka.websocket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.apacheKafka.service.ProducerService;

@Component
public class SocketHandler extends TextWebSocketHandler {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private SessionManager sessionManager;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		sessionManager.addSession(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		producerService.sendMessage(message.getPayload());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		sessionManager.removeSession(session);
	}
	
}
