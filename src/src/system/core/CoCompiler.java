package system.core;

import input.Line;
import input.Readable;
import language.Method;
import language.Topic;
import language.methods.Math.MathCount;
import memory.flash.ref.rule.Rule;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public enum CoCompiler implements Compilable {

    TRIMMER {
        @Override
        public Line compile(Line l) {
            l.setContent(l.getContent().trim());
            return l;
        }
    },
    DERULE{
        @Override
        public Line compile(Line l) {
           /* List<Rule> rules = getRules();
            String content = l.getContent();
            for(Rule r : rules){
                if(content.contains(r.getIdentifier())){

                }
            }
            l.setContent(content);*/
            return null;
        }
    },
    DEREF {
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
           // return Main.getActiveProcess(null).getRef(refName);
        }
    }, DECOMMAND {

        private final Map<Topic, Map<String, Method>> language = Collections.unmodifiableMap(Map.of(Topic.MATH, Map.of("count", new MathCount())));

        @Override
        public Line compile(Line l) {
            // Premisse: in perfekter form um methoden auszuführen bsp: Math count Math count Math sum
            // Math count 10
            // Math count: 10
            // Math count: Math sum: Math count: 10 Math count: 15
            return null;
        }

        /*
            & SAVE -> VAR, FUNC, OPERATOR
            $ PRINT -> CONSOLE -> Output




         */
        // Math count Math sum;

        // &MATH count 10 :: a
        // MATH count !a + 10
        // Parameter Overloading
        // <Math count Math sum #a #b ::
        // &Math count 10 :: A

        private String decommand(String command){
            String[] parts = command.split(" ");
            return language
                    .getOrDefault(Topic.of(parts[0]), null)
                    .getOrDefault(parts[1], null).methodCall("").toString();
        }
    }, LOADER {
        @Override
        public Line compile(Line l) {
            return null;
        }
    };

}
