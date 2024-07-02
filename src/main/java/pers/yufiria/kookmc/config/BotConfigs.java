package pers.yufiria.kookmc.config;

import crypticlib.config.ConfigHandler;
import crypticlib.config.entry.StringConfig;

@ConfigHandler(path = "bot-config.yml")
public class BotConfigs {

    public static final StringConfig token = new StringConfig("kook-bot.token", "");

}
