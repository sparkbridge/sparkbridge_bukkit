package cn.sparkbridge.Message;

import cn.sparkbridge.Message.Sender.PrivateSender;
import org.json.JSONObject;

import java.util.ArrayList;

import static cn.sparkbridge.Message.MessageClass.*;
import static cn.sparkbridge.Message.MessageClass.StrToQQMessageType;

public class PrivateMessage {
    public long self_id;
    public long user_id;
    public long time;
    public long message_id;
    public long message_seq;
    public QQMessageType message_type;
    public PrivateSender sender;
    public String raw_message;
    public int font;
    public SubType sub_type;
    public ArrayList<Message> message;
    public MessageFormat message_format;
    public PostType post_type;

    public static PrivateMessage parser(String msg) {
        PrivateMessage message = new PrivateMessage();
        JSONObject json = new JSONObject(msg);
        message.message_type = MessageClass.QQMessageType.Group;
        message.message = MessageClass.parserMessages(json.getJSONArray("message"));
        message.font = json.getInt("font");
        message.raw_message = json.getString("raw_message");
        message.message_seq = json.getLong("message_seq");
        message.message_id = json.getLong("message_id");
        message.time = json.getLong("time");
        message.self_id = json.getLong("self_id");
        message.user_id = json.getLong("user_id");
        message.sub_type = StrToSubType(json.getString("sub_type"));
        message.message_format = StrToMessageFormat(json.getString("message_format"));
        message.post_type = StrToPostType(json.getString("post_type"));
        message.sender = PrivateSender.parse(json.getJSONObject("sender"));
        message.message_type = StrToQQMessageType(json.getString("message_type"));
        return message;
    }
}
