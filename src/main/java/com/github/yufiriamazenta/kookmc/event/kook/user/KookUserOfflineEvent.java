package com.github.yufiriamazenta.kookmc.event.kook.user;

import snw.jkook.entity.User;

/**
 * 当用户离线时触发
 */
public class KookUserOfflineEvent extends KookUserEvent {

    public KookUserOfflineEvent(final long timeStamp, final User user) {
        super(timeStamp, user);
    }

}
