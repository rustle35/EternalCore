package com.eternalcode.core.feature.vanish;

import com.eternalcode.annotations.scan.command.DescriptionDocs;
import com.eternalcode.annotations.scan.feature.FeatureDocs;
import com.eternalcode.core.injector.annotations.Inject;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command(name = "vanish")
@Permission("eternalcore.vanish")
@FeatureDocs(
    name = "Vanish",
    permission = { "eternalcore.vanish" },
    description = "It allows you to hide from other players"
)
class VanishCommand {

    private final VanishService vanishService;

    @Inject
    VanishCommand(VanishService vanishService) {
        this.vanishService = vanishService;
    }

    @Execute
    @DescriptionDocs(description = "Hide or show the player based on previous state")
    void execute(@Context Player player, @Context CommandSender commandSender) {
        if (commandSender instanceof Player) {
            if (!this.vanishService.playerIsVanished(player)) {
                this.vanishService.vanish(player);
                commandSender.sendMessage("You are now hidden to other players on the server.");
            }
            else {
                this.vanishService.removeVanish(player);
                commandSender.sendMessage("You are now visible to other players on the server.");
            }
        }
    }
}
