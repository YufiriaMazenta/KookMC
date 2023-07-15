package com.github.yufiriamazenta.kookmc.event.kook.role;

import snw.jkook.entity.Role;

/**
 * 当创建一个角色时触发
 */
public class KookRoleCreateEvent extends KookRoleEvent {

    public KookRoleCreateEvent(final long timeStamp, final Role role) {
        super(timeStamp, role);
    }

}
