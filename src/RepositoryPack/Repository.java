

package RepositoryPack;

public  class  Repository
{
    private static String ConnStr ="";

    private static void ConnectionStringSet(String IncomingConnString)
    {
        ConnStr = IncomingConnString;
    }

    public static  String  ConnectionStringGet()
    {
        return ConnStr;
    }


    public static void StartRepo(String IncomingConnString)
    {
        if(IncomingConnString!=null && IncomingConnString.length()>0)
        {
            ConnectionStringSet(IncomingConnString);
        }

        PersonRepo = new PersonRepository ();
    }

    public static PersonRepository PersonRepo;



}

