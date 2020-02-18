package system;

import input.Line;
import input.NMListener;
import memory.flash.ref.ReferencesMemory;
import memory.flash.ref.var.Variable;
import memory.flash.ref.var.VariableFactory;
import memory.storage.Data;
import output.story.OutputMemory;
import output.Console;
import system.core.CoCompiler;
import system.security.Certificate;
import system.security.Token;
import system.type.NMType;

import java.util.Stack;

public class Process {

    private final Data varStorage;
    private final OutputMemory output;
    private final ReferencesMemory refs;
    private final static Process innerProcess = new Process(Token.getInnerToken());
    private final Stack<Token> tokenHolder = new Stack<>();
    private final NMListener in;

    private Process(Token token) {
        tokenHolder.push(token);
        output = new OutputMemory();
        refs = new ReferencesMemory();
        in = new NMListener();
        varStorage = Data.preData.createData(showToken());
    }

    public void writeInfo() {
        Console.INFO.writeConsoleLine("INFO\n", showToken());
        VariableFactory.initNewVariable("Pi", new NMType <String> ("3.14"), showToken());
    }

    public boolean run() {
        Line line;
        while (showToken().isValid()) {
            line = in.listen(showToken());
            System.out.println(CoCompiler.DEREF.compile(line));
        }
        writeOutput();
        return false;
    }

    public Process createProcess() {
        return new Process(giveToken());
    }

    private Token giveToken() {
        return tokenHolder.pop();
    }
    public static Process getInnerProcess() {
        return innerProcess;
    }

    private Token showToken() {
        return tokenHolder.peek();
    }

    private void writeOutput() {
        output.getOutputList(showToken())
                .forEach(s -> Console.OUTPUT.writeConsoleLine(s, showToken()));
    }

    public NMType getDataFrom(int index) {
        Certificate.certificate(showToken(), toString());
        return varStorage.get(index, showToken());
    }
    public Data getVarStorage(Token t){
        Certificate.certificate(t, toString());
        return varStorage;
    }

    public NMType getRef(String s){
        return refs.get(s, showToken());
    }

    public void insertRef(Variable var, Token t) {
        Certificate.certificate(t, toString());
        refs.insert(var, t);
    }
}
