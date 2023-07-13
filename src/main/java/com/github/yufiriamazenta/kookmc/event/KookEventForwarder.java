package com.github.yufiriamazenta.kookmc.event;

import com.github.yufiriamazenta.kookmc.event.kook.channel.*;
import org.bukkit.Bukkit;
import snw.jkook.event.EventHandler;
import snw.jkook.event.Listener;
import snw.jkook.event.channel.*;

public enum KookEventForwarder implements Listener {

    INSTANCE;

    @EventHandler
    public void onChannelCreate(ChannelCreateEvent event) {
        Bukkit.getPluginManager().callEvent(new KookChannelCreateEvent(event.getTimeStamp(), event.getChannel()));
    }

    @EventHandler
    public void onChannelDelete(ChannelDeleteEvent event) {
        Bukkit.getPluginManager().callEvent(new KookChannelDeleteEvent(event.getTimeStamp(), event.getChannelId(), event.getGuild()));
    }

    @EventHandler
    public void onChannelInfoUpdate(ChannelInfoUpdateEvent event) {
        Bukkit.getPluginManager().callEvent(new KookChannelInfoUpdateEvent(event.getTimeStamp(), event.getChannel()));
    }

    @EventHandler
    public void onChannelMessage(ChannelMessageEvent event) {
        Bukkit.getPluginManager().callEvent(new KookChannelMessageEvent(event.getTimeStamp(), event.getChannel(), event.getMessage()));
    }

    @EventHandler
    public void onChannelMessagePin(ChannelMessagePinEvent event) {
        Bukkit.getPluginManager().callEvent(new KookChannelMessagePinEvent(event.getTimeStamp(), event.getChannel(), event.getMessageId(), event.getOperator()));
    }

    @EventHandler
    public void onChannelMessageUnpin(ChannelMessageUnpinEvent event) {
        Bukkit.getPluginManager().callEvent(new KookChannelMessageUnpinEvent(event.getTimeStamp(), event.getChannel(), event.getMessageId(), event.getOperator()));
    }

    @EventHandler
    public void onChannelMessageUpdate(ChannelMessageUpdateEvent event) {
        Bukkit.getPluginManager().callEvent(new KookChannelMessageUpdateEvent(event.getTimeStamp(), event.getChannel(), event.getMessageId(), event.getContent()));
    }

}
