package system.core;

import input.Line;
import input.Readable;
import runnable.Main;
import system.NMSystem;
import system.security.Token;
import system.Process;

public enum CoCompiler implements Compilable {

    TRIMMER {
        @Override
        public Line compile(Line l) {
            l.setContent(l.getContent().trim());
            return l;
        }
    }, DEREF {
        @Override
        public Line compile(Line l) {
            String content = l.getContent();
            String[] parts = l.getLineParts();
            String tmpContent = "";
            while (content.contains(" !")) {
                for (String part : parts) {
                    if (part.startsWith("!")) {
                        String refName = part.replaceAll("!", "");
                        tmpContent = tmpContent + " " + re(refName);
                    } else {
                        tmpContent = tmpContent + " " + part;
                    }
                } content = tmpContent;
            }
            l.setContent(content);
            return CoCompiler.TRIMMER.compile(l);
        }

        private String re(String refName) {
            return "";
        }
    }, DECOMMAND {
        @Override
        public Line compile(Line l) {
            return null;
        }
    }, LOADER {
        @Override
        public Line compile(Line l) {
            return null;
        }
    };

    Process getProcess(Token t) {
       // return Main.getActiveProcess();
        return null;
    }

}
