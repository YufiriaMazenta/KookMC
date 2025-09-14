package pers.yufiria.kookmc.command;

import crypticlib.command.CommandInfo;
import crypticlib.command.CommandInvoker;
import crypticlib.command.CommandNode;
import crypticlib.command.CommandTree;
import crypticlib.command.annotation.Command;
import crypticlib.command.annotation.Subcommand;
import crypticlib.perm.PermInfo;
import org.jetbrains.annotations.NotNull;
import pers.yufiria.kookmc.KookMC;
import pers.yufiria.kookmc.config.Messages;

import java.util.List;

@Command
public class KookMCCommand extends CommandTree {

    public static final KookMCCommand INSTANCE = new KookMCCommand();

    KookMCCommand() {
        super(new CommandInfo("kookmc", new PermInfo("kookmc.command")));
    }

    @Subcommand
    CommandNode reload = new CommandNode("reload", new PermInfo("kookmc.command.reload")) {

        @Override
        public void execute(@NotNull CommandInvoker invoker, @NotNull List<String> args) {
            KookMC.getInstance().reloadPlugin();
            invoker.sendMsg(Messages.commandReload.value());
        }

    };

}
