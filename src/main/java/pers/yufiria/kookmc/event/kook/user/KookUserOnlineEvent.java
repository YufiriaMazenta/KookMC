package pers.yufiria.kookmc.event.kook.user;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.User;

/**
 * 当用户上线时触发
 */
public class KookUserOnlineEvent extends KookUserEvent {

    public KookUserOnlineEvent(final long timeStamp, final User user) {
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
