package memory.flash.ref;

import language.Callable;
import memory.flash.ref.func.Function;
import system.security.Certificate;
import system.security.Token;

import java.util.HashMap;
import java.util.Map;

public class ReferencesMemory {

    public ReferencesMemory() {
        variables = new HashMap<>();
        functions = new HashMap<>();
    }


    private final Map<String, Reference> variables;
    private final Map<String, Callable> functions;

    public void insert(Reference var, Token t) {
        Certificate.certificate(t, toString());
        variables.put(var.getIdentifier(), var);
    }
    public void insert(Function f, Token t){
        Certificate.certificate(t, toString());
        functions.put(f.getIdentifier(), f);
    }

    // TODO
    public void reName(String oldName, String newName, Token t) {
        if (t.isValid()) {
            Reference tmp = variables.getOrDefault(oldName, null);
        }
    }
}
