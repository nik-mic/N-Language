package system;

import input.Line;
import system.config.CommandNameWrapper;

public class NMSystem {

    private static int systemStatus = 1;
    public static char SAVE = '&';
    public static char GIVE = '<';
    public static char PRINT = '$';
    public static String PUSH = " :: ";
    public static Line.Mode defaultMode = Line.Mode.PRINT;

    private NMSystem(CommandNameWrapper cmw){
        SAVE = cmw.SAVE;
        GIVE = cmw.GIVE;
        PRINT = cmw.PRINT;
        PUSH = cmw.PUSHER;
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
