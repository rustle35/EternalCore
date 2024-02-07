package com.eternalcode.core.feature.reload;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called when the EternalCore plugin is reloading.
 */
public class EternalCoreReloadEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public EternalCoreReloadEvent() {
        super(false);
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
