package pers.yufiria.kookmc.event.kook.guild;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.Guild;

/**
 * 当Kook服务器更新表情包时触发
 */
public class KookGuildUpdateEmojiEvent extends KookGuildEvent {

    private final CustomEmoji emoji;

    public KookGuildUpdateEmojiEvent(long timeStamp, Guild guild, CustomEmoji emoji) {
        super(timeStamp, guild);
        this.emoji = emoji;
    }

    /**
     * 获取被修改的emoji
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
