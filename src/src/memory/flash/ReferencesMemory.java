package memory.flash;

import system.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReferencesMemory {

    private ReferencesMemory(){
        references = new HashMap<>();
    }

    public static ReferencesMemory create(Token t){
        if(t.isValid()){
            return new ReferencesMemory();
        } throw new ArithmeticException("keine Berechtigung einen ReferenceMemory zu erstellen");
     }

    private final Map<String, Reference> references;

    public void insert(Reference ref, Token t){
        if(t.isValid()) {
            references.put(ref.getIdentifier(), ref);
        } throw new ArithmeticException("Keine Berechtigung Referencen hinzuzufügen");
    }


    // TODO
    public void reName(String oldName, String newName, Token t){
        if(t.isValid()){
            Reference tmp = references.getOrDefault(oldName, null);
        }
    }
}
