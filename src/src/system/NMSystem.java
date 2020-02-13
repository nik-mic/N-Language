package system;

public class  NMSystem {
    private static int systemStatus = 1;
    private NMSystem(){

    }

    public static boolean isRunning(){
        return systemStatus>-1;
    }
    public static boolean isActive(){
        return systemStatus>0;
    }

    @Override
    public String toString() {
        return "current systemstatus: " + systemStatus;
    }
}
