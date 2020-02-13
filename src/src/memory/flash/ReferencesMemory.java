package memory.flash;

import system.Certificate;
import system.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReferencesMemory {

    public ReferencesMemory() {
        references = new HashMap<>();
    }

    private final Map<String, Reference> references;

    public void insert(Reference ref, Token t) {
        Certificate.certificate(t, toString());
        references.put(ref.getIdentifier(), ref);
    }


    // TODO
    public void reName(String oldName, String newName, Token t) {
        if (t.isValid()) {
            Reference tmp = references.getOrDefault(oldName, null);
        }
    }
}
