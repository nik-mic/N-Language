package system.type;

public class NMType <T extends String> implements Comparable<NMType<T>> {
    private final T content;
    public NMType(T content){
        this.content = content;
    }

    @Override
    public int compareTo(NMType nmType) {
        return 0;
    }
}

/*
    Was sind funktions?
    &Niklas decide a < b, a, b :: myResult


    &Funktion Math count #a :: b
    &Custom b 10 :: c

    PRINT, SAVE, MAKE
    PRINT -> Outputliste
    SAVE  -> REFLISTE
    MAKE  -> Funktionsliste


    -> Save

    Variable ist eine triviale Function:
    Ref -> return value -> value;

    &Math count 10 :: a (var)
    <Math count #b :: a (func)

    <Math count 10
    Text say !a
    Math sum !a

    Math sum !a #4 #Hallo #2.4 !b #10 #3 #4 -> Math sum <Math count #b 4
    Math sum !a -> Math sum Math count 10 -> Math sum 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> 45
    <Math sum !a #b :: c ->
    &Text sayBackwards !c 10 :: a -> Text sayBackwards !c 10 -> Text sayBackwards Math sum !a #b #10


    Variable:
        Ref -> value
        a -> "abc"
    Function:
        Ref -> Code -> value

 */
