package memory.story;

import system.Token;

import java.util.ArrayList;
import java.util.List;

public class OutputMemory {
    private final List<String> outputStory;

    public OutputMemory(){
        outputStory = new ArrayList<>();
    }

    public void add(String s, Token t){
        if(t.isValid()){
            outputStory.add(s);
        } throw new ArithmeticException("Keine Berechtigung den Output zu erstellen");
    }
    public List<String> getOutputList(Token t){
        if(t.isValid()){
            return new ArrayList<>(outputStory);
        } throw new ArithmeticException("Keine Berechtigung den Output zu lesen");
    }
}
