package memory.flash.ref;

import system.security.Token;
import system.type.NMType;

public interface Resolvable {
    NMType resolve(Token t);
}
