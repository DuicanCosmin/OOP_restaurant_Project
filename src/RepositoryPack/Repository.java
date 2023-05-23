

package RepositoryPack;
import AppItems.AppItems;

import java.io.File;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.Scanner;

public  class  Repository
{
    private static String ConnStr ="";

    private static String FolderPath="";

    private static void ConnectionStringSet(String IncomingConnString)
    {
        ConnStr = IncomingConnString;
    }

    public static  String  ConnectionStringGet()
    {
        return ConnStr;
    }


    public static void StartRepo()
    {

        CheckDB();
        Logger.Initialize();
        PersonRepo = new PersonRepository ();
        IngredientRepo=new IngredientRepository();
        FoodRepo=new FoodRepository();
    }

    public static PersonRepository PersonRepo;
    public static IngredientRepository IngredientRepo;

    public static FoodRepository FoodRepo;

    private static void CheckDB()
    {


        FolderPath= AppItems.CreateFolder();

        String DBName="OOPDB.db";

        String tempConnString=FolderPath+=DBName;

        tempConnString=tempConnString.replace("\\","/");
        tempConnString="jdbc:sqlite:"+tempConnString;

        ConnectionStringSet(tempConnString);
        try
        {
            Connection conn = DriverManager.getConnection(ConnectionStringGet());
            conn.close();
        } catch (SQLException e)
        {
            System.out.println("DB creation Error.");
            System.out.println(e);
            System.exit(0);
        }


    }

    public static void DeleteDB()
    {
        System.out.println("Deleting the folder and database.");
        boolean success = deleteFolder(new File(FolderPath));
    }


    private static boolean deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }
        return folder.delete();
    }
}

