package memory.flash.ref.var;

import memory.flash.ref.Reference;
import runnable.Main;
import system.security.Token;
import system.type.NMType;

public class Variable extends Reference {

    private int link;
    public Variable(String refIdentifier, int link) {
        super(refIdentifier, link);
        this.link=link;
    }

    @Override
    public NMType resolve(Token t) {
        return Main.getActiveProcess(t).getDataFrom(link);
    }

    // Math sum !a -> Math sum 10, 11, 12, 123, 123
    // CoCompiler
}
