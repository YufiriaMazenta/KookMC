package com.github.yufiriamazenta.kookmc.event.kook.item;

import com.github.yufiriamazenta.kookmc.event.kook.KookEvent;

public abstract class KookItemEvent extends KookEvent {
    protected KookItemEvent(long timeStamp) {
        super(timeStamp);
    }

}
