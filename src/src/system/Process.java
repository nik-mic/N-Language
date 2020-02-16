package system;

import input.Line;
import input.NMListener;
import memory.flash.ref.ReferencesMemory;
import output.story.OutputMemory;
import output.Console;
import system.security.Token;

import java.util.Stack;

public class Process {

    enum ProcessKind{
        DEFAULT, GIVEABLE;
    }

    private final OutputMemory output;
    private final ReferencesMemory refs;
    private ProcessKind kind = ProcessKind.DEFAULT;
    private final static Process innerProcess = new Process(Token.getInnerToken());
    private final Stack<Token> tokenHolder = new Stack<>();
    private final NMListener in;

    private Process(Token token){
        tokenHolder.push(token);
        output = new OutputMemory();
        refs = new ReferencesMemory();
        in = new NMListener();
    }

    public void writeInfo(){
        Console.INFO.writeConsoleLine("INFO", showToken());
    }

    public boolean run(){
        Line line;
        while(showToken().isValid()){
            line = in.listen(showToken());
            System.out.println(line.toString());
        }
        writeOutput();
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
    private Token showToken(){
        return tokenHolder.peek();
    }

    private void writeOutput(){
        output.getOutputList(showToken())
                .forEach(s ->Console.OUTPUT.writeConsoleLine(s, showToken()));
    }
    private Line createLine(String content){
        return Line.getSystemLine().createLine(content, showToken());
    }
}
