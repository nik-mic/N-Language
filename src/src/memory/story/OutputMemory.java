package memory.story;

import system.Certificate;
import system.Token;

import java.util.ArrayList;
import java.util.List;

public class OutputMemory {
    private final List<String> outputStory;

    public OutputMemory() {
        outputStory = new ArrayList<>();
    }

    public void add(String s, Token t) {
        Certificate.certificate(t, toString());
        outputStory.add(s);
    }

    public List<String> getOutputList(Token t) {
        Certificate.certificate(t, toString());
        return new ArrayList<>(outputStory);
    }
}
