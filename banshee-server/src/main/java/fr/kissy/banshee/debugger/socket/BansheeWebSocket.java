package fr.kissy.banshee.debugger.socket;

import fr.kissy.banshee.debugger.service.ConnectionService;
import fr.kissy.banshee.proto.DebugHolderDTO;
import fr.kissy.banshee.proto.DebugObjectDTO;
import fr.kissy.banshee.proto.DebugPropertyDTO;
import org.eclipse.jetty.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * WebSocket implementation
 */
public class BansheeWebSocket implements WebSocket {

    @Autowired
    private ConnectionService connectionService;

    private Connection outbound;
    private ScheduledExecutorService exec;

    @Override
    public void onOpen(Connection connection) {
        outbound = connection;
        connectionService.add(this);
        DebugPropertyDTO.DebugPropertyProto.Builder properties = DebugPropertyDTO.DebugPropertyProto.newBuilder();
        properties.setCategory("cat");
        properties.setKey("x");
        properties.setValue("1");
        DebugPropertyDTO.DebugPropertyProto.Builder properties2 = DebugPropertyDTO.DebugPropertyProto.newBuilder();
        properties2.setCategory("cat");
        properties2.setKey("y");
        properties2.setValue("1");
        DebugPropertyDTO.DebugPropertyProto.Builder properties3 = DebugPropertyDTO.DebugPropertyProto.newBuilder();
        properties3.setCategory("cat3");
        properties3.setKey("z");
        properties3.setValue("1");

        DebugObjectDTO.DebugObjectProto.Builder objects = DebugObjectDTO.DebugObjectProto.newBuilder();
        objects.setId("ID");
        objects.setName("NAME");
        objects.setCategory("CATEGORY");
        objects.addProperties(properties);
        objects.addProperties(properties2);
        objects.addProperties(properties3);
        DebugObjectDTO.DebugObjectProto.Builder objects2 = DebugObjectDTO.DebugObjectProto.newBuilder();
        objects2.setId("ID2");
        objects2.setName("NAME2");
        objects2.setCategory("CATEGORY");
        DebugObjectDTO.DebugObjectProto.Builder objects3 = DebugObjectDTO.DebugObjectProto.newBuilder();
        objects3.setId("ID3");
        objects3.setName("NAME3");
        objects3.setCategory("CATEGORY3");

        DebugHolderDTO.DebugHolderProto.Builder builder = DebugHolderDTO.DebugHolderProto.newBuilder();
        builder.addObjects(objects);
        builder.addObjects(objects2);
        builder.addObjects(objects3);

        DebugHolderDTO.DebugHolderProto proto = builder.build();
        try {
            outbound.sendMessage(proto.toByteArray(), 0, proto.getSerializedSize());
        } catch (IOException e) {
            e.printStackTrace();
        }

        exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                DebugPropertyDTO.DebugPropertyProto.Builder properties = DebugPropertyDTO.DebugPropertyProto.newBuilder();
                properties.setCategory("cat");
                properties.setKey("x");
                properties.setValue(randomInt());
                DebugPropertyDTO.DebugPropertyProto.Builder properties2 = DebugPropertyDTO.DebugPropertyProto.newBuilder();
                properties2.setCategory("cat");
                properties2.setKey("y");
                properties2.setValue(randomInt());
                DebugPropertyDTO.DebugPropertyProto.Builder properties3 = DebugPropertyDTO.DebugPropertyProto.newBuilder();
                properties3.setCategory("cat3");
                properties3.setKey("z");
                properties3.setValue(randomInt());

                DebugObjectDTO.DebugObjectProto.Builder objects = DebugObjectDTO.DebugObjectProto.newBuilder();
                objects.setId("ID");
                objects.setName("NAME");
                objects.setCategory("CATEGORY");
                objects.addProperties(properties);
                objects.addProperties(properties2);
                objects.addProperties(properties3);

                DebugHolderDTO.DebugHolderProto.Builder builder = DebugHolderDTO.DebugHolderProto.newBuilder();
                builder.addObjects(objects);

                DebugHolderDTO.DebugHolderProto proto = builder.build();

                try {
                    outbound.sendMessage(proto.toByteArray(), 0, proto.getSerializedSize());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    private String randomInt() {
        return String.valueOf(-10 + (int)(Math.random() * 21));
    }

    @Override
    public void onClose(int i, String s) {
        connectionService.remove(this);
        exec.shutdownNow();
    }

    public Connection getOutbound() {
        return outbound;
    }
}