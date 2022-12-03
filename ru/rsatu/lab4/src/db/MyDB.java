package db;

import java.sql.*;

public class MyDB {
    Connection connection;
    Statement statement;

    private Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "db1351");
            if (connection != null){
                System.out.println("Connection OK");
                //connection.setAutoCommit(false);
            } else{
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void createTable() throws SQLException {
        try {
            statement = getConnection().createStatement();
            statement.execute("drop table if exists employee");
            statement.executeUpdate("create table if not exists employee(id serial primary key, name varchar(200), age int)");
            System.out.println("Table created");
        } catch (SQLException e) {
            connection.rollback();
            connection.close();
        }
    }

    public void insert() throws SQLException {
        try {
            statement = getConnection().createStatement();
            connection.setAutoCommit(false);
            statement.executeUpdate("insert into employee values (1, 'John', 18)");
            statement.executeUpdate("insert into employee values (2, 'Mike', 19)");
            statement.executeUpdate("insert into employee values (3, 'Steven', 20, 30)");
            connection.commit();
            System.out.println("Insert completed");
        } catch (SQLException e) {
            connection.rollback();
            connection.close();
        }
    }

    public void select() throws SQLException {
        try {
            statement = getConnection().createStatement();
            String select = "select * from employee";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + ": " +
                                   resultSet.getString("name") + ", " +
                                   resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            connection.rollback();
            connection.close();
        }
    }
}
