package com.eternalcode.discordspyaddon;

import com.eternalcode.discordspyaddon.config.ConfigService;
import com.eternalcode.core.feature.reload.EternalCoreReloadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DiscordSpyReloadController implements Listener {

    private final ConfigService configService;

    public DiscordSpyReloadController(ConfigService configService) {
        this.configService = configService;
    }

    @EventHandler
    public void onReload(EternalCoreReloadEvent event) {
        this.configService.reload();
    }
}
