package pers.yufiria.kookmc.event.kook.guild;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.Guild;

/**
 * 当Kook服务器删除一个表情时触发
 */
public class KookGuildRemoveEmojiEvent extends KookGuildEvent {

    private final CustomEmoji emoji;

    public KookGuildRemoveEmojiEvent(long timeStamp, Guild guild, CustomEmoji emoji) {
        super(timeStamp, guild);
        this.emoji = emoji;
    }

    /**
     * 获取被删除的Emoji
     */
    public CustomEmoji getEmoji() {
        return emoji;
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
