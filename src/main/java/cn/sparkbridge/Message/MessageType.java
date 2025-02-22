package cn.sparkbridge.Message;

/**
 * 枚举类型，表示消息的类型。
 * 包括表情、语音、短视频、@某人、猜拳魔法表情、掷骰子魔法表情、窗口抖动（戳一戳）、匿名消息、链接分享、推荐好友/群、位置、音乐分享、图片、回复、红包、戳一戳、礼物、合并转发、合并转发消息节点、XML消息、JSON消息、卡片图片和文本转语音等。
 */
public enum MessageType {
    TEXT,       // 文本
    FACE,       // 表情
    RECORD,     // 语音
    VIDEO,      // 短视频
    AT,         // @某人
    RPS,        // 猜拳魔法表情
    DICE,       // 掷骰子魔法表情
    SHAKE,      // 窗口抖动（戳一戳）
    ANONYMOUS,  // 匿名消息
    SHARE,      // 链接分享
    CONTACT,    // 推荐好友/群
    LOCATION,   // 位置
    MUSIC,      // 音乐分享
    IMAGE,      // 图片
    REPLY,      // 回复
    RED_BAG,     // 红包
    POKE,       // 戳一戳
    GIFT,       // 礼物
    FORWARD,    // 合并转发
    NODE,       // 合并转发消息节点
    XML,        // XML消息
    JSON,       // JSON消息
    CARD_IMAGE,  // 卡片图片
    TTS,         // 文本转语音
}
