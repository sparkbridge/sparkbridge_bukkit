package cn.sparkbridge.Message;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MessageClass {

    /**
     * 枚举类型，表示QQ消息的类型。
     * 包括群消息和私聊消息。
     */
    public enum QQMessageType {
        Group,
        Private
    }

    /**
     * 枚举类型，表示消息的子类型。
     * 包括群临时会话、群内自身、系统提示、匿名消息、群聊和好友消息。
     */
    public enum SubType {
        Group, // 群临时会话
        Group_Self, // 群内自身
        Notice, // 系统提示
        Anonymous, // 匿名消息
        Normal, // 群聊
        Friend, // 好友
    }

    /**
     * 枚举类型，表示用户在群中的角色。
     * 包括群主、管理员和普通成员。
     */
    public enum RoleType{
        Owner,
        Admin,
        Member
    }


    public enum MessageFormat{
        STRING,
        ARRAY
    }
    public enum PostType {
        MESSAGE
    }
    public static String PostTypeToStr(PostType postType){
        return switch (postType) {
            case MESSAGE -> "message";
            default -> null;
        };
    }
    public static PostType StrToPostType(String postType){
        return switch (postType) {
            case "message" -> PostType.MESSAGE;
            default -> null;
        };
    }
    public static String SubTypeToStr(SubType subType){
        return switch (subType) {
            case Group -> "group";
            case Group_Self -> "group_self";
            case Notice -> "notice";
            case Anonymous -> "anonymous";
            case Normal -> "normal";
            case Friend -> "friend";
            default -> null;
        };
    }
    public static SubType StrToSubType(String subType){
        return switch (subType) {
            case "group" -> SubType.Group;
            case "group_self" -> SubType.Group_Self;
            case "notice" -> SubType.Notice;
            case "anonymous" -> SubType.Anonymous;
            case "normal" -> SubType.Normal;
            case "friend" -> SubType.Friend;
            default -> null;
        };
    }
    public static String RoleTypeToStr(RoleType roleType){
        return switch (roleType) {
            case Owner -> "owner";
            case Admin -> "admin";
            case Member -> "member";
            default -> null;
        };
    }
    public static RoleType StrToRoleType(String roleType){
        return switch (roleType) {
            case "owner" -> RoleType.Owner;
            case "admin" -> RoleType.Admin;
            case "member" -> RoleType.Member;
            default -> null;
        };
    }
    public static String MessageFormatToStr(MessageFormat messageType){
        return switch (messageType) {
            case STRING -> "string";
            case ARRAY -> "array";
            default -> null;
        };
    }
    public static MessageFormat StrToMessageFormat(String messageType){
        return switch (messageType) {
            case "string" -> MessageFormat.STRING;
            case "array" -> MessageFormat.ARRAY;
            default -> null;
        };
    }
    public static String QQMessageTypeToStr(QQMessageType messageType){
        return switch (messageType) {
            case Group -> "group";
            case Private -> "private";
            default -> null;
        };
    }
    public static QQMessageType StrToQQMessageType(String messageType){
        return switch (messageType) {
            case "group" -> QQMessageType.Group;
            case "private" -> QQMessageType.Private;
            default -> null;
        };
    }

    public static MessageType StrToMessageType(String type) {
        return switch (type) {
            case "text" -> MessageType.TEXT;
            case "face" -> MessageType.FACE;
            case "record" -> MessageType.RECORD;
            case "video" -> MessageType.VIDEO;
            case "at" -> MessageType.AT;
            case "rps" -> MessageType.RPS;
            case "dice" -> MessageType.DICE;
            case "shake" -> MessageType.SHAKE;
            case "anonymous" -> MessageType.ANONYMOUS;
            case "share" -> MessageType.SHARE;
            case "contact" -> MessageType.CONTACT;
            case "location" -> MessageType.LOCATION;
            case "music" -> MessageType.MUSIC;
            case "image" -> MessageType.IMAGE;
            case "reply" -> MessageType.REPLY;
            case "redbag" -> MessageType.RED_BAG;
            case "poke" -> MessageType.POKE;
            case "gift" -> MessageType.GIFT;
            case "forward" -> MessageType.FORWARD;
            case "node" -> MessageType.NODE;
            case "xml" -> MessageType.XML;
            case "json" -> MessageType.JSON;
            case "cardimage" -> MessageType.CARD_IMAGE;
            case "tts" -> MessageType.TTS;
            default -> null;
        };
    }

    public static String MessageTypeToStr(MessageType type) {
        return switch (type) {
            case TEXT -> "text";
            case FACE -> "face";
            case RECORD -> "record";
            case VIDEO -> "video";
            case AT -> "at";
            case RPS -> "rps";
            case DICE -> "dice";
            case SHAKE -> "shake";
            case ANONYMOUS -> "anonymous";
            case SHARE -> "share";
            case CONTACT -> "contact";
            case LOCATION -> "location";
            case MUSIC -> "music";
            case IMAGE -> "image";
            case REPLY -> "reply";
            case RED_BAG -> "redbag";
            case POKE -> "poke";
            case GIFT -> "gift";
            case FORWARD -> "forward";
            case NODE -> "node";
            case XML -> "xml";
            case JSON -> "json";
            case CARD_IMAGE -> "cardimage";
            case TTS -> "tts";
            default -> null;
        };
    }


    public static Message parserMessage(JSONObject message) {
        Message res_message = new Message();
        String msg_type = message.getString("type");
        MessageType type = MessageClass.StrToMessageType(msg_type);
        if(type == null){
            throw new RuntimeException("Message Type is Null");
        }
        res_message.type = type;
        JSONObject json = message.optJSONObject("data");
        if (json != null) {
            json.keys().forEachRemaining(key -> {
                res_message.data.put(key, json.getString(key));
            });
        } else {
            throw new RuntimeException("Message is Null");
        }
        return res_message;
    }
    public static MessageClass.QQMessageType is_group_or_private(String msg) {
        if (msg.contains("\"message_type\":\"group\"")) {
            return MessageClass.QQMessageType.Group;
        } else if (msg.contains("\"message_type\":\"private\"")) {
            return MessageClass.QQMessageType.Private;
        } else {
            return null;
        }
    }
    public static ArrayList<Message> parserMessages(JSONArray messages) {
        ArrayList<Message> res_messages = new ArrayList<>();
        int len = messages.length();

        for (int i = 0; i < len; i++) {
            JSONObject json = messages.getJSONObject(i);
            Message message = MessageClass.parserMessage(json);
            res_messages.add(message);
        }
        return res_messages;
    }
}
