package pers.yufiria.kookmc.event.kook.role;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.Role;

/**
 * 当一个角色的信息被修改时触发
 */
public class KookRoleInfoUpdateEvent extends KookRoleEvent {

    public KookRoleInfoUpdateEvent(final long timeStamp, final Role role) {
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
