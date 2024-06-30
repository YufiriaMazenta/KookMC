package pers.yufiria.kookmc.event.kook.role;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.Role;

/**
 * 当创建一个角色时触发
 */
public class KookRoleCreateEvent extends KookRoleEvent {

    public KookRoleCreateEvent(final long timeStamp, final Role role) {
        super(timeStamp, role);
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
