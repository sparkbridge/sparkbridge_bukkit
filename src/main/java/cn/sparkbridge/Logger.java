package cn.sparkbridge;

public class Logger {
    public static void log(String msg)
    {
        SparkBridge2.logger.info("[SparkBridge] " + msg);
    }
    public static void warn(String msg)
    {
        SparkBridge2.logger.warning("[SparkBridge] " + msg);
    }
    public static void error(String msg)
    {
        SparkBridge2.logger.severe("[SparkBridge] " + msg);
    }
}
