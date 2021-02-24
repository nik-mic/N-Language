package memory.flash.ref;

import common.Validation;
import language.Callable;
import memory.flash.ref.func.Function;
import memory.flash.ref.var.Variable;
import system.security.Certificate;
import system.security.Token;
import system.type.NMType;

import java.util.HashMap;
import java.util.Map;

public class ReferencesMemory {

    public ReferencesMemory() {
        references = new HashMap<>();
        rules = new HashMap<>();

    }
    private final Map<String, Reference> references;
    private final Map<String, Reference> rules;

    public void insert(Reference r, Token t){
        Certificate.certificate(t, toString());
        references.put(r.getIdentifier(), r);
    }


    // TODO exception handlig
    public NMType get(String name, Token t){
        Reference var = references.getOrDefault(name, null);
        return var.resolve(t);
    }
}
