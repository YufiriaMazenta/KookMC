package com.github.yufiriamazenta.kookmc.event.kook.channel;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;

/**
 * 当频道内一条消息被置顶时触发
 */
public class KookChannelMessagePinEvent extends KookChannelEvent {

    private final String messageId;
    private final User operator;

    public KookChannelMessagePinEvent(final long timeStamp, final Channel channel, final String messageId, User operator) {
        super(timeStamp, channel);
        this.messageId = messageId;
        this.operator = operator;
    }

    /**
     * 获取被置顶的消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取置顶此消息的用户
     */
    public User getOperator() {
        return operator;
    }

}
