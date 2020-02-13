package system;

import output.Console;

import java.util.Stack;

public class Process {

    enum ProcessKind{
        DEFAULT, GIVEABLE;
    }

    private ProcessKind kind = ProcessKind.DEFAULT;
    private final String processMessage = "Running";
    private final static Process innerProcess = new Process(Token.getInnerToken());
    private final Stack<Token> tokenHolder = new Stack<>();

    private Process(Token token){
        tokenHolder.push(token);
    }

    public void writeInfo(){
        Console.INFO.writeConsoleLine("Test");
    }

    public boolean run(){
       /* while(token.isValid()){

        } */
        return false;
    }
    public Process createProcess(){
        return new Process(giveToken());
    }

    private Token giveToken() {
        return tokenHolder.pop();
    }

    public static Process getInnerProcess(){
        return innerProcess;
    }
}
