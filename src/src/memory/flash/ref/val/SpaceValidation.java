package memory.flash.ref.val;

public class SpaceValidation extends ReferenceCondition {
    @Override
    public boolean check(String potentialName) {
        return !potentialName.contains(" ");
    }
}
