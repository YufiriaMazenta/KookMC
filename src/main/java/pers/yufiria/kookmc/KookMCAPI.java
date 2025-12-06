package pers.yufiria.kookmc;

import pers.yufiria.kookmc.internal.KookRegisterableCache;
import snw.jkook.command.JKookCommand;
import snw.jkook.event.Listener;
import snw.kookbc.impl.KBCClient;

import java.util.Optional;

public class KookMCAPI {

    public static void registerCommand(JKookCommand command) {
        Optional<KBCClient> kookClientOpt = KookMC.getInstance().getKookClient();
        if (!kookClientOpt.isPresent()) {
            KookRegisterableCache.addCommand(command);
            return;
        }
        command.register(kookClientOpt.get().getInternalPlugin());
    }

    public static void registerEvents(Listener listener) {
        Optional<KBCClient> kookClientOpt = KookMC.getInstance().getKookClient();
        if (!kookClientOpt.isPresent()) {
            KookRegisterableCache.addListener(listener);
            return;
        }
        KBCClient kbcClient = kookClientOpt.get();
        kbcClient.getCore().getEventManager().registerHandlers(kbcClient.getInternalPlugin(), listener);
    }

}
