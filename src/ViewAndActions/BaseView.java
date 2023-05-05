package ViewAndActions;


import java.util.Scanner;

public abstract class BaseView
{

    protected static void ClearConsole()
    {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            System.out.println("Error clearing console: " + ex.getMessage());
        }
    }

    protected static void ByeByeView()
    {
        System.out.println("Bye bye. Hope you enjoyed our establishment.");
        System.exit(0);
    }

    protected static String ConsoleRead()
    {
        Scanner scanner=new Scanner(System.in);

        return scanner.nextLine();
    }

    protected static void ConsoleWriteLine(String Input)
    {
        System.out.println(Input);
    }


}
