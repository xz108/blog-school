package com.eert1.learn_springboot.web.WebChatServer;

import com.eert1.learn_springboot.config.WebSocketConfig;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint(value = "/websocket",configurator = WebSocketConfig.class)
@Component
public class ChatServer {
    private static CopyOnWriteArrayList<ChatServer>ChatServer =new CopyOnWriteArrayList<ChatServer>();
    private static Map<String, Session>map=new HashMap<String,Session>();
    private Session session;
    private String username;
    private ApplicationContext applicationContext;
//    private ChatServer chatServer;
    @OnOpen
    public void onopen()
    {
        ChatServer.add(this);

    }
    @OnClose
    public void Onclose()
    {
        ChatServer.remove(this);
    }
    @OnMessage
    public void onMessage(String message)
    {
        Session session;
//        session.getAsyncRemote().sendText("aa");

    }
}
