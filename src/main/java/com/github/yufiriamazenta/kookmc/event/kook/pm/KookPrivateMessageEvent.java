package com.github.yufiriamazenta.kookmc.event.kook.pm;

import com.github.yufiriamazenta.kookmc.event.kook.KookEvent;

/**
 * 私聊相关事件的基础类
 */
public abstract class KookPrivateMessageEvent extends KookEvent {
    KookPrivateMessageEvent(final long timeStamp) {
        super(timeStamp);
    }

}
