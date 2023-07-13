package com.github.yufiriamazenta.kookmc.event.kook;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 所有Kook事件的基类
 */
public abstract class KookEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final long timeStamp;

    protected KookEvent(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }


    /**
     * 获取此事件发生时的时间戳
     * @return 此事件发生时的时间戳
     */
    public long getTimeStamp() {
        return timeStamp;
    }

}
