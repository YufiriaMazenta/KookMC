package com.github.yufiriamazenta.kookmc.event.kook.guild;

import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 当kook服务器封禁某用户时触发
 */
public class KookGuildBanUserEvent extends KookGuildEvent {

    private final List<User> banned;
    private final User operator;
    private final String reason;

    public KookGuildBanUserEvent(final long timeStamp, final Guild guild, final List<User> banned, final User operator, String reason) {
        super(timeStamp, guild);
        this.banned = Collections.unmodifiableList(Objects.requireNonNull(banned));
        this.operator = Objects.requireNonNull(operator);
        this.reason = Objects.requireNonNull(reason);
    }

    /**
     * 获取被封禁的用户
     */
    public List<User> getBanned() {
        return banned;
    }

    /**
     * 获取封禁这些用户的管理员
     */
    public User getOperator() {
        return operator;
    }

    /**
     * 获取封禁原因
     */
    public String getReason() {
        return reason;
    }

}
