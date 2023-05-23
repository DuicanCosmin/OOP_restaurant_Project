package AppItems;
import Models.Person;

import java.io.File;


// Contains all the static app items, such as the current "logged" user.
public class AppItems
{
    public static Person CurrentUser = null;

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String CreateFolder()
    {
        String FolderAddress=System.getProperty("user.home");
        FolderAddress+= "\\OopProject\\";

        File folder = new File(FolderAddress);



        if (!folder.exists())
        {
            boolean success = folder.mkdir();
            if (!success)
            {
                System.out.println("Failed to create folder.");
                System.out.println("Exiting Now");
                System.exit(0);
            }
        }
        return  FolderAddress;
    }

}
