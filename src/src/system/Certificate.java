package system;

public class Certificate {
    public static boolean certificate(Token t, String context){
        if(t.isValid()){
            return true;
        } else{
            throw new ArithmeticException("Keine Berichtigungen für Aktionen in " + context);
        }
    }
}
