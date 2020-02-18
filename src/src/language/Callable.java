package language;

import input.Line;
import system.type.NMType;

@FunctionalInterface
public interface Callable {
    public NMType methodCall(String call);
}
