package com.github.yufiriamazenta.kookmc;

import com.github.yufiriamazenta.kookmc.cmd.KookMCCommand;
import com.github.yufiriamazenta.kookmc.event.KookEventForwarder;
import com.github.yufiriamazenta.lib.config.impl.YamlConfigWrapper;
import com.github.yufiriamazenta.lib.util.MsgUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import snw.jkook.JKook;
import snw.jkook.command.JKookCommand;
import snw.jkook.config.ConfigurationSection;
import snw.jkook.config.file.YamlConfiguration;
import snw.jkook.entity.Guild;
import snw.jkook.entity.channel.TextChannel;
import snw.jkook.message.TextChannelMessage;
import snw.jkook.message.component.MarkdownComponent;
import snw.kookbc.impl.CoreImpl;
import snw.kookbc.impl.KBCClient;

import java.io.File;

public final class KookMC extends JavaPlugin {

    private static KookMC INSTANCE;
    private KBCClient kbcClient;
    private YamlConfigWrapper langConfig;

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        langConfig = new YamlConfigWrapper(this, "lang.yml");
        initKookBC();
        Bukkit.getPluginCommand("kookmc").setExecutor(KookMCCommand.INSTANCE);
        Bukkit.getPluginCommand("kookmc").setTabCompleter(KookMCCommand.INSTANCE);
    }

    @Override
    public void onDisable() {
        disableKookBC();
    }

    private void initKookBC() {
        CoreImpl core = new CoreImpl();
        JKook.setCore(core);
        ConfigurationSection botConfig = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "config.yml")).getConfigurationSection("kook-bot");
        try {
            MsgUtil.info("[KookMC] Kook bot starting");
            kbcClient = new KBCClient(core, botConfig, getDataFolder(), getConfig().getString("kook-bot.token"));
            kbcClient.start();
        } catch (NullPointerException ignored) {}
        kbcClient.getCore().getEventManager().registerHandlers(kbcClient.getInternalPlugin(), KookEventForwarder.INSTANCE);
        MsgUtil.info("[KookMC] Kook bot started");
        regDefCommand();
    }

    private void regDefCommand() {
        regKookCommand(new JKookCommand("debug", "/").executesUser(
                (sender, arguments, message) -> {
                    if (message != null) {
                        StringBuilder contentBuilder = new StringBuilder();
                        String messageId = message.getId();
                        long timestamp = message.getTimeStamp();
                        contentBuilder.append("消息 ID: ").append(messageId).append("\n");
                        contentBuilder.append("消息发送时的时间戳: ").append(timestamp);

                        if (message instanceof TextChannelMessage) { // if this command was executed in a channel
                            contentBuilder.append("\n"); // ignore this please, just for better look

                            TextChannel channel = ((TextChannelMessage) message).getChannel();
                            Guild guild = channel.getGuild();
                            String guildName = guild.getName();
                            String guildId = guild.getId();
                            String channelName = channel.getName();
                            String channelId = channel.getId();
                            contentBuilder.append("此消息所在的服务器的名称: ").append(guildName).append("\n");
                            contentBuilder.append("此消息所在的服务器的 ID: ").append(guildId).append("\n");
                            contentBuilder.append("此消息所在的频道的名称: ").append(channelName).append("\n");
                            contentBuilder.append("此消息所在的频道的 ID: ").append(channelId);
                        }
                        message.reply(new MarkdownComponent(contentBuilder.toString()));
                    }
                }
        ));
    }

    private void disableKookBC() {
        kbcClient.shutdown();
    }

    public static KookMC getInstance() {
        return INSTANCE;
    }

    public KBCClient getKookClient() {
        return kbcClient;
    }

    public void regKookCommand(JKookCommand command) {
        command.register(kbcClient.getInternalPlugin());
    }

    public YamlConfigWrapper getLangConfig() {
        return langConfig;
    }

    public String getLangPrefix() {
        return langConfig.getConfig().getString("prefix", "&8[&3Kook&bMC&8]&7");
    }

}
