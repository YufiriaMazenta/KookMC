package com.github.yufiriamazenta.kookmc.event.kook.guild;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

/**
 * 当Kook服务器的用户修改其服务器昵称时触发
 */
public class KookGuildUserNickNameUpdateEvent extends KookGuildEvent {

    private final User user;
    private final String newNickName;

    public KookGuildUserNickNameUpdateEvent(long timeStamp, Guild guild, User user, String newNickName) {
        super(timeStamp, guild);
        this.user = user;
        this.newNickName = newNickName;
    }

    /**
     * 获取修改昵称的用户
     */
    public User getUser() {
        return user;
    }

    /**
     * 获取此用户的新昵称
     */
    public String getNewNickName() {
        return newNickName;
    }

}
