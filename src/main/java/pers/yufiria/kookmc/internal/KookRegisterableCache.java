package pers.yufiria.kookmc.internal;

import pers.yufiria.kookmc.KookMCAPI;
import snw.jkook.command.JKookCommand;
import snw.jkook.event.Listener;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 可注册Kook实体的缓存
 * 目前用于缓存因KookBC未启动导致注册失败的命令、监听器
 */
public final class KookRegisterableCache {

    private static final List<JKookCommand> cacheCommands = new CopyOnWriteArrayList<>();
    private static final List<Listener> cacheListeners = new CopyOnWriteArrayList<>();

    public static void addCommand(JKookCommand command) {
        cacheCommands.add(command);
    }

    public static void addListener(Listener listener) {
        cacheListeners.add(listener);
    }

    public static void register() {
        List<JKookCommand> jKookCommands = Collections.unmodifiableList(cacheCommands);
        cacheCommands.clear();
        for (JKookCommand jKookCommand : jKookCommands) {
            KookMCAPI.registerCommand(jKookCommand);
        }

        List<Listener> listeners = Collections.unmodifiableList(cacheListeners);
        cacheListeners.clear();
        for (Listener listener : listeners) {
            KookMCAPI.registerEvents(listener);
        }
    }

}
