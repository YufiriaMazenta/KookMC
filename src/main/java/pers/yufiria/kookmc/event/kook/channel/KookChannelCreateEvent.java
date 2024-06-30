package pers.yufiria.kookmc.event.kook.channel;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.channel.Channel;

/**
 * 当管理员创建一个Kook频道时触发
 */
public class KookChannelCreateEvent extends KookChannelEvent {

    public KookChannelCreateEvent(long timeStamp, Channel channel) {
        super(timeStamp, channel);
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
