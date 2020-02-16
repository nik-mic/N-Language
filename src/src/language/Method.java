package language;

import system.type.NMType;

public abstract class Method implements Callable {
    private final Topic OWNER;
    private NMType returnValue;
    public Method(Topic owner){
        this.OWNER = owner;
    }
}

