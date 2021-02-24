package language;

public enum Topic {
    MATH, TEXT, FILE, OWN, DEFAULT;

    public static Topic of(String desc){
        for(Topic t : Topic.values()){
            if(t.name().equals(desc)){
                return t;
            }
        } return DEFAULT;
    }
}
