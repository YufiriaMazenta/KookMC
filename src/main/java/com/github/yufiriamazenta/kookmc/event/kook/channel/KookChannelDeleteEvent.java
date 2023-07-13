package com.github.yufiriamazenta.kookmc.event.kook.channel;

import org.jetbrains.annotations.Contract;
import snw.jkook.entity.Guild;
import snw.jkook.entity.channel.Channel;

import java.util.Objects;

/**
 * 当管理员删除一个频道时触发
 */
public class KookChannelDeleteEvent extends KookChannelEvent {

    private final String channelId;
    private final Guild guild;

    public KookChannelDeleteEvent(final long timeStamp, final String channelId, Guild guild) {
        super(timeStamp, null);
        this.channelId = Objects.requireNonNull(channelId);
        this.guild = guild;
    }

    /**
     * 获取被删除的频道
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 获取被删除频道所在的服务器
     */
    public Guild getGuild() {
        return guild;
    }

    @Deprecated
    @Override
    @Contract("-> fail")
    public Channel getChannel() {
        throw new UnsupportedOperationException("No channel available for ChannelDeleteEvent!");
    }

}
