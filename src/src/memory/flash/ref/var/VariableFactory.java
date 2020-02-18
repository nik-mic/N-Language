package memory.flash.ref.var;

import runnable.Main;
import system.security.Token;
import system.type.NMType;
import system.Process;

public final class VariableFactory {
    public static void initNewVariable(String name, NMType content, Token t){
        Process p = Main.getActiveProcess(t);
        Variable var = new Variable(name, p.getVarStorage(t).add(content, t));
        p.insertRef(var, t);
    }
}
