package com.github.yufiriamazenta.kookmc.event.kook.channel;

import snw.jkook.entity.channel.Channel;

/**
 * 当管理员创建一个Kook频道时触发
 */
public class KookChannelCreateEvent extends KookChannelEvent {

    public KookChannelCreateEvent(long timeStamp, Channel channel) {
        super(timeStamp, channel);
    }

}
