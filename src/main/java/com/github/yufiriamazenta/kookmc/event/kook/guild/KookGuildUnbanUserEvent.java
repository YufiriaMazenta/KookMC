package com.github.yufiriamazenta.kookmc.event.kook.guild;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 当Kook服务器取消封禁用户时触发
 */
public class KookGuildUnbanUserEvent extends KookGuildEvent {

    private final List<User> unbanned;
    private final User operator;

    public KookGuildUnbanUserEvent(final long timeStamp, final Guild guild, final List<User> unbanned, final User operator) {
        super(timeStamp, guild);
        this.unbanned = Collections.unmodifiableList(Objects.requireNonNull(unbanned));
        this.operator = Objects.requireNonNull(operator);
    }

    /**
     * 获取被取消封禁的用户列表
     */
    public List<User> getUnbanned() {
        return unbanned;
    }

    /**
     * 获取取消封禁的管理员
     */
    public User getOperator() {
        return operator;
    }

}
