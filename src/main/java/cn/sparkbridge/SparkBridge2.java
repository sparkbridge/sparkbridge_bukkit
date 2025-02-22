package cn.sparkbridge;

import cn.sparkbridge.Message.GroupMessage;
import cn.sparkbridge.Message.PrivateMessage;
import cn.sparkbridge.Plugins.PluginRunType;
import cn.sparkbridge.Qadapter.Qadapter;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public final class SparkBridge2 extends JavaPlugin {
    public Configuration config;
    public static String pluginDirectory = "plugins/SparkBridge2/plugins";
    public static String address;;
    public static Qadapter qadapter;
    public static Logger logger;
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.reloadConfig();
        config = getConfig();
        address =  config.getString("address");
        qadapter = new Qadapter(address);
        logger = getLogger();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public @NotNull Logger getLogger() {
        return super.getLogger();
    }
}
