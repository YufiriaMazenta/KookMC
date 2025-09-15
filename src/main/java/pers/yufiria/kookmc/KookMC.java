package pers.yufiria.kookmc;

import crypticlib.BukkitPlugin;
import pers.yufiria.kookmc.event.KookEventForwarder;
import snw.jkook.command.JKookCommand;
import snw.jkook.event.Listener;
import snw.kookbc.impl.KBCClient;

import java.util.Optional;

public final class KookMC extends BukkitPlugin {

    private static KookMC INSTANCE;
    private KbcClientStartRunnable kbcClientStartRunnable;


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
        if (kbcClientStartRunnable != null) {
            kbcClientStartRunnable.cancel();
        }
        kbcClientStartRunnable = new KbcClientStartRunnable();
        kbcClientStartRunnable.async();
    }

    private void disableKookBC() {
        kbcClientStartRunnable.cancel();
    }

    public static KookMC getInstance() {
        return INSTANCE;
    }

    public Optional<KBCClient> getKookClient() {
        if (kbcClientStartRunnable != null) {
            return Optional.ofNullable(kbcClientStartRunnable.getKbcClient());
        }
        return Optional.empty();
    }

}
