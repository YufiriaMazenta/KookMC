package com.github.yufiriamazenta.kookmc.event.kook.pm;

/**
 * 当私聊消息被删除时触发
 */
public class KookPrivateMessageDeleteEvent extends KookPrivateMessageEvent {

    private final String messageId;

    public KookPrivateMessageDeleteEvent(long timeStamp, String messageId) {
        super(timeStamp);
        this.messageId = messageId;
    }

    /**
     * 获取被删除的私聊消息
     */
    public String getMessageId() {
        return messageId;
    }

}
