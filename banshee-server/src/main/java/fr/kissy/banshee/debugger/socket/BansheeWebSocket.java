package fr.kissy.banshee.debugger.socket;

import fr.kissy.banshee.debugger.service.ConnectionService;
import fr.kissy.banshee.proto.DebugHolderDTO;
import fr.kissy.banshee.proto.DebugObjectDTO;
import fr.kissy.banshee.proto.DebugPropertyDTO;
import org.eclipse.jetty.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * WebSocket implementation
 */
public class BansheeWebSocket implements WebSocket {

    @Autowired
    private ConnectionService connectionService;

    private Connection outbound;

    @Override
    public void onOpen(Connection connection) {
        outbound = connection;
        connectionService.add(this);
        DebugPropertyDTO.DebugPropertyProto.Builder properties = DebugPropertyDTO.DebugPropertyProto.newBuilder();
        properties.setCategory("cat");
        properties.setKey("key");
        properties.setValue("value");
        DebugPropertyDTO.DebugPropertyProto.Builder properties2 = DebugPropertyDTO.DebugPropertyProto.newBuilder();
        properties2.setCategory("cat");
        properties2.setKey("key2");
        properties2.setValue("value2");
        DebugPropertyDTO.DebugPropertyProto.Builder properties3 = DebugPropertyDTO.DebugPropertyProto.newBuilder();
        properties3.setCategory("cat3");
        properties3.setKey("key3");
        properties3.setValue("value3");

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
    }

    @Override
    public void onClose(int i, String s) {
        connectionService.remove(this);
    }

    public Connection getOutbound() {
        return outbound;
    }
}
