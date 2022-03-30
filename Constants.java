package common;

import java.io.File;

public class Constants {

   public static String USER_HOME = System.getProperty("user.dir");
    public static String RESOURCE_DIRECTORY = USER_HOME+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator;
    public static String SMTP_FILEPATH = RESOURCE_DIRECTORY+"smtp.properties";

    public static String USER_NAME ="vivekraj14157@Gmail.com";
    public static String USER_PASSWORD ="Sathish @1729";
    public static String HOST ="smtp.gmail.com";
    public static String PROTOCOL ="imaps";
    public static int CELL_VALUE0 = 0;
    public static int CELL_VALUE1 = 1;
    public static int CELL_VALUE2 = 2;
    public static String XLS_FILEPATH = RESOURCE_DIRECTORY+"MailDetails.xls";

}
