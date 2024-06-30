package pers.yufiria.kookmc.event.kook.user;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;
import snw.jkook.entity.channel.TextChannel;

import java.util.Objects;

/**
 * 当用户点击消息中的按钮时触发
 */
public class KookUserClickButtonEvent extends KookUserEvent {

    private final String messageId;
    private final String value;
    private final Channel channel;

    public KookUserClickButtonEvent(final long timeStamp, final User user, final String messageId, final String value, Channel channel) {
        super(timeStamp, user);
        this.messageId = Objects.requireNonNull(messageId);
        this.value = Objects.requireNonNull(value);
        this.channel = channel;
    }

    /**
     * 获取被点击的消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取被点击的按钮的值
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取此事件发生的频道
     */
    @Nullable
    public Channel getChannel() {
        return channel;
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
