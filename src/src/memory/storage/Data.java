package memory.storage;

import system.security.Certificate;
import system.security.Token;
import system.type.NMType;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private final static Data preData = new Data();
    private final List<NMType> dataStorage = new ArrayList<>();
    private Data(){

    }
    public final Data createData(Token t){
        Certificate.certificate(t,toString());
        return new Data();
    }

    public NMType get(int i, Token t){
        Certificate.certificate(t, toString());
        return dataStorage.get(i);
    }

    public void add(NMType data, Token t){
        Certificate.certificate(t, toString());
        dataStorage.add(data);
    }

}
