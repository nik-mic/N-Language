package output;

import system.security.Certificate;
import system.NMStack;
import system.security.Token;

public enum Console {
    ERROR,
    INFO,
    INPUT,
    OUTPUT;

    private final NMStack RUNNING_SYSTEM;

    public int getLine(){
        return RUNNING_SYSTEM.getSystemLine()-1;
    }

    Console() {
        this.RUNNING_SYSTEM = new NMStack();
    }

    private void write(String s) {
        System.out.println(s);
    }
    private void tease(){
        System.out.print(RUNNING_SYSTEM.writeLine() + ": ");
    }

    public void writeConsoleLine(String s, Token t) {
        Certificate.certificate(t, toString());
        write(RUNNING_SYSTEM.writeLine() + ": " + s);
    }

    public void tease(Token t){
        Certificate.certificate(t, toString());
        tease();
    }
}
