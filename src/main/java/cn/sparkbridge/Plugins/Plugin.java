package cn.sparkbridge.Plugins;

import cn.sparkbridge.Message.GroupMessage;
import cn.sparkbridge.Message.PrivateMessage;
import cn.sparkbridge.Qadapter.Qadapter;
abstract class Plugin {
    public abstract void init();
    public abstract PluginRunType onGroupMessage(GroupMessage message, Qadapter qadapter);
    public abstract PluginRunType onPrivateMessage(PrivateMessage message,Qadapter qadapter);
    public abstract String getName();
    public abstract String getVersion();
    public abstract String getAuthor();
    public abstract String getDescription();
}
