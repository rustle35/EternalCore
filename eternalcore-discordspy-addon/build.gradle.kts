plugins {
    `eternalcode-java`
    `eternalcore-repositories`

    id("com.github.johnrengelman.shadow")
    id("net.minecrell.plugin-yml.bukkit")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:${Versions.SPIGOT_API}")
    api("org.jetbrains:annotations:${Versions.JETBRAINS_ANNOTATIONS}")

    implementation("net.dzikoysk:cdn:${Versions.CDN_CONFIGS}")

    // webhook
    implementation("club.minnced:discord-webhooks:0.8.4")

    compileOnly(project(":eternalcore-api"))
}

bukkit {
    main = "com.eternalcode.discordspyaddon.DiscordSpyAddonPlugin"
    apiVersion = "1.13"
    prefix = "EternalCore-DiscordSpyAddon"
    author = "EternalCodeTeam"
    name = "EternalCore-DiscordSpyAddon"
    description = "DiscordSpyAddon for EternalCore!"
    website = "www.eternalcode.pl"
    version = "${project.version}"
    depend = listOf("EternalCore")
}

tasks.shadowJar {
    archiveFileName.set("EternalCore-DiscordSpyAddon v${project.version}.jar")

    listOf(
        "net.dzikoysk",
    ).forEach {
        relocate(it, "com.eternalcode.discordspyaddon.$it")
    }
}
