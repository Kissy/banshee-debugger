package fr.kissy.banshee.debugger.handler;

import com.google.protobuf.InvalidProtocolBufferException;
import fr.kissy.banshee.debugger.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.zeromq.ZLoop;
import org.zeromq.ZMQ;

import java.io.IOException;

/**
 * @author Guillaume LE BILLER
 */
public class ZMQHandler implements ZLoop.IZLoopHandler {

    @Autowired
    private ConnectionService connectionService;

    /**
     * @inheritDoc
     */
    @Override
    public int handle(ZLoop loop, ZMQ.PollItem item, Object arg) {
        try {
            final byte[] message = item.getSocket().recv();
            connectionService.sendAll(message);
        } catch (InvalidProtocolBufferException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
