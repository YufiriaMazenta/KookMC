package pers.yufiria.kookmc.event;

import pers.yufiria.kookmc.event.kook.channel.*;
import pers.yufiria.kookmc.event.kook.guild.*;
import pers.yufiria.kookmc.event.kook.item.KookItemConsumedEvent;
import pers.yufiria.kookmc.event.kook.pm.KookPrivateMessageDeleteEvent;
import pers.yufiria.kookmc.event.kook.pm.KookPrivateMessageReceivedEvent;
import pers.yufiria.kookmc.event.kook.pm.KookPrivateMessageUpdateEvent;
import pers.yufiria.kookmc.event.kook.role.KookRoleCreateEvent;
import pers.yufiria.kookmc.event.kook.role.KookRoleDeleteEvent;
import pers.yufiria.kookmc.event.kook.role.KookRoleInfoUpdateEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import pers.yufiria.kookmc.event.kook.user.*;
import snw.jkook.event.EventHandler;
import snw.jkook.event.Listener;
import snw.jkook.event.channel.*;
import snw.jkook.event.guild.*;
import snw.jkook.event.item.ItemConsumedEvent;
import snw.jkook.event.pm.PrivateMessageDeleteEvent;
import snw.jkook.event.pm.PrivateMessageReceivedEvent;
import snw.jkook.event.pm.PrivateMessageUpdateEvent;
import snw.jkook.event.role.RoleCreateEvent;
import snw.jkook.event.role.RoleDeleteEvent;
import snw.jkook.event.role.RoleInfoUpdateEvent;
import snw.jkook.event.user.*;

public enum KookEventForwarder implements Listener {

    INSTANCE;

    //以下为频道相关事件

    @EventHandler
    public void onChannelCreate(ChannelCreateEvent event) {
        callBukkitEvent(new KookChannelCreateEvent(event.getTimeStamp(), event.getChannel()));
    }

    @EventHandler
    public void onChannelDelete(ChannelDeleteEvent event) {
        callBukkitEvent(new KookChannelDeleteEvent(event.getTimeStamp(), event.getChannelId(), event.getGuild()));
    }

    @EventHandler
    public void onChannelInfoUpdate(ChannelInfoUpdateEvent event) {
        callBukkitEvent(new KookChannelInfoUpdateEvent(event.getTimeStamp(), event.getChannel()));
    }

    @EventHandler
    public void onChannelMessage(ChannelMessageEvent event) {
        callBukkitEvent(new KookChannelMessageEvent(event.getTimeStamp(), event.getChannel(), event.getMessage()));
    }

    @EventHandler
    public void onChannelMessagePin(ChannelMessagePinEvent event) {
        callBukkitEvent(new KookChannelMessagePinEvent(event.getTimeStamp(), event.getChannel(), event.getMessageId(), event.getOperator()));
    }

    @EventHandler
    public void onChannelMessageUnpin(ChannelMessageUnpinEvent event) {
        callBukkitEvent(new KookChannelMessageUnpinEvent(event.getTimeStamp(), event.getChannel(), event.getMessageId(), event.getOperator()));
    }

    @EventHandler
    public void onChannelMessageUpdate(ChannelMessageUpdateEvent event) {
        callBukkitEvent(new KookChannelMessageUpdateEvent(event.getTimeStamp(), event.getChannel(), event.getMessageId(), event.getContent()));
    }

    @EventHandler
    public void onChannelMessageDelete(ChannelMessageDeleteEvent event) {
        callBukkitEvent(new KookChannelMessageDeleteEvent(event.getTimeStamp(), event.getChannel(), event.getMessageId()));
    }

    //以下为服务器相关事件

    @EventHandler
    public void onGuildAddEmoji(GuildAddEmojiEvent event) {
        callBukkitEvent(new KookGuildAddEmojiEvent(event.getTimeStamp(), event.getGuild(), event.getEmoji()));
    }

    @EventHandler
    public void onGuildBanUser(GuildBanUserEvent event) {
        callBukkitEvent(new KookGuildBanUserEvent(event.getTimeStamp(), event.getGuild(), event.getBanned(), event.getOperator(), event.getReason()));
    }

    @EventHandler
    public void onGuildDelete(GuildDeleteEvent event) {
        callBukkitEvent(new KookGuildDeleteEvent(event.getTimeStamp(), event.getGuildId()));
    }

    @EventHandler
    public void onGuildInfoUpdate(GuildInfoUpdateEvent event) {
        callBukkitEvent(new KookGuildInfoUpdateEvent(event.getTimeStamp(), event.getGuild()));
    }

    @EventHandler
    public void onGuildRemoveEmoji(GuildRemoveEmojiEvent event) {
        callBukkitEvent(new KookGuildRemoveEmojiEvent(event.getTimeStamp(), event.getGuild(), event.getEmoji()));
    }

    @EventHandler
    public void onGuildUnbanUser(GuildUnbanUserEvent event) {
        callBukkitEvent(new KookGuildUnbanUserEvent(event.getTimeStamp(), event.getGuild(), event.getUnbanned(), event.getOperator()));
    }

    @EventHandler
    public void onGuildUpdateEmoji(GuildUpdateEmojiEvent event) {
        callBukkitEvent(new KookGuildUpdateEmojiEvent(event.getTimeStamp(), event.getGuild(), event.getEmoji()));
    }

    @EventHandler
    public void onGuildUserNickNameUpdate(GuildUserNickNameUpdateEvent event) {
        callBukkitEvent(new KookGuildUserNickNameUpdateEvent(event.getTimeStamp(), event.getGuild(), event.getUser(), event.getNewNickName()));
    }

    //以下为物品相关事件

    @EventHandler
    public void onItemConsumedEvent(ItemConsumedEvent event) {
        callBukkitEvent(new KookItemConsumedEvent(event.getTimeStamp(), event.getConsumer(), event.getWhoBeAffected(), event.getItemId()));
    }

    //以下为私聊相关事件

    @EventHandler
    public void onPrivateMsgDelete(PrivateMessageDeleteEvent event) {
        callBukkitEvent(new KookPrivateMessageDeleteEvent(event.getTimeStamp(), event.getMessageId()));
    }

    @EventHandler
    public void onPrivateMsgReceived(PrivateMessageReceivedEvent event) {
        callBukkitEvent(new KookPrivateMessageReceivedEvent(event.getTimeStamp(), event.getUser(), event.getMessage()));
    }

    @EventHandler
    public void onPrivateMsgUpdate(PrivateMessageUpdateEvent event) {
        callBukkitEvent(new KookPrivateMessageUpdateEvent(event.getTimeStamp(), event.getMessageId(), event.getContent()));
    }

    //以下为服务器角色相关事件

    @EventHandler
    public void onRoleCreate(RoleCreateEvent event) {
        callBukkitEvent(new KookRoleCreateEvent(event.getTimeStamp(), event.getRole()));
    }

    @EventHandler
    public void onRoleDelete(RoleDeleteEvent event) {
        callBukkitEvent(new KookRoleDeleteEvent(event.getTimeStamp(), event.getRole()));
    }

    @EventHandler
    public void onRoleInfoUpdate(RoleInfoUpdateEvent event) {
        callBukkitEvent(new KookRoleInfoUpdateEvent(event.getTimeStamp(), event.getRole()));
    }

    //以下为用户相关事件

    @EventHandler
    public void onUserAddReaction(UserAddReactionEvent event) {
        callBukkitEvent(new KookUserAddReactionEvent(event.getTimeStamp(), event.getUser(), event.getMessageId(), event.getReaction()));
    }

    @EventHandler
    public void onUserClickButton(UserClickButtonEvent event) {
        callBukkitEvent(new KookUserClickButtonEvent(event.getTimeStamp(), event.getUser(), event.getMessageId(), event.getValue(), event.getChannel()));
    }

    @EventHandler
    public void onUserInfoUpdate(UserInfoUpdateEvent event) {
        callBukkitEvent(new KookUserInfoUpdateEvent(event.getTimeStamp(), event.getUser()));
    }

    @EventHandler
    public void onUserJoinGuild(UserJoinGuildEvent event) {
        callBukkitEvent(new KookUserJoinGuildEvent(event.getTimeStamp(), event.getUser(), event.getGuild()));
    }

    @EventHandler
    public void onUserJoinVoiceChannel(UserJoinVoiceChannelEvent event) {
        callBukkitEvent(new KookUserJoinVoiceChannelEvent(event.getTimeStamp(), event.getUser(), event.getChannel()));
    }

    @EventHandler
    public void onUserLeaveGuild(UserLeaveGuildEvent event) {
        if (event.getGuild() == null) {
            callBukkitEvent(new KookUserLeaveGuildEvent(event.getTimeStamp(), event.getUser(), event.getGuildId()));
        } else {
            callBukkitEvent(new KookUserLeaveGuildEvent(event.getTimeStamp(), event.getUser(), event.getGuild()));
        }
    }

    @EventHandler
    public void onUserLeaveVoiceChannel(UserLeaveVoiceChannelEvent event) {
        callBukkitEvent(new KookUserLeaveVoiceChannelEvent(event.getTimeStamp(), event.getUser(), event.getChannel()));
    }

    @EventHandler
    public void onUserOffline(UserOfflineEvent event) {
        callBukkitEvent(new KookUserOfflineEvent(event.getTimeStamp(), event.getUser()));
    }

    @EventHandler
    public void onUserOnline(UserOnlineEvent event) {
        callBukkitEvent(new KookUserOnlineEvent(event.getTimeStamp(), event.getUser()));
    }

    @EventHandler
    public void onUserRemoveReaction(UserRemoveReactionEvent event) {
        callBukkitEvent(new KookUserRemoveReactionEvent(event.getTimeStamp(), event.getUser(), event.getMessageId(), event.getReaction()));
    }
    
    private void callBukkitEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }

}
