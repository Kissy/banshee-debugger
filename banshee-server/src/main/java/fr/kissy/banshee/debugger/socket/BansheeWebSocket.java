package fr.kissy.banshee.debugger.socket;

import fr.kissy.banshee.debugger.service.ConnectionService;
import org.eclipse.jetty.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ScheduledExecutorService;

/**
 * WebSocket implementation
 */
public class BansheeWebSocket implements WebSocket {

    @Autowired
    private ConnectionService connectionService;
    private Connection outbound;

    /**
     * @inheritDoc
     */
    @Override
    public void onOpen(Connection connection) {
        outbound = connection;
        connectionService.add(this);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onClose(int i, String s) {
        connectionService.remove(this);
    }

    public Connection getOutbound() {
        return outbound;
    }
}