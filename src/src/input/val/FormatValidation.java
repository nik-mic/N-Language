package input.val;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FormatValidation extends CompilableLineCondition {
    // TODO collect pattern
    List<String> formatPattern = Arrays.asList("", "", "");

    // TODO Verbessern
    @Override
    public boolean check(String s) {
        boolean matchesOne = true;
        for(String a : formatPattern){
            if(s.matches(a)) {
                matchesOne = true;
                break;
            }
        } return matchesOne;
    }
}
