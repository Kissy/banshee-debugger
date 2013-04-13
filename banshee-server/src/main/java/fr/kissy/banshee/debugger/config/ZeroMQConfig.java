package fr.kissy.banshee.debugger.config;

import fr.kissy.banshee.debugger.handler.ZMQHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zeromq.ZContext;
import org.zeromq.ZLoop;
import org.zeromq.ZMQ;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Guillaume LE BILLER
 */
@Configuration
public class ZeroMQConfig {
    @Bean
    public ZContext zContext() {
        return new ZContext();
    }

    @Bean
    public ZMQ.Socket zmqSocket() {
        ZMQ.Socket socket = zContext().createSocket(ZMQ.PULL);
        socket.bind("tcp://*:5555");
        return socket;
    }

    @Bean
    public ZMQHandler zmqHandler() {
        return new ZMQHandler();
    }

    @Bean
    public ZLoop zLoop() {
        ZLoop zLoop = new ZLoop();
        ZMQ.PollItem pollItem = new ZMQ.PollItem(zmqSocket(), ZMQ.Poller.POLLIN);
        zLoop.addPoller(pollItem, zmqHandler(), this);
        return zLoop;
    }

    @Bean
    public ExecutorService executorService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(zLoopRunnable());
        return executorService;
    }

    @Bean
    public Runnable zLoopRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                zLoop().start();
            }
        };
    }
}
