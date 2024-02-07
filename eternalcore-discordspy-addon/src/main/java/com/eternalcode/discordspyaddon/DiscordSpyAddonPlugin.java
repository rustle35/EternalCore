package com.eternalcode.discordspyaddon;

import com.eternalcode.core.EternalCoreApi;
import com.eternalcode.core.EternalCoreApiProvider;
import com.eternalcode.discordspyaddon.spy.helpop.HelpOpDiscordService;
import org.bukkit.plugin.java.JavaPlugin;

public class DiscordSpyAddonPlugin extends JavaPlugin {

    private HelpOpDiscordService helpOpDiscordService;

    @Override
    public void onEnable() {
        EternalCoreApi provide = EternalCoreApiProvider.provide();


    }

    @Override
    public void onDisable() {
        if (this.helpOpDiscordService != null) {
            this.helpOpDiscordService.closeWebhookClient();
        }
    }
}
