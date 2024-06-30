package pers.yufiria.kookmc.event.kook.pm;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当私聊消息被删除时触发
 */
public class KookPrivateMessageDeleteEvent extends KookPrivateMessageEvent {

    private final String messageId;

    public KookPrivateMessageDeleteEvent(long timeStamp, String messageId) {
        super(timeStamp);
        this.messageId = messageId;
    }

    /**
     * 获取被删除的私聊消息
     */
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
