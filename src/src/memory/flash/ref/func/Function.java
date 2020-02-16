package memory.flash.ref.func;

import language.Callable;
import memory.flash.ref.Reference;
import system.type.NMType;

public class Function extends Reference implements Callable {
    protected Function(String refIdentifier) {
        super(refIdentifier);
    }

    @Override
    public void methodCall() {

    }

    @Override
    public NMType resolve() {
        return null;
    }
}
