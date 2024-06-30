package pers.yufiria.kookmc.event.kook;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 所有Kook事件的基类，需要注意，所有的Kook事件均为异步触发，不可直接使用Bukkit方法
 */
public abstract class KookEvent extends Event {


    private final long timeStamp;

    protected KookEvent(long timeStamp) {
        super(true);
        this.timeStamp = timeStamp;
    }

    /**
     * 获取此事件发生时的时间戳
     * @return 此事件发生时的时间戳
     */
    public long getTimeStamp() {
        return timeStamp;
    }

}
