package com.github.yufiriamazenta.kookmc.event.kook.user;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * 当用户加入一个服务器时触发
 */
public class KookUserJoinGuildEvent extends KookUserEvent {

    private final Guild guild;

    public KookUserJoinGuildEvent(final long timeStamp, final User user, final Guild guild) {
        super(timeStamp, user);
        this.guild = Objects.requireNonNull(guild);
    }

    /**
     * 获取用户加入的服务器
     */
    public Guild getGuild() {
        return guild;
    }

}
