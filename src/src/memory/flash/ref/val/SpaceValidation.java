package memory.flash.ref.val;

public class SpaceValidation extends ReferenceCondition {
    @Override
    public boolean check(String potentialName) {
        System.out.println(potentialName);
        return !potentialName.contains(" ");
    }
}
