package cn.sparkbridge.Qadapter;

import org.json.JSONObject;

import java.util.UUID;

public class Qadapter extends QadapterImpl {
    public Qadapter(String address) {
        super(address);
    }
    public void sendGroupMessage(long group_id,String message)
    {
        JSONObject obj = new JSONObject();
        obj.put("action","send_group_msg");
        JSONObject obj2 = new JSONObject();
        obj2.put("group_id",String.valueOf(group_id));
        obj2.put("message",message);
        obj2.put("auto_escape",false);
        obj.put("params",obj2);
        this._ws_client.send(obj.toString());
    }
    public void sendPrivateMessage(long user_id,String message)
    {
        JSONObject obj = new JSONObject();
        obj.put("action","send_msg");
        obj.put("echo", UUID.randomUUID().toString());
        JSONObject obj2 = new JSONObject();
        obj2.put("user_id",String.valueOf(user_id));
        obj2.put("message",message);
        obj2.put("message_type","private");
        obj.put("params",obj2);
        this._ws_client.send(obj.toString());
    }
}

