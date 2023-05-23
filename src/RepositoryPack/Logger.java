package RepositoryPack;

import AppItems.AppItems;

import java.io.File;
import java.io.IOException;

public class Logger
{
    public static String LogPath="";

    public static void Initialize()
    {


        String FolderPath= AppItems.CreateFolder();

        String fileName = FolderPath + "datalog.csv"; // Specify the name of the CSV file

        File file = new File(fileName);

        try
        {
            // Check if the file already exists
            if (!file.exists())
            {
                file.createNewFile();

            }
        }
        catch (IOException e)
        {
            System.out.println("Failed to create the log file. Exiting now.");
            System.out.println(e);
            System.exit(0);

        }
    }
    public static void WriteLog()
    {

    }

}
