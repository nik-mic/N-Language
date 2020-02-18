package input.val;

public class EmptyValidation extends CompilableLineCondition {
    @Override
    public boolean check(String s) {
        return !(s.isEmpty() || s.isBlank());
    }
}
