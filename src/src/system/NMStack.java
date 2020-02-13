package system;

public class NMStack {
    private int line;
    private void nextLine() {
        line++;
    }
    public int getSystemLine() {
        return line;
    }
    public int writeLine() {
        return line++;
    }
}
