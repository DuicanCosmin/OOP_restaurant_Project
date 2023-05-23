package RepositoryPack;

import Models.Person;

import javax.naming.Name;
import javax.swing.text.TabExpander;
import java.sql.*;
import java.util.List;

public class PersonRepository implements IRepositoryItem<Person>
{

    String TableName="Users";

    public  PersonRepository()
    {
        CheckTable();
    }

    @Override
    public void Insert(Person entity)
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String InsertString="INSERT INTO "+ TableName +" (Name, Role) VALUES (?, ?)";

            PreparedStatement  ps = conn.prepareStatement(InsertString);

            ps.setString(1, entity.Name );
            ps.setString(2, entity.Role);

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
    public Person FindById(Long id) {
        return null;
    }

    @Override
    public Person FindById(String id)
    {
        Person ReturnPerson=null;

        String SelectQuery = "SELECT * FROM "+TableName+" WHERE Name = ? ORDER BY ID LIMIT 1";

        try (Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

             PreparedStatement ps = conn.prepareStatement(SelectQuery)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ReturnPerson = new Person();

                int ResultID = rs.getInt("ID");
                String ResultRole = rs.getString("Role");

                ReturnPerson.id=ResultID;
                ReturnPerson.Role=ResultRole;
                ReturnPerson.Name=id;

            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ReturnPerson=null;
        }


        return  ReturnPerson;
    }

    @Override
    public List<Person> findAll()
    {
        System.out.println("Get all");
        return null;
    }

    @Override
    public void Update(Person entity)
    {
        System.out.println("Update Person");
    }

    @Override
    public void DeleteById(Long id)
    {

    }

    @Override
    public void DeleteById(String id)
    {
        System.out.println("Delete Person");
    }



    @Override
    public void CheckTable()
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String QueryString="SELECT name FROM sqlite_master WHERE type='table' AND name= ? ";

            PreparedStatement  ps = conn.prepareStatement(QueryString);

            ps.setString(1, TableName);

            ResultSet rs = ps.executeQuery();
            if (!rs.next())
            {
                CreateTable();
                System.out.println("Users table created exists");
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
    public void LogAction()
    {

    }


    @Override
    public void CreateTable()
    {
        try
        {
            Connection conn = DriverManager.getConnection(Repository.ConnectionStringGet());

            String CreateString = "CREATE TABLE IF NOT EXISTS Users (\n"
                    + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "    Name TEXT UNIQUE NOT NULL,\n"
                    + "    Role TEXT NOT NULL\n"
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

        Person AddDefaultUser=new Person();

        AddDefaultUser.Role= String.valueOf(Person.Roles.Chef);
        AddDefaultUser.Name="Master Chef";

        Insert(AddDefaultUser);

    }

    public List<Person> FindByRole(String Role)
    {

        return null;
    }



}
