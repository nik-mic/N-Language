package input;

import output.Console;
import system.security.Certificate;
import system.security.Token;
import java.util.Scanner;

public class NMListener {
    private Scanner in;
    // private static final Line ERRORLINE;
    public NMListener(){
        in = new Scanner(System.in);
    }

    public Line listen(Token t){
        Console.INPUT.tease(t);
        return makeLine(tryToMakeLine(in.nextLine(), t), t);
    }

    private Line makeLine(String input, Token t){
        return Line.getSystemLine().createLine(input, t);
    }
    private String tryToMakeLine(String input, Token t){
        return (Certificate.isValidLine(input, t)) ? input : "&Math count 10 :: lol";
    }
}
