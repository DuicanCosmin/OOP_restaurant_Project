package RepositoryPack;

import Models.ChefItem;
import Models.IngredientItem;

import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.List;

public class FoodRepository implements IRepositoryItem<ChefItem>
{
    String TableName="Foods";
    String JoinTable ="FoodIngredients";

    public FoodRepository()
    {
        CheckTable();
    }

    @Override
    public void Insert(ChefItem entity)
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String InsertString="INSERT INTO "+ TableName +" (Name, RecipeString, ProfitMargin,Discount) VALUES (?, ?, ?,?)";

            PreparedStatement  ps = conn.prepareStatement(InsertString);



            ps.setString(1, entity.getName());
            ps.setString(2, entity.getRecipeString());
            ps.setDouble(3, entity.getProfitMargin());
            ps.setDouble(4, entity.getDiscount());

            ps.execute();

            ps.close();

            String JoinInsert="INSERT INTO "+JoinTable+ "(Food_id,Ingredient_id) VALUES (?,?) ";

            ps = conn.prepareStatement(JoinInsert);

            for (IngredientItem Ingredient : entity.getIngredientList())
            {
                ps.setLong(1,entity.getID());
                ps.setLong(2,Ingredient.getID());
                ps.execute();
            }

            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }



    }

    @Override
    public ChefItem FindById(Long id)
    {
        ChefItem ReturnFood=null;

        String SelectQuery = "SELECT * FROM "+TableName+" WHERE id = ? ";

        try (Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

             PreparedStatement ps = conn.prepareStatement(SelectQuery))
        {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ReturnFood = new ChefItem();

                ReturnFood.setName(rs.getString("Name"));
                ReturnFood.setID(rs.getLong("ID"));
                ReturnFood.setDiscount(rs.getDouble("Price"));
                ReturnFood.setProfitMargin(rs.getDouble("Calories"));
                ReturnFood.setRecipeString(rs.getString("RecipeString"));

            }

            rs.close();
            ps.close();

            String SelectItems ="Select * FROM ";


            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            ReturnFood=null;
        }


        return  ReturnFood;
    }

    @Override
    public ChefItem FindById(String id) {
        return null;
    }

    @Override
    public List<ChefItem> findAll() {
        return null;
    }

    @Override
    public void Update(ChefItem entity)
    {

    }

    @Override
    public void DeleteById(Long id)
    {

    }

    @Override
    public void DeleteById(String id)
    {

    }

    @Override
    public void CreateTable()
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String CreateString = "CREATE TABLE IF NOT EXISTS " + TableName + "(\n"
                                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                                + "    Name TEXT UNIQUE NOT NULL,\n"
                                + "    RecipeString TEXT NOT NULL,\n"
                                + "    ProfitMargin REAL NOT NULL,\n"
                                + "    Discount REAL NOT NULL\n"
                                + ");";

            Statement stmt = conn.createStatement();

            stmt.execute(CreateString);

            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void CreateJoinTable()
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());


            String CreateString  = "CREATE TABLE IF NOT EXISTS "+JoinTable+" (" +
                                    "food_id INTEGER," +
                                    "ingredient_id INTEGER," +
                                    "FOREIGN KEY (food_id) REFERENCES "+TableName+" (id)," +
                                    "FOREIGN KEY (ingredient_id) REFERENCES Ingredients (id)," +
                                    "PRIMARY KEY (food_id, ingredient_id))";
            Statement stmt = conn.createStatement();

            stmt.execute(CreateString);

            stmt.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void CheckTable()
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String QueryString="SELECT name FROM sqlite_master WHERE type='table' AND name= ? ";

            PreparedStatement ps = conn.prepareStatement(QueryString);

            ps.setString(1, TableName);

            ResultSet rs = ps.executeQuery();
            if (!rs.next())
            {
                CreateTable();
                System.out.println("Foods table created");
            }

            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String QueryString="SELECT name FROM sqlite_master WHERE type='table' AND name= ? ";

            PreparedStatement ps = conn.prepareStatement(QueryString);

            ps.setString(1, JoinTable);

            ResultSet rs = ps.executeQuery();
            if (!rs.next())
            {
                CreateJoinTable();
                System.out.println("Food and ingredients join table created");
            }

            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void LogAction(String Action)
    {

    }
}
