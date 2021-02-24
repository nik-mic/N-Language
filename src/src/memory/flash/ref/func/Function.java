package memory.flash.ref.func;

import language.Callable;
import memory.flash.ref.Reference;
import runnable.Main;
import system.security.Token;
import system.type.NMType;

public class Function extends Reference implements Callable {
    protected Function(String refIdentifier, int link) {
        super(refIdentifier, link);
    }

    @Override
    public NMType methodCall(String line) {
        return null;
    }

    @Override
    public NMType resolve(Token t) {
        return Main.getActiveProcess(t).getDataFrom(link);
    }
}
