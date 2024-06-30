package pers.yufiria.kookmc.event.kook.pm;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当私聊消息被更新时触发
 */
public class KookPrivateMessageUpdateEvent extends KookPrivateMessageEvent {

    private final String messageId;
    private final String content;

    public KookPrivateMessageUpdateEvent(long timeStamp, String messageId, String content) {
        super(timeStamp);
        this.messageId = messageId;
        this.content = content;
    }

    /**
     * 获取被更新的消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取消息的更新内容
     */
    public String getContent() {
        return content;
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
