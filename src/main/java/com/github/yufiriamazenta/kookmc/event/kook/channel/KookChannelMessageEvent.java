package com.github.yufiriamazenta.kookmc.event.kook.channel;

import snw.jkook.entity.channel.TextChannel;
import snw.jkook.message.TextChannelMessage;

import java.util.Objects;

/**
 * 当Kook频道内发送一条消息时触发
 */
public class KookChannelMessageEvent extends KookChannelEvent {

    private final TextChannelMessage message;

    public KookChannelMessageEvent(final long timeStamp, final TextChannel channel, final TextChannelMessage message) {
        super(timeStamp, channel);
        this.message = Objects.requireNonNull(message);
    }

    /**
     * 获取此事件发送的消息
     */
    public TextChannelMessage getMessage() {
        return message;
    }

    @Override
    public TextChannel getChannel() {
        return (TextChannel) super.getChannel();
    }

}
