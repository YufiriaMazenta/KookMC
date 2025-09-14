package pers.yufiria.kookmc.config;

import crypticlib.config.ConfigHandler;
import crypticlib.config.node.impl.bukkit.StringConfig;

@ConfigHandler(path = "lang.yml")
public class Messages {

    public static final StringConfig botLoading = new StringConfig("bot.loading", "&8[&3Kook&bMC&8]&7 机器人开始加载");
    public static final StringConfig botStarted = new StringConfig("bot.started", "&8[&3Kook&bMC&8]&7 机器人加载完毕");

    public static final StringConfig commandReload = new StringConfig("command.reload", "&8[&3Kook&bMC&8]&7 &a重载成功");

}
