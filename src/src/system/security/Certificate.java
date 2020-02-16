package system.security;

import input.val.CompilableLineCondition;
import input.val.FormatValidation;
import memory.flash.ref.val.KeywordValidation;
import memory.flash.ref.val.ReferenceCondition;
import memory.flash.ref.val.SpaceValidation;
import memory.flash.ref.val.SpecialCharacterValidation;
import output.Console;

import java.util.Arrays;
import java.util.List;

public class Certificate {

    private static List<CompilableLineCondition> lineConditions = Arrays.asList(new FormatValidation());
    private static List<ReferenceCondition> refConditions = Arrays.asList(new SpaceValidation(), new SpecialCharacterValidation(), new KeywordValidation());

    public static boolean certificate(Token t, String context){
        if(t.isValid()){
            return true;
        } Console.ERROR.writeConsoleLine("Keine Berichtigungen für Aktionen in " + context, t);
        throw new ArithmeticException("Keine Berichtigungen für Aktionen in " + context);
    }

    public static boolean isValidName(String name){
        for(ReferenceCondition currentCondition : refConditions) {
            if (!currentCondition.check(name)) {
                throw new ArithmeticException("Keine Gültiger Variablen Name");
            }
        }
        return true;
    }
    public static boolean isValidLine(String input, Token t){
        for(CompilableLineCondition currentCondition : lineConditions) {
            if (!currentCondition.check(input)) {
                Console.ERROR.writeConsoleLine("Keine gültige Eingabe", t);
                return false;
            }
        }
        return true;
    }


}
