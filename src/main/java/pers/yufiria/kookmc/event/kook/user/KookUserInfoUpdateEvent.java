package pers.yufiria.kookmc.event.kook.user;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.User;

/**
 * 当用户修改个人信息时触发
 * 需要注意，此事件只会在两种情况下触发：
 * <ul>
 * <li>此用户正在和机器人聊天</li>
 * <li>此用户是机器人的好友</li>
 * </ul>
 */
public class KookUserInfoUpdateEvent extends KookUserEvent {

    public KookUserInfoUpdateEvent(final long timeStamp, final User user) {
        super(timeStamp, user);
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
