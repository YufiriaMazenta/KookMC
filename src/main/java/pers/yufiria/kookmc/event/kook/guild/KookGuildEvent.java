package pers.yufiria.kookmc.event.kook.guild;

import pers.yufiria.kookmc.event.kook.KookEvent;
import snw.jkook.entity.Guild;

/**
 * Kook服务器相关事件的基础类
 */
public abstract class KookGuildEvent extends KookEvent {

    private final Guild guild;

    KookGuildEvent(final long timeStamp, final Guild guild) {
        super(timeStamp);
        this.guild = guild;
    }

    /**
     * 获取此事件发生的服务器
     */
    public Guild getGuild() {
        return guild;
    }

}
