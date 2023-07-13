package com.github.yufiriamazenta.kookmc.cmd;

import com.github.yufiriamazenta.kookmc.KookMC;
import com.github.yufiriamazenta.kookmc.cmd.sub.ReloadSubCommand;
import com.github.yufiriamazenta.lib.command.IPluginCommand;
import com.github.yufiriamazenta.lib.command.ISubCommand;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum KookMCCommand implements IPluginCommand {

    INSTANCE;

    private final Map<String, ISubCommand> subCommandMap;

    KookMCCommand() {
        subCommandMap = new HashMap<>();
        regSubCommand(ReloadSubCommand.INSTANCE);
    }

    @Override
    public Plugin getPlugin() {
        return KookMC.getInstance();
    }

    @Override
    public @NotNull Map<String, ISubCommand> getSubCommands() {
        return subCommandMap;
    }

}
