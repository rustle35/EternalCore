package com.eternalcode.core.feature.jail;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.Map;
import java.util.UUID;

public interface JailService {

    /**
     * Changes location of the jail.
     *
     * @param jailLocation The location of the jail.
     * @param setter Player who sets the jail location.
     */
    void setupJailArea(Location jailLocation, Player setter);

    void removeJailArea(Player remover);

    void detainPlayer(Player player, @Nullable String reason, Player detainedBy, @Nullable Duration duration);

    void releasePlayer(Player player, Player releasedBy);

    void releaseAllPlayers(Player player);

    boolean isLocationSet();

    Location getJailLocation();

    Map<UUID, Prisoner> getJailedPlayers();

}
