package memory.secondary;

import input.Line;

import java.util.ArrayList;
import java.util.List;

public class InputMemory {
    private final List<Line> memoryList = new ArrayList<>();

    public void add(Line line){
        memoryList.add(line);
    }

    public Line getLineOf(int lineNumber) throws ArrayIndexOutOfBoundsException {
        return memoryList.get(lineNumber);
    }
}
