package com.eternalcode.discordspyaddon.spy.helpop;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import com.eternalcode.discordspyaddon.spy.helpop.config.HelpOpConfig;
import java.awt.Color;
import java.util.logging.Logger;
import org.bukkit.entity.Player;

public class HelpOpDiscordService {

    private final HelpOpConfig helpOpConfig;
    private final Logger logger;

    private WebhookClient helpopWebhookClient;

    public HelpOpDiscordService(HelpOpConfig helpOpConfig, Logger logger) {
        this.helpOpConfig = helpOpConfig;
        this.logger = logger;
    }

    public void createWebhookClient() {
        if (!this.helpOpConfig.announceHelpOpOnDiscord) {
            return;
        }

        WebhookClientBuilder builder = new WebhookClientBuilder(this.helpOpConfig.helpOpWebhookUrl)
            .setWait(true);

        this.helpopWebhookClient = builder.build();
        this.logger.info("HelpOp Discord Webhook client created");
    }

    public void closeWebhookClient() {
        this.helpopWebhookClient.close();
        this.logger.info("HelpOp Discord Webhook client closed");
    }

    public void sendHelpOpNotification(Player player, String content) {
        if (!this.helpOpConfig.announceHelpOpOnDiscord) {
            return;
        }

        String message = this.helpOpConfig.useEmbed
            ? this.helpOpConfig.embedConfig.description
            : this.helpOpConfig.singleMessageConfig.message;

        message = message.replace("{player}", player.getName());
        message = message.replace("{content}", content);

        if (this.helpOpConfig.useEmbed) {
            this.sendHelpOpNotificationAsEmbed(message);
        }
        else {
            this.sendHelpOpNotificationAsSingleMessage(message);
        }
    }

    private void sendHelpOpNotificationAsEmbed(String message) {
        WebhookEmbed embed = new WebhookEmbedBuilder()
            .setDescription(message)
            .setTitle(new WebhookEmbed.EmbedTitle(this.helpOpConfig.embedConfig.title, null))
            .setColor(Color.decode(this.helpOpConfig.embedConfig.color).getRGB())

            .setFooter(new WebhookEmbed.EmbedFooter(
                this.helpOpConfig.embedConfig.footer,
                this.helpOpConfig.embedConfig.footerIcon))

            .setThumbnailUrl(this.helpOpConfig.embedConfig.thumbnail)

            .setAuthor(new WebhookEmbed.EmbedAuthor(
                this.helpOpConfig.embedConfig.author,
                this.helpOpConfig.embedConfig.authorIcon,
                null))

            .build();

        this.helpopWebhookClient.send(embed);
    }

    private void sendHelpOpNotificationAsSingleMessage(String message) {
        this.helpopWebhookClient.send(message);
    }
}
