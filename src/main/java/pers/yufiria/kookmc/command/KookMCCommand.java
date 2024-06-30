package pers.yufiria.kookmc.command;

import crypticlib.chat.MsgSender;
import crypticlib.command.CommandHandler;
import crypticlib.command.CommandInfo;
import crypticlib.command.SubcommandHandler;
import crypticlib.command.annotation.Command;
import crypticlib.command.annotation.Subcommand;
import crypticlib.perm.PermInfo;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import pers.yufiria.kookmc.KookMC;
import pers.yufiria.kookmc.config.Messages;

import java.util.List;

@Command
public class KookMCCommand extends CommandHandler {

    public static final KookMCCommand INSTANCE = new KookMCCommand();

    KookMCCommand() {
        super(new CommandInfo("kookmc", new PermInfo("kookmc.command")));
    }

    @Subcommand
    SubcommandHandler reload = new SubcommandHandler("reload", new PermInfo("kookmc.command.reload")) {
        @Override
        public boolean execute(@NotNull CommandSender sender, @NotNull List<String> args) {
            KookMC.getInstance().reloadConfig();
            MsgSender.sendMsg(sender, Messages.commandReload.value());
            return super.execute(sender, args);
        }
    };

}
