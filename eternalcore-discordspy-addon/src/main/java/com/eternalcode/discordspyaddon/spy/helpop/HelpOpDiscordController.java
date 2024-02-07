package com.eternalcode.discordspyaddon.spy.helpop;

import com.eternalcode.core.feature.helpop.event.HelpOpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HelpOpDiscordController implements Listener {

    private final HelpOpDiscordService helpOpDiscordService;

    public HelpOpDiscordController(HelpOpDiscordService helpOpDiscordService) {
        this.helpOpDiscordService = helpOpDiscordService;
    }

    @EventHandler(ignoreCancelled = true)
    void onHelpOp(HelpOpEvent event) {
        Player player = event.getPlayer();
        String content = event.getContent();

        this.helpOpDiscordService.sendHelpOpNotification(player, content);
    }

}
