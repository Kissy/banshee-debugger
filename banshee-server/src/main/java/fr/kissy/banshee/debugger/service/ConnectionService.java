package fr.kissy.banshee.debugger.service;

import fr.kissy.banshee.debugger.socket.BansheeWebSocket;
import org.eclipse.jetty.websocket.WebSocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Guillaume LE BILLER
 */
public class ConnectionService {
    private Set<BansheeWebSocket> sockets = new CopyOnWriteArraySet<BansheeWebSocket>();

    public void add(BansheeWebSocket bansheeWebSocket) {
        sockets.add(bansheeWebSocket);
    }

    public void remove(BansheeWebSocket bansheeWebSocket) {
        sockets.remove(bansheeWebSocket);
    }

    public void sendAll(byte[] message) throws IOException {
        for (BansheeWebSocket socket : sockets) {
            socket.getOutbound().sendMessage(message, 0, message.length);
        }
    }
}
