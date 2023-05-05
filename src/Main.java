import Models.Person;
import RepositoryPack.Repository;
import ViewAndActions.FoyerView;

public class Main
{

    //public static Person AppItems=null;

    public static void main(String[] args)
    {
        StartUP.Start();

        FoyerView.Enter();

    }

    private  static class StartUP
    {
        static void Start()
        {
            System.out.println("Configuring");
            Repository.StartRepo("Connection String Example");
            System.out.println("Configuration completed");

        }


    }

}

