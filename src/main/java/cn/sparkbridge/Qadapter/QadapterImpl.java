package cn.sparkbridge.Qadapter;

import cn.sparkbridge.Message.GroupMessage;
import cn.sparkbridge.Message.PrivateMessage;
import cn.sparkbridge.Plugins.PluginRunType;
import cn.sparkbridge.SparkBridge2;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.function.BiFunction;

public class QadapterImpl {
    WebSocketClient _ws_client;
    static ArrayList<BiFunction<GroupMessage,Qadapter,PluginRunType> > group_message_listeners = new ArrayList<>();
    static ArrayList<BiFunction<PrivateMessage,Qadapter,PluginRunType> > private_message_listeners = new ArrayList<>();
    public QadapterImpl(String address){
        URI url = URI.create(address);
        _ws_client = new WebSocketClient(url);
        _ws_client.start(this);
    }
    protected void emit_group_message(GroupMessage message)
    {
        for (BiFunction<GroupMessage,Qadapter,PluginRunType> fn : group_message_listeners){
            PluginRunType run_type = fn.apply(message, SparkBridge2.qadapter);
            if(run_type == PluginRunType.BLOCK) return;
        }
    }
    protected void emit_private_message(PrivateMessage message)
    {
        for (BiFunction<PrivateMessage,Qadapter,PluginRunType>  fn : private_message_listeners){
            PluginRunType run_type =fn.apply(message,SparkBridge2.qadapter);
            if(run_type == PluginRunType.BLOCK) return;
        }
    }
    public static void onGroupMessage(BiFunction<GroupMessage,Qadapter,PluginRunType>  fn)
    {
        group_message_listeners.add(fn);
    }
    public static void onPrivateMessage(BiFunction<PrivateMessage,Qadapter,PluginRunType>  fn)
    {
        private_message_listeners.add(fn);
    }
}
