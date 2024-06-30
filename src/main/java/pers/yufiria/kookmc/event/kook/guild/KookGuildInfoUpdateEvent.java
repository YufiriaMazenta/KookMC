package pers.yufiria.kookmc.event.kook.guild;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.Guild;

/**
 * 当Kook服务器更新信息时触发
 */
public class KookGuildInfoUpdateEvent extends KookGuildEvent {

    public KookGuildInfoUpdateEvent(long timeStamp, Guild guild) {
        super(timeStamp, guild);
    }

    private static final HandlerList handlerList = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
