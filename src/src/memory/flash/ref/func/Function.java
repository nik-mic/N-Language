package memory.flash.ref.func;

import language.Callable;
import memory.flash.ref.Reference;
import system.security.Token;
import system.type.NMType;

public class Function extends Reference implements Callable {
    private final NMType<String> methodCode;
    protected Function(String refIdentifier, String methodCode) {
        super(refIdentifier);
        this.methodCode = new NMType<String>(methodCode);
    }

    @Override
    public NMType methodCall(String line) {
        return null;
    }

    @Override
    public NMType resolve(Token t) {
        return methodCode;
    }
}
