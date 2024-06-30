package pers.yufiria.kookmc.event.kook.item;

import pers.yufiria.kookmc.event.kook.KookEvent;

public abstract class KookItemEvent extends KookEvent {
    protected KookItemEvent(long timeStamp) {
        super(timeStamp);
    }

}
