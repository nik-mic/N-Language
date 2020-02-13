package input;

import output.Console;
import system.Token;

import java.util.Scanner;

public class NMListener {
    private String currentLine;
    private Scanner in;

    public NMListener(){
        in = new Scanner(System.in);
    }

    public void listen(Token t){
        Console.INPUT.tease(t);
        in.nextLine();
    }
}
