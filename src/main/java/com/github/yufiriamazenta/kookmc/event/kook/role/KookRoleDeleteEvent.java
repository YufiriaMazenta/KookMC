package com.github.yufiriamazenta.kookmc.event.kook.role;

import snw.jkook.entity.Role;

/**
 * 当一个角色被删除时触发
 */
public class KookRoleDeleteEvent extends KookRoleEvent {

    public KookRoleDeleteEvent(final long timeStamp, final Role role) {
        super(timeStamp, role);
    }

}
