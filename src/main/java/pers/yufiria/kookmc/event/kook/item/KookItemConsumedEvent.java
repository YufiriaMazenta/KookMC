package pers.yufiria.kookmc.event.kook.item;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import snw.jkook.entity.User;


/**
 * 表示一个事件，该事件意味着某个物品被某人消耗，并且它影响了其他人。
 */
public class KookItemConsumedEvent extends KookItemEvent {

    private final User consumer;
    private final User affected;
    private final int itemId;

    public KookItemConsumedEvent(long timestamp, User consumer, User affected, int itemId) {
        super(timestamp);
        this.consumer = consumer;
        this.affected = affected;
        this.itemId = itemId;
    }

    public User getConsumer() {
        return consumer;
    }

    public User getWhoBeAffected() {
        return affected;
    }

    public int getItemId() {
        return itemId;
    }

    private static final HandlerList handlerList = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
