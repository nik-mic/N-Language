package system.security;

public class Token {
    private final static Token innerToken = new Token();
    private int runningNumber;
    private Token(){
        runningNumber = (int) System.currentTimeMillis();
    }

    public static Token getInnerToken(){
        return innerToken;
    }

    public boolean isValid() {
        return true;
    }
}
