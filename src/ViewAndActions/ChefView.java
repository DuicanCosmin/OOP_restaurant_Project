package ViewAndActions;

import AppItems.AppItems;
import Models.IngredientItem;

import javax.swing.text.html.Option;
import java.util.Scanner;

public class ChefView extends BaseView
{
    public static void ChefSelect()
    {


        String OptionInput="";
        Scanner scanner=new Scanner(System.in);

        while (true)
        {
            ClearConsole();
            System.out.println("What would you like to do?");

            System.out.println("1 Manage ingredient");
            System.out.println("2 Create recipe");
            System.out.println("3 Cook");
            System.out.println("4 Back");

            OptionInput=scanner.nextLine();

            switch (OptionInput)
            {
                case "1":
                    // Create ingredient
                    ManageIngredients();
                    break;
                case "2":
                    // Create recipe
                    System.out.println("2 Create recipe");
                    break;
                case "3":
                    //Cook open Orders;
                    System.out.println("3 Cook");
                    break;
                case "4":
                    FoyerView.Enter();
                    break;

            }
        }

    }



    public static void ManageIngredients()
    {
        String OptionInput="";
        Scanner scanner=new Scanner(System.in);

        loop: while(true)
        {
            ClearConsole();

            System.out.println("What would you like to do?");

            System.out.println("1 Add ingredient");
            System.out.println("2 Edit ingredient");
            System.out.println("3 Delete ingredient");
            System.out.println("4 Back");

            OptionInput=ConsoleRead();

            switch (OptionInput) {
                case "1":

                    CreateIngredient();
                    break;
                case "2":
                    // Create recipe
                    EditIngredient();
                    break;
                case "3":
                    //Cook open Orders;
                    System.out.println("3 Cook");
                    break;
                case "4":

                    break loop;

            }
        }

    }

    public static void CreateIngredient()
    {
        IngredientItem IngredientToAdd= GenerateItemToAdd();
        ClearConsole();
        ConfirmAdd(IngredientToAdd);
    }

    public static void EditIngredient()
    {
        ClearConsole();
        DisplayIngredientList();

        //select ingredient to edit

        ConsoleRead();
    }

    private static void DisplayIngredientList()
    {
        ConsoleWriteLine("Ingredient 1");
        ConsoleWriteLine("Ingredient 2");
        ConsoleWriteLine("Ingredient 3");
        ConsoleWriteLine("Ingredient 4");
    }

    private static IngredientItem GenerateItemToAdd()
    {
        IngredientItem IngredientToAdd=new IngredientItem();

        String UserInput="";

        Scanner scanner=new Scanner(System.in);

        while(true)
        {
            ClearConsole();

            System.out.println("Please the ingredient name");

            UserInput= scanner.nextLine();

            if(UserInput.length()>0)
            {
                IngredientToAdd.setName(UserInput);
                break;
            }
            else
            {
                ConsoleWriteLine("Name is not valid");
                ConsoleRead();
            }

        }

        double TempInput=-1;

        while (true)
        {
            System.out.println("Please insert the  number of calories");

            UserInput= scanner.nextLine();

            if (AppItems.isDouble(UserInput))
            {
                TempInput=Double.parseDouble(UserInput);
                // uranium has 18000000 Calories per gram.
                if (TempInput>0 && TempInput<18000000)
                {
                    IngredientToAdd.setCalories(TempInput);
                    TempInput=-1;
                    break;
                }
                else
                {
                    System.out.println("Invalid input (Value error)");
                }

            }
            else
            {
                System.out.println("Invalid input(Not a number)");
            }
        }

        while (true)
        {
            System.out.println("Please insert the ingredient cost");

            UserInput= scanner.nextLine();


            if (AppItems.isDouble(UserInput))
            {
                TempInput=Double.parseDouble(UserInput);

                ConsoleWriteLine("Value " + TempInput);

                // one billion should be enough form any ingredient
                if (TempInput>0 && TempInput<1000000000)
                {
                    IngredientToAdd.setPrice(TempInput);
                    TempInput=-1;
                    break;
                }
                else
                {
                    System.out.println("Invalid input (Value error)");
                }

            }
            else
            {
                System.out.println("Invalid input(Not a number)");
            }
        }
        return IngredientToAdd;
    }


    private static void ConfirmAdd(IngredientItem IngredientToAdd)
    {
        ClearConsole();
        System.out.println("The following ingredient will be added:");
        System.out.println("Name: "+ IngredientToAdd.getName());
        System.out.println("Calories: " +IngredientToAdd.getCalories());
        System.out.println("Price");
        System.out.println("Name: "+ IngredientToAdd.getPrice());

        String UserInput;
        ConsoleWriteLine("Are you sure you want to add the ingredient? (Y/N/R)");
        UserInput=ConsoleRead().toUpperCase();

        ConsoleWriteLine(UserInput);

        switch (UserInput)
        {
            case "Y":
                System.out.println("Item added");
                break;
            case "N":
                ConsoleWriteLine("Canceled");
                break;
            case "R":
                CreateIngredient();
                break;
            default:
                ConfirmAdd(IngredientToAdd);
                break;
        }


    }


}


