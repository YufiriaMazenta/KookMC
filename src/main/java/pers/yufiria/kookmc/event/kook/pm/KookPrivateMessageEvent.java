package pers.yufiria.kookmc.event.kook.pm;

import pers.yufiria.kookmc.event.kook.KookEvent;

/**
 * 私聊相关事件的基础类
 */
public abstract class KookPrivateMessageEvent extends KookEvent {
    KookPrivateMessageEvent(final long timeStamp) {
        super(timeStamp);
    }

}
