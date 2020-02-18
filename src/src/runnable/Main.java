package runnable;

import system.NMSystem;
import system.Process;
import system.security.Certificate;
import system.security.Token;

public class Main {

    private static final Process init = Process.getInnerProcess();
    private static Process running;

    public static void main(String[] args) {
        running = init.createProcess();
        running.writeInfo();
        while (NMSystem.isRunning()) {
            running.run();
            running = running.createProcess();
        }
    }

    public static Process getActiveProcess(Token t){
        Certificate.certificate(t, "Kein Zugriff auf Process");
        return running;
    }
}
