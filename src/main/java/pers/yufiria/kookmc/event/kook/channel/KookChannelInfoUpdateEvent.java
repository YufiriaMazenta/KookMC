package pers.yufiria.kookmc.event.kook.channel;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.channel.Channel;

/**
 * 当一个频道的信息被改变时触发
 */
public class KookChannelInfoUpdateEvent extends KookChannelEvent {

    public KookChannelInfoUpdateEvent(long timeStamp, Channel channel) {
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
