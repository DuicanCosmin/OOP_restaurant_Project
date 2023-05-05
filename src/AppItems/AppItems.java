package AppItems;
import Models.Person;


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
}
