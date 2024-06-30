package pers.yufiria.kookmc.event.kook.channel;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Channel;

/**
 * 当频道内一条消息被取消置顶时触发
 */
public class KookChannelMessageUnpinEvent extends KookChannelEvent {

    private final String messageId;
    private final User operator;

    public KookChannelMessageUnpinEvent(final long timeStamp, final Channel channel, final String messageId, User operator) {
        super(timeStamp, channel);
        this.messageId = messageId;
        this.operator = operator;
    }

    /**
     * 获取被取消置顶的消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取取消置顶此消息的用户
     */
    public User getOperator() {
        return operator;
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
