package com.github.yufiriamazenta.kookmc.event.kook.guild;

import snw.jkook.entity.Guild;

/**
 * 当Kook服务器更新信息时触发
 */
public class KookGuildInfoUpdateEvent extends KookGuildEvent {

    public KookGuildInfoUpdateEvent(long timeStamp, Guild guild) {
        super(timeStamp, guild);
    }

}
