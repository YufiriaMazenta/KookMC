package com.github.yufiriamazenta.kookmc.cmd.sub;

import com.github.yufiriamazenta.kookmc.KookMC;
import com.github.yufiriamazenta.lib.command.ISubCommand;
import com.github.yufiriamazenta.lib.util.MsgUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ReloadSubCommand implements ISubCommand {

    INSTANCE;

    private final Map<String, ISubCommand> subCommandMap;

    ReloadSubCommand() {
        subCommandMap = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        YamlConfiguration langConfig = KookMC.getInstance().getLangConfig().getConfig();
        if (!sender.hasPermission(getPerm())) {
            MsgUtil.sendLang(sender, langConfig, "cmd.no_perm", Map.of("%prefix%", KookMC.getInstance().getLangPrefix()));
            return true;
        }
        reloadConfig();
        MsgUtil.sendLang(sender, langConfig, "cmd.reload", Map.of("%prefix%", KookMC.getInstance().getLangPrefix()));
        return true;
    }

    @Override
    public String getSubCommandName() {
        return "reload";
    }

    @Override
    public String getPerm() {
        return "kookmc.cmd.reload";
    }

    @Override
    public void setPerm(String perm) {}

    @Override
    public @NotNull Map<String, ISubCommand> getSubCommands() {
        return subCommandMap;
    }

    private void reloadConfig() {
        KookMC.getInstance().reloadConfig();
        KookMC.getInstance().getLangConfig().reloadConfig();
    }

}
