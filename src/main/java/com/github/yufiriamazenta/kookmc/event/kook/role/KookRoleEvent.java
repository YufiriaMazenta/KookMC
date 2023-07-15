package com.github.yufiriamazenta.kookmc.event.kook.role;

import com.github.yufiriamazenta.kookmc.event.kook.KookEvent;
import snw.jkook.entity.Role;

import java.util.Objects;

/**
 * 服务器角色相关事件的基础类
 */
public abstract class KookRoleEvent extends KookEvent {
    private final Role role;

    KookRoleEvent(final long timeStamp, final Role role) {
        super(timeStamp);
        this.role = Objects.requireNonNull(role);
    }

    /**
     * 获取此事件涉及到的角色
     */
    public Role getRole() {
        return role;
    }

}
