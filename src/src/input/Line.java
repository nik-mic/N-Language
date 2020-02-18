package input;

import output.Console;
import system.security.Certificate;
import system.NMSystem;
import system.security.Token;
import system.core.CoCompiler;

import static system.NMSystem.PUSH;

public class Line implements Readable {

    public enum Mode {
        SAVE(NMSystem.SAVE), GIVE(NMSystem.GIVE), PRINT(NMSystem.PRINT);
        private char identifier;
        private CoCompiler targetCoCompiler;

        Mode(char identifier) {
            this.identifier = identifier;
        }

        public char getIdentifier() {
            return identifier;
        }

        void call(Line line) {
            targetCoCompiler.compile(line);
        }
    }

    private String[] lineParts;
    private Mode lineMode = NMSystem.defaultMode;
    private String content;
    private String name;
    private final static Line systemLine = new Line("&Math count 10 :: numb10");


    public final String getContent(){
        return content;
    }
    public static Line getSystemLine() {
        return systemLine;
    }

    private Line(String content) {
        this.content = content;
        extractName();
        identify();
        lineParts = this.content.split(" ");
    }

    private void extractName() {
        String potentialName;
        String[] parts = content.split(PUSH);
        if (parts.length == 2) {
            potentialName = parts[parts.length - 1];
            content = content.replaceAll(PUSH + potentialName, "");
        } else {
            potentialName = "" + Console.INPUT.getLine();
        }
        Certificate.isValidName(potentialName);
        name = potentialName;
    }

    public Line createLine(String content, Token t) {
        Certificate.certificate(t, toString());
        return new Line(content);
    }

    private void identify() {
        for (Mode currentMode : Mode.values()) {
            if (currentMode.getIdentifier() == (content.charAt(0))) {
                lineMode = currentMode;
                cutModeIdentifier();
                break;
            }
        }
        //lineMode.call(this);
    }

    public void setContent(String s){
        this.content = s;
    }
    private void cutModeIdentifier() {
        content = content.substring(1);
    }

    public String[] getLineParts(){
        return lineParts;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\ncontent: %s\nMode: %s", name, content, lineMode);
    }
}
