package pers.yufiria.kookmc.event.kook.channel;

import pers.yufiria.kookmc.event.kook.KookEvent;
import snw.jkook.entity.channel.Channel;

/**
 * 频道相关事件的基础类
 */
public abstract class KookChannelEvent extends KookEvent {

    private final Channel channel;

    protected KookChannelEvent(final long timeStamp, final Channel channel) {
        super(timeStamp);
        this.channel = channel;
    }

    /**
     * 获取此事件涉及的频道
     * @return 此事件涉及的频道
     */
    public Channel getChannel() {
        return channel;
    }

}
