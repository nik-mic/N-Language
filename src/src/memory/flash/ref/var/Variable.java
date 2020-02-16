package memory.flash.ref.var;

import memory.flash.ref.Reference;
import system.type.NMType;

public class Variable extends Reference {

    protected Variable(String refIdentifier) {
        super(refIdentifier);
    }

    @Override
    public NMType resolve() {
        return null;
    }
}
