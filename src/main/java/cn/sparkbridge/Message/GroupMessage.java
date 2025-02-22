package cn.sparkbridge.Message;

import cn.sparkbridge.Message.Sender.GroupSender;
import org.json.JSONObject;

import static cn.sparkbridge.Message.MessageClass.*;
import static cn.sparkbridge.Message.MessageClass.StrToQQMessageType;

/**
 * 表示群消息的类。
 * 包含消息的发送者、消息内容、消息类型、子类型等信息。
 */
public class GroupMessage extends PrivateMessage {
    public GroupSender sender;
    public long group_id;

    public static GroupMessage parser(String msg) {
        GroupMessage message = new GroupMessage();
        JSONObject json = new JSONObject(msg);
        message.message_type = MessageClass.QQMessageType.Group;
        message.group_id = json.getLong("group_id");
        message.message = MessageClass.parserMessages(json.getJSONArray("message"));
        message.font = json.getInt("font");
        message.raw_message = json.getString("raw_message");
        message.message_seq = json.getInt("message_seq");
        message.message_id = json.getInt("message_id");
        message.time = json.getInt("time");
        message.self_id = json.getInt("self_id");
        message.user_id = json.getInt("user_id");
        message.sub_type = StrToSubType(json.getString("sub_type"));
        message.message_format = StrToMessageFormat(json.getString("message_format"));
        message.post_type = StrToPostType(json.getString("post_type"));
        message.sender = GroupSender.parse(json.getJSONObject("sender"));
        message.message_type = StrToQQMessageType(json.getString("message_type"));
        return message;
    }
}
