package com.github.yufiriamazenta.kookmc.event.kook.channel;

import snw.jkook.entity.channel.Channel;

/**
 * 当一个频道的信息被改变时触发
 */
public class KookChannelInfoUpdateEvent extends KookChannelEvent {

    public KookChannelInfoUpdateEvent(long timeStamp, Channel channel) {
        super(timeStamp, channel);
    }

}
