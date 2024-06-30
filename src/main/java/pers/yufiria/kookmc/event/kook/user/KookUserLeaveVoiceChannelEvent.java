package pers.yufiria.kookmc.event.kook.user;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.VoiceChannel;

import java.util.Objects;

/**
 * 当用户离开语音频道时触发
 */
public class KookUserLeaveVoiceChannelEvent extends KookUserEvent {

    private final VoiceChannel channel;

    public KookUserLeaveVoiceChannelEvent(final long timeStamp, final User user, final VoiceChannel channel) {
        super(timeStamp, user);
        this.channel = Objects.requireNonNull(channel);
    }

    /**
     * 获取事件涉及的语音频道
     */
    public VoiceChannel getChannel() {
        return channel;
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
