package pers.yufiria.kookmc;

import snw.jkook.command.JKookCommand;
import snw.jkook.event.Listener;
import snw.kookbc.impl.KBCClient;

import java.util.Optional;

public class KookMCAPI {

    public static boolean registerCommand(JKookCommand command) {
        Optional<KBCClient> kookClientOpt = KookMC.getInstance().getKookClient();
        if (!kookClientOpt.isPresent()) {
            return false;
        }
        command.register(kookClientOpt.get().getInternalPlugin());
        return true;
    }


    public boolean registerEvents(Listener listener) {
        Optional<KBCClient> kookClientOpt = KookMC.getInstance().getKookClient();
        if (!kookClientOpt.isPresent()) {
            return false;
        }
        KBCClient kbcClient = kookClientOpt.get();
        kbcClient.getCore().getEventManager().registerHandlers(kbcClient.getInternalPlugin(), listener);
        return true;
    }

}
