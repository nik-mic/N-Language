package input;

import output.Console;
import system.security.Token;
import java.util.Scanner;

public class NMListener {
    private Scanner in;

    public NMListener(){
        in = new Scanner(System.in);
    }

    public Line listen(Token t){
        Console.INPUT.tease(t);
        return makeLine(in.nextLine(), t);
    }

    private Line makeLine(String input, Token t){
        return Line.getSystemLine().createLine(input, t);
    }
}
