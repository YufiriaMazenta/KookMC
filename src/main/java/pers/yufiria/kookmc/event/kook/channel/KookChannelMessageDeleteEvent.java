package pers.yufiria.kookmc.event.kook.channel;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.channel.Channel;

public class KookChannelMessageDeleteEvent extends KookChannelEvent {

    private final String messageId;

    public KookChannelMessageDeleteEvent(long timeStamp, Channel channel, String messageId) {
        super(timeStamp, channel);
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
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
