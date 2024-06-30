package pers.yufiria.kookmc.event.kook.user;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.Reaction;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * 当用户对某消息添加回应时触发，例如添加一个表情
 */
public class KookUserAddReactionEvent extends KookUserEvent {

    private final String messageId;
    private final Reaction reaction;

    public KookUserAddReactionEvent(final long timeStamp, final User user, final String messageId, final Reaction reaction) {
        super(timeStamp, user);
        this.messageId = Objects.requireNonNull(messageId);
        this.reaction = Objects.requireNonNull(reaction);
    }

    /**
     * 获取被回应的消息ID
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 获取被添加的回应
     */
    public Reaction getReaction() {
        return reaction;
    }

    private static final HandlerList handlerList = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
