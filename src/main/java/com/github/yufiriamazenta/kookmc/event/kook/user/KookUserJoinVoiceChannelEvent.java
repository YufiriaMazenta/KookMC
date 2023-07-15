package com.github.yufiriamazenta.kookmc.event.kook.user;

import snw.jkook.entity.User;
import snw.jkook.entity.channel.VoiceChannel;

import java.util.Objects;

/**
 * 当用户加入一个语音频道时触发
 */
public class KookUserJoinVoiceChannelEvent extends KookUserEvent {

    private final VoiceChannel channel;

    public KookUserJoinVoiceChannelEvent(final long timeStamp, final User user, final VoiceChannel channel) {
        super(timeStamp, user);
        this.channel = Objects.requireNonNull(channel);
    }

    /**
     * 获取用户加入的语音频道
     */
    public VoiceChannel getChannel() {
        return channel;
    }

}
