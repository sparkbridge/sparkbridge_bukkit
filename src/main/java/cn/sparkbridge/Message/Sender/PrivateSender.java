package cn.sparkbridge.Message.Sender;

import org.json.JSONObject;

public class PrivateSender extends Sender{
    public static PrivateSender parse(JSONObject sender)
    {
        PrivateSender s = new PrivateSender();
        s.user_id = sender.getInt("user_id");
        s.nickname = sender.getString("nickname");
        s.card = sender.getString("card");
        return s;
    }
}
