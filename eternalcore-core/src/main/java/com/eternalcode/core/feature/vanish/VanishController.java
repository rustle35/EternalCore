package com.eternalcode.core.feature.vanish;

import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Controller;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

@Controller
public class VanishController implements Listener {
    private final VanishService vanishService;

    private final Plugin plugin;

    @Inject
    public VanishController(VanishService vanishService, Plugin plugin) {
        this.vanishService = vanishService;
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        for (int i = 0; i < this.vanishService.invisibleList.size(); i++) {
            player.hidePlayer(this.plugin, this.vanishService.invisibleList.get(i));
        }
    }

}
