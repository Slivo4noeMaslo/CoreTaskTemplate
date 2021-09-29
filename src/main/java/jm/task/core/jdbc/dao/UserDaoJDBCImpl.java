package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try(Statement stm = Util.getConnection().createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS user " +
                    "(id BIGINT(30) AUTO_INCREMENT, " +
                    "name VARCHAR(30)," +
                    "lastName VARCHAR(60)," +
                    "age TINYINT," +
                    "PRIMARY KEY (id))";
            stm.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try(Statement stm = Util.getConnection().createStatement()) {
            String query = "DROP TABLE IF EXISTS user";
            stm.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Statement stm = Util.getConnection().createStatement()) {
            String query = "insert into user(name, lastName, age) values ('" + name + "'" +"," + "'" + lastName + "'"+ "," + age + ")";
            stm.executeUpdate(query);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(Statement stm = Util.getConnection().createStatement()) {
            String query = "delete from user where id = id";
            stm.executeUpdate(query);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try(Statement stm = Util.getConnection().createStatement()) {
            String query = "select * from user";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                list.add(user);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try(Statement stm = Util.getConnection().createStatement()) {
            String query = "delete from user";
            stm.executeUpdate(query);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
