package com.github.yufiriamazenta.kookmc.event.kook.guild;

import snw.jkook.entity.Guild;

/**
 * 当某个Kook服务器被删除时触发
 */
public class KookGuildDeleteEvent extends KookGuildEvent {

    private final String guildId;

    public KookGuildDeleteEvent(final long timeStamp, String guildId) {
        super(timeStamp, null);
        this.guildId = guildId;
    }

    @Deprecated
    @Override
    public Guild getGuild() {
        throw new UnsupportedOperationException("Use GuildDeleteEvent#getGuildId instead");
    }

    /**
     * 获取被删除的Kook服务器ID
     */
    public String getGuildId() {
        return guildId;
    }

}
