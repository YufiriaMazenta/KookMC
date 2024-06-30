package pers.yufiria.kookmc.event.kook.user;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snw.jkook.entity.Guild;
import snw.jkook.entity.User;

import java.util.Objects;

/**
 * 当用户离开服务器时触发
 */
public class KookUserLeaveGuildEvent extends KookUserEvent {

    private final Guild guild;
    private final String guildId;

    public KookUserLeaveGuildEvent(final long timeStamp, final User user, final Guild guild) {
        super(timeStamp, user);
        this.guild = Objects.requireNonNull(guild);
        this.guildId = guild.getId();
    }

    public KookUserLeaveGuildEvent(long timeStamp, User user, String guildId) {
        super(timeStamp, user);
        this.guild = null;
        this.guildId = guildId;
    }

    /**
     * 获取退出的服务器，可能会为null
     * @return 推出的公会
     */
    @Nullable
    public Guild getGuild() {
        return guild;
    }

    /**
     * 获取退出的公会id
     * @return 退出的公会ID
     */
    public String getGuildId() {
        return guildId;
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
