package com.eternalcode.core.feature.vanish;

import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Service;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

@Service
public class VanishService {

    private static final String METADATA_VANISHED_KEY = "vanished";
    private final Server server;

    private final Plugin plugin;

    public ArrayList<Player> invisibleList = new ArrayList<>();

    @Inject
    public VanishService(Server server, Plugin plugin) {
        this.server = server;
        this.plugin = plugin;
    }

    public boolean isVanished(UUID playerUniqueId) {
        Player player = this.server.getPlayer(playerUniqueId);
        if (player == null) {
            return false;
        }
        return this.isVanished(player);
    }

    public boolean isVanished(Player player) {
        for (MetadataValue isVanished : player.getMetadata(METADATA_VANISHED_KEY)) {
            if (isVanished.asBoolean()) {
                return true;
            }
        }
        return false;
    }

    public boolean playerIsVanished(Player player) {
        if (this.invisibleList.contains(player)) {
            this.invisibleList.remove(player);
            return true;
        }
        else {
            this.invisibleList.add(player);
            return false;
        }
    }

    public void vanish(Player player) {
        for (Player people : Bukkit.getOnlinePlayers()) {
            people.hidePlayer(this.plugin, player);
        }
    }

    public void removeVanish(Player player) {
        for (Player people : Bukkit.getOnlinePlayers()) {
            people.showPlayer(this.plugin, player);
        }
    }

}
