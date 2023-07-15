package com.github.yufiriamazenta.kookmc.event.kook.role;

import snw.jkook.entity.Role;

/**
 * 当一个角色的信息被修改时触发
 */
public class KookRoleInfoUpdateEvent extends KookRoleEvent {

    public KookRoleInfoUpdateEvent(final long timeStamp, final Role role) {
        super(timeStamp, role);
    }

}
