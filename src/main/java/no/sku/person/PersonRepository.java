package no.sku.person;

import no.sku.db.DbConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PersonRepository {

    public static Person fetchPersonById(UUID id){
        String SQL = "SELECT * FROM person WHERE id = ?;";

        try (Connection connection = new DbConnection().connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL))
        {
            preparedStatement.setObject(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            return toPersonObject(rs);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

    public static List<Person> fetchAll(){
        String SQL = "SELECT * FROM person";

        try (Connection connection = new DbConnection().connect();
             Statement statement = connection.createStatement())
        {
            ResultSet rs = statement.executeQuery(SQL);
            List<Person> personList= new ArrayList<>();
            while(rs.next()){
                personList.add(toPersonObject(rs));
            }
            return personList;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void save(Person person){
        String SQL = "INSERT INTO person(id, firstname, lastname) VALUES (?, ?, ?);";

        try (Connection connection = new DbConnection().connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL))
        {
            preparedStatement.setObject(1, person.id);
            preparedStatement.setString(2, person.firstName);
            preparedStatement.setString(3, person.lastName);
            preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void update(UUID id, String firstName, String lastName){
        String SQL = "UPDATE person SET(firstname, lastname) =(?, ?) WHERE id = ?;";

        try (Connection connection = new DbConnection().connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL))
        {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setObject(3, id);
            preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void delete(UUID id){
        String SQL = "DELETE FROM person WHERE id = ?;";
        try (Connection connection = new DbConnection().connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL))
        {
            preparedStatement.setObject(1, id);
            preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    private static Person toPersonObject(ResultSet rs) throws SQLException{
        return new Person(
                (UUID) rs.getObject("id"),
                rs.getString("firstName"),
                rs.getString("lastName")
        );

    }
}
