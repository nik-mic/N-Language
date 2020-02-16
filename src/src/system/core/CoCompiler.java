package system.core;

import input.Line;
import input.Readable;
import system.NMSystem;

public enum CoCompiler implements Compilable {
    /*welche Operation?
      - print, safe, give
    */
     TRIMMER{

    },
    INTERPRT {

    }, DEREF {

    }, DECOMMAND {

    }, LOADER;

    @Override
    public Line compile(Line line) {
        return null;
    }
}
