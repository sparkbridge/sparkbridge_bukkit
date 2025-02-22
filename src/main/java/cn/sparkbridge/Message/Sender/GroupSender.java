package cn.sparkbridge.Message.Sender;

import cn.sparkbridge.Message.MessageClass;
import org.json.JSONObject;

public class GroupSender extends Sender{

    public MessageClass.RoleType role;
    public String title;
    public static GroupSender parse(JSONObject sender){
        GroupSender s = new GroupSender();
        s.user_id = sender.getInt("user_id");
        s.nickname = sender.getString("nickname");
        s.card = sender.getString("card");
        s.role = MessageClass.StrToRoleType(sender.getString("role"));
        s.title = sender.getString("title");
        return s;
    }
}
