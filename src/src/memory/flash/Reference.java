package memory.flash;

// Decorator bzw Components Pattern
public abstract class Reference implements Resolvable {
    private final String refIdentifier;
    private final Reference target;

    protected Reference(String refIdentifier, Reference target) {
        this.refIdentifier = refIdentifier;
        this.target = target;
    }
    public String getIdentifier(){
        return refIdentifier;
    }
}
