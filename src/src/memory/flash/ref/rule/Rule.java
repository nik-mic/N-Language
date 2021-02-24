package memory.flash.ref.rule;

import memory.flash.ref.Reference;
import system.security.Token;
import system.type.NMType;

public class Rule extends Reference {

   protected Rule(String refIdentifier) {
        super(refIdentifier, 0);
   }

    @Override
    public NMType resolve(Token t) {
        return null;
    }
}
