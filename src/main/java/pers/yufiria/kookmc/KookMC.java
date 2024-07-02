package pers.yufiria.kookmc;

import crypticlib.BukkitPlugin;
import crypticlib.chat.MsgSender;
import pers.yufiria.kookmc.config.BotConfigs;
import pers.yufiria.kookmc.config.Messages;
import pers.yufiria.kookmc.event.KookEventForwarder;
import snw.jkook.JKook;
import snw.jkook.command.JKookCommand;
import snw.jkook.config.ConfigurationSection;
import snw.jkook.config.file.YamlConfiguration;
import snw.jkook.entity.Guild;
import snw.jkook.entity.channel.Channel;
import snw.jkook.message.ChannelMessage;
import snw.jkook.message.component.MarkdownComponent;
import snw.kookbc.impl.CoreImpl;
import snw.kookbc.impl.KBCClient;
import snw.kookbc.impl.command.CommandManagerImpl;

import java.io.File;
import java.text.SimpleDateFormat;

public final class KookMC extends BukkitPlugin {

    private static KookMC INSTANCE;
    private KBCClient kbcClient;

    @Override
    public void enable() {
        INSTANCE = this;
        initKookBC();
    }

    @Override
    public void disable() {
        disableKookBC();
    }

    private void initKookBC() {
        CoreImpl core = new CoreImpl();
        JKook.setCore(core);
        ConfigurationSection botConfig = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "bot-config.yml"));
        try {
            MsgSender.info(Messages.botLoading.value());
            kbcClient = new KBCClient(core, botConfig, getDataFolder(), BotConfigs.token.value());
            kbcClient.start();
            kbcClient.getCore().getEventManager().registerHandlers(kbcClient.getInternalPlugin(), KookEventForwarder.INSTANCE);
            ((CommandManagerImpl) kbcClient.getInternalPlugin().getCore().getCommandManager()).getCommandMap().unregisterAll(kbcClient.getInternalPlugin());
            MsgSender.info(Messages.botStarted.value());
            regDefCommand();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void regDefCommand() {
        regKookCommand(new JKookCommand("debug", "/").executesUser(
                (sender, arguments, message) -> {
                    if (message != null) {
                        StringBuilder contentBuilder = new StringBuilder();
                        String messageId = message.getId();
                        long timestamp = message.getTimeStamp();
                        contentBuilder.append("消息 ID: ").append(messageId).append("\n");
                        contentBuilder.append("消息发送时的时间: ").append(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(timestamp));

                        if (message instanceof ChannelMessage) { // if this command was executed in a channel
                            contentBuilder.append("\n"); // ignore this please, just for better look

                            Channel channel = ((ChannelMessage) message).getChannel();
                            Guild guild = channel.getGuild();
                            String guildName = guild.getName();
                            String guildId = guild.getId();
                            String channelName = channel.getName();
                            String channelId = channel.getId();
                            contentBuilder.append("此消息发送的用户: ").append(sender.getName()).append("\n");
                            contentBuilder.append("此消息所在的服务器的名称: ").append(guildName).append("\n");
                            contentBuilder.append("此消息所在的服务器的 ID: ").append(guildId).append("\n");
                            contentBuilder.append("此消息所在的频道的名称: ").append(channelName).append("\n");
                            contentBuilder.append("此消息所在的频道的ID: ").append(channelId);
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

}
