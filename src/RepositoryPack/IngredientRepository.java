package RepositoryPack;

import Models.IngredientItem;
import Models.Person;
import jdk.jshell.spi.ExecutionControl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientRepository implements IRepositoryItem<IngredientItem>
{
    public String TableName="Ingredients";

    public IngredientRepository()
    {
        CheckTable();
    }


    @Override
    public void Insert(IngredientItem entity)
    {

        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String InsertString="INSERT INTO "+ TableName +" (Name, Price, Calories) VALUES (?, ?, ?)";

            PreparedStatement  ps = conn.prepareStatement(InsertString);

            System.out.println(entity.getName());
            System.out.println(entity.getPrice());
            System.out.println(entity.getCalories());


            ps.setString(1, entity.getName());
            ps.setDouble(2, entity.getPrice());
            ps.setDouble(3, entity.getCalories());

            ps.execute();

            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public IngredientItem FindById(Long id)
    {
        IngredientItem ReturnIngredient=null;

        String SelectQuery = "SELECT * FROM "+TableName+" WHERE id = ? ";

        try (Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

             PreparedStatement ps = conn.prepareStatement(SelectQuery))
        {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ReturnIngredient = new IngredientItem();

                ReturnIngredient.setName(rs.getString("Name"));
                ReturnIngredient.setID(rs.getLong("ID"));
                ReturnIngredient.setPrice(rs.getDouble("Price"));
                ReturnIngredient.setCalories(rs.getDouble("Calories"));

            }

            rs.close();
            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            ReturnIngredient=null;
        }


        return  ReturnIngredient;
    }

    @Override
    public IngredientItem FindById(String id)
    {

        IngredientItem ReturnIngredient=null;

        String SelectQuery = "SELECT * FROM "+TableName+" WHERE Name = ? ORDER BY ID LIMIT 1";

        try (Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

             PreparedStatement ps = conn.prepareStatement(SelectQuery))
        {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ReturnIngredient = new IngredientItem();

                ReturnIngredient.setName(id);
                ReturnIngredient.setID(rs.getInt("ID"));
                ReturnIngredient.setPrice(rs.getDouble("Price"));
                ReturnIngredient.setCalories(rs.getDouble("Calories"));

            }

            rs.close();
            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            ReturnIngredient=null;
        }


        return  ReturnIngredient;

    }

    @Override
    public ArrayList<IngredientItem> findAll()
    {
        IngredientItem IngredientToAdd=null;

        ArrayList<IngredientItem>ReturnList= new ArrayList<IngredientItem>() ;

        String SelectQuery = "SELECT * FROM "+ TableName;

        try (Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

             Statement stm = conn.createStatement())
        {


            ResultSet rs = stm.executeQuery(SelectQuery);

            while (rs.next())
            {

                IngredientToAdd = new IngredientItem();

                IngredientToAdd.setName(rs.getString("Name"));
                IngredientToAdd.setID(rs.getInt("ID"));
                IngredientToAdd.setPrice(rs.getDouble("Price"));
                IngredientToAdd.setCalories(rs.getDouble("Calories"));

                ReturnList.add(IngredientToAdd);

            }

            rs.close();
            stm.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            ReturnList=null;
        }

        return ReturnList;
    }

    @Override
    public void Update(IngredientItem entity)
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String InsertString="Update "+ TableName +" (Name, Price, Calories) VALUES (?, ?, ?) WHERE ID=?";

            PreparedStatement  ps = conn.prepareStatement(InsertString);

            ps.setString(1, entity.getName());
            ps.setDouble(2, entity.getPrice());
            ps.setDouble(3, entity.getCalories());
            ps.setLong(4,entity.getID());

            ps.executeUpdate();

            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void DeleteById(Long id)
    {
        String DeleteQuery = "DELETE * FROM "+TableName+" WHERE id = ? ";

        try (Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

             PreparedStatement ps = conn.prepareStatement(DeleteQuery))
        {

            ps.setLong(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void DeleteById(String id)
    {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void CreateTable()
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String CreateString = "CREATE TABLE IF NOT EXISTS Ingredients (\n"
                                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                                + "    Name TEXT UNIQUE NOT NULL,\n"
                                + "    Price REAL NOT NULL,\n"
                                + "    Calories REAL NOT NULL\n"
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
                System.out.println("Ingredient table created.");
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
    public void LogAction() {

    }


}
