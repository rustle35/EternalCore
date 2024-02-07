package com.eternalcode.discordspyaddon.spy.helpop.config;

import net.dzikoysk.cdn.entity.Contextual;
import net.dzikoysk.cdn.entity.Description;

public class HelpOpConfig {

    @Description({
        " ",
        "# If true, the message will be sent to the Discord channel",
        "# If false, the message will not be sent to the Discord channel"
    })
    public boolean announceHelpOpOnDiscord = true;
    @Description({
        " ",
        "# If true, the message will be sent as an embed",
        "# If false, the message will be sent as a single message"
    })
    public boolean useEmbed = true;
    public final String helpOpWebhookUrl = "YOUR_WEBHOOK_URL";

    public final HelpOpEmbedConfig embedConfig = new HelpOpEmbedConfig();
    public final HelpOpSingleMessageConfig singleMessageConfig = new HelpOpSingleMessageConfig();

    @Contextual
    public static class HelpOpEmbedConfig {
        public final String description = "**HelpOp** - {player} - {content}";
        public final String title = "HelpOp";
        public final String color = "#ffffff";
        public final String footer = "EternalCore";
        public final String footerIcon = "";
        public final String thumbnail = "";
        public final String author = "EternalCore - HelpOp";
        public final String authorIcon = "";
    }

    @Contextual
    public static class HelpOpSingleMessageConfig {
        public final String message = "**HelpOp** - {player} - {content}";
    }
}
