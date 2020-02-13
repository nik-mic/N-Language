package output;

import system.Certificate;
import system.NMStack;
import system.Token;

public enum Console {
    ERROR,
    INFO,
    INPUT,
    OUTPUT;

    private final NMStack RUNNING_SYSTEM;

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
