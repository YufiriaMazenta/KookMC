package com.github.yufiriamazenta.kookmc.event.kook.channel;

import snw.jkook.entity.channel.Channel;

/**
 * 当频道内一条消息被修改时触发
 */
public class KookChannelMessageUpdateEvent extends KookChannelEvent {

    private final String messageId;
    private final String content;

    public KookChannelMessageUpdateEvent(final long timeStamp, final Channel channel, final String messageId, String content) {
        super(timeStamp, channel);
        this.messageId = messageId;
        this.content = content;
    }

    /**
     * 获取被修改的消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取此次更新的消息内容
     */
    public String getContent() {
        return content;
    }

}
