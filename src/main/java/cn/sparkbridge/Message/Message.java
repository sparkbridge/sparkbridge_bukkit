package cn.sparkbridge.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示消息的类。
 * 包含消息的类型。
 */
public class Message {
    public MessageType type = null;
    public Map<String,String> data = new HashMap<String,String>();
}