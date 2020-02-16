package runnable;

import system.Process;

public class Main {

    private static final Process init = Process.getInnerProcess();

    public static void main(String[] args) {
       /* Process running = init.createProcess();
        running.writeInfo();
        while (NMSystem.isRunning()) {
            running.run();
            running = running.createProcess();
        } */
    }
}
