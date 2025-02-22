package cn.sparkbridge.Qadapter;

import cn.sparkbridge.Logger;
import cn.sparkbridge.Message.GroupMessage;
import cn.sparkbridge.Message.MessageClass;
import cn.sparkbridge.Message.PrivateMessage;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocketClient extends org.java_websocket.client.WebSocketClient {
    public QadapterImpl Qadapter;
    public WebSocketClient(URI address) {
        super(address);
    }
    public void start(QadapterImpl qadapter){
        Qadapter = qadapter;
        this.connect();
    }
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        Logger.log("WebSocket is opening");
    }

    @Override
    public void onMessage(String s) {
        MessageClass.QQMessageType messageType = MessageClass.is_group_or_private(s);
        if (messageType != null) {
            switch (messageType) {
                case Group:
                   GroupMessage groupMessage = GroupMessage.parser(s);
                   Qadapter.emit_group_message(groupMessage);
                   break;
                case Private:
                    PrivateMessage privateMessage = PrivateMessage.parser(s);
                    Qadapter.emit_private_message(privateMessage);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        Logger.log("is Closing");
    }

    @Override
    public void onError(Exception e) {
        throw new RuntimeException(e);
    }
}
