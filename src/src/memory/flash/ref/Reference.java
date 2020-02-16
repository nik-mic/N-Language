package memory.flash.ref;

// Decorator bzw Components Pattern
public abstract class Reference implements Resolvable {
    private final String refIdentifier;

    protected Reference(String refIdentifier) {
        this.refIdentifier = refIdentifier;
    }
    public String getIdentifier(){
        return refIdentifier;
    }
}
