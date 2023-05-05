package ViewAndActions;
import Models.Person;
import RepositoryPack.Repository;
import AppItems.AppItems;


import java.util.Scanner;

public class FoyerView extends BaseView
{
    public static void Enter()
    {

        String UserInput="";

        Scanner scanner= new Scanner (System.in) ;

        while (true){
            ClearConsole();

            System.out.println("1 Enter credentials");

            System.out.println("2 Create new");

            System.out.println("3 Leave");

            UserInput=scanner.next();

            switch (UserInput)
            {
                case "1":
                    System.out.println("Logging in");
                    Login();
                    break;
                case "2":
                    Register();
                    break;
                case "3":
                    ByeByeView();
                    break;
                default:
                    ConsoleWriteLine("Invalid selection");
                    break;
            }
        }
    }

    protected static void Register()
    {


        String UserInput="";

        Scanner scanner=new Scanner(System.in);

        while (true)
        {
            ClearConsole();
            System.out.println("Register new user");

            System.out.println("Please insert your Name");

            UserInput=scanner.nextLine();

            if (UserInput.length()!=0)
            {
                Person NewUser=new Person();
                NewUser.Name=UserInput;
                NewUser.Role="Client";

                Repository.PersonRepo.Insert(NewUser);
                AppItems.CurrentUser=NewUser;
                NavigateByRole();
                break;
            }
            else
            {
                ConsoleWriteLine("User name cannot be null.");
            }

        }







    }

    public static void Login()
    {
        ClearConsole();

        String UserInput="";
        String OptionInput="";
        Scanner scanner=new Scanner(System.in);

        loop :while (true)
        {
            ClearConsole();
            System.out.println("Please insert your Name");

            UserInput=scanner.nextLine();

            var FoundUser=Repository.PersonRepo.FindById(UserInput);

            if (FoundUser==null)
            {
                ClearConsole();
                System.out.println("User " + UserInput + "not found");
                System.out.println("1 Retry" );
                System.out.println("2 Add new user");
                System.out.println("3 Back");

                OptionInput=scanner.nextLine();

                switch (OptionInput)
                {
                    case "1":
                        break;
                    case "2":
                        Register();
                        break;
                    case "3":
                        break loop;
                }

            }
            else
            {
                AppItems.CurrentUser=FoundUser;
                NavigateByRole();
            }
        }
    }

    public static void NavigateByRole()
    {
        if(AppItems.CurrentUser.Role=="Chef")
        {
            ChefView.ChefSelect();
        }
        else if(AppItems.CurrentUser.Role=="Client")
        {
            // redirect to Menu View and other stuff
        }
    }
}
