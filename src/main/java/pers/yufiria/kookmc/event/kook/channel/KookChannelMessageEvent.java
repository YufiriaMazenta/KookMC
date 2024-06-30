package pers.yufiria.kookmc.event.kook.channel;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.channel.Channel;
import snw.jkook.entity.channel.TextChannel;
import snw.jkook.message.ChannelMessage;
import snw.jkook.message.TextChannelMessage;

import java.util.Objects;

/**
 * 当Kook频道内发送一条消息时触发
 */
public class KookChannelMessageEvent extends KookChannelEvent {

    private final ChannelMessage message;

    public KookChannelMessageEvent(final long timeStamp, final Channel channel, final ChannelMessage message) {
        super(timeStamp, channel);
        this.message = Objects.requireNonNull(message);
    }

    /**
     * 获取此事件发送的消息
     */
    public ChannelMessage getMessage() {
        return message;
    }

    @Override
    public TextChannel getChannel() {
        return (TextChannel) super.getChannel();
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
