package output;

import system.NMStack;

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

    public void writeConsoleLine(String s) {
        write(RUNNING_SYSTEM.writeLine() + " : " + s);
    }
}
