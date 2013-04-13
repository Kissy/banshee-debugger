package fr.kissy.banshee.debugger.servlet;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import fr.kissy.banshee.debugger.socket.BansheeWebSocket;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Simple 'ping' servlet...
 *
 * @author matzew
 */
public final class BansheeWebSocketServlet extends WebSocketServlet {

    @Autowired
    private BansheeWebSocket bansheeWebSocket;

    /**
     * @inheritDoc
     */
    public void init() throws ServletException {
        super.init();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
    }

    /**
     * @inheritDoc
     */
    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        return bansheeWebSocket;
    }

}