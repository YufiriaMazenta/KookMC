package com.github.yufiriamazenta.kookmc.event.kook.guild;

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.Guild;

/**
 * 当Kook服务器添加了一个表情时触发
 */
public class KookGuildAddEmojiEvent extends KookGuildEvent {

    private final CustomEmoji emoji;

    public KookGuildAddEmojiEvent(long timeStamp, Guild guild, CustomEmoji emoji) {
        super(timeStamp, guild);
        this.emoji = emoji;
    }

    /**
     * 获取被添加的Emoji
     */
    public CustomEmoji getEmoji() {
        return emoji;
    }

}
