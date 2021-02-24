package memory.flash.ref;

import runnable.Main;
import system.security.Token;
import system.type.NMType;

// Decorator bzw Components Pattern
public abstract class Reference implements Resolvable {
    private final String refIdentifier;
    public final int link;

    protected Reference(String refIdentifier, int link) {
        this.refIdentifier = refIdentifier;
        this.link = link;
    }
    public String getIdentifier(){
        return refIdentifier;
    }
   // NMType getDataFroLink(Token t) {
    //    return Main.getActiveProcess(t).getDataFrom(this, link);
    //}
}
