package pers.yufiria.kookmc.event.kook.pm;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.User;
import snw.jkook.message.PrivateMessage;

/**
 * 当用户向机器人发送私聊消息时触发
 */
public class KookPrivateMessageReceivedEvent extends KookPrivateMessageEvent {

    private final User user;
    private final PrivateMessage pm;

    public KookPrivateMessageReceivedEvent(long timeStamp, User user, PrivateMessage pm) {
        super(timeStamp);
        this.user = user;
        this.pm = pm;
    }

    /**
     * 获取发送消息的用户
     */
    public User getUser() {
        return user;
    }

    /**
     * 获取发送的消息
     */
    public PrivateMessage getMessage() {
        return pm;
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
