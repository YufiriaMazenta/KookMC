package pers.yufiria.kookmc.event.kook.role;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.Role;

/**
 * 当一个角色被删除时触发
 */
public class KookRoleDeleteEvent extends KookRoleEvent {

    public KookRoleDeleteEvent(final long timeStamp, final Role role) {
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
