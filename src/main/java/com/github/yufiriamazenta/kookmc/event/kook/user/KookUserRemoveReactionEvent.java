package com.github.yufiriamazenta.kookmc.event.kook.user;

import snw.jkook.entity.Reaction;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * 当用户删除对某消息的回应时触发
 */
public class KookUserRemoveReactionEvent extends KookUserEvent {

    private final String messageId;
    private final Reaction reaction;

    public KookUserRemoveReactionEvent(final long timeStamp, final User user, final String messageId, final Reaction reaction) {
        super(timeStamp, user);
        this.messageId = Objects.requireNonNull(messageId);
        this.reaction = Objects.requireNonNull(reaction);
    }

    /**
     * 获取此事件涉及的消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取被用户移除的回应
     */
    public Reaction getReaction() {
        return reaction;
    }

}
