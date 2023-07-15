package com.github.yufiriamazenta.kookmc.event.kook.user;

import snw.jkook.entity.User;

/**
 * 当用户上线时触发
 */
public class KookUserOnlineEvent extends KookUserEvent {

    public KookUserOnlineEvent(final long timeStamp, final User user) {
        super(timeStamp, user);
    }

}
