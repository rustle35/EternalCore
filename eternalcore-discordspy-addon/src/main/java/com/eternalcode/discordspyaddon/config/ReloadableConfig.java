package com.eternalcode.discordspyaddon.config;

import java.io.File;
import net.dzikoysk.cdn.source.Resource;

public interface ReloadableConfig {

    Resource resource(File folder);
}
