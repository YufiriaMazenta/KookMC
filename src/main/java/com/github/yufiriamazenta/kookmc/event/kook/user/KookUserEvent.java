package com.github.yufiriamazenta.kookmc.event.kook.user;

import com.github.yufiriamazenta.kookmc.event.kook.KookEvent;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * Kook用户相关事件的基础类
 */
public abstract class KookUserEvent extends KookEvent {
    private final User user;

    KookUserEvent(final long timeStamp, final User user) {
        super(timeStamp);
        this.user = Objects.requireNonNull(user);
    }

    /**
     * 获取此事件相关用户
     */
    public User getUser() {
        return user;
    }

}
