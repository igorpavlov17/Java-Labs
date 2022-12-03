package db;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MyDB myDb = new MyDB();
        myDb.createTable();
        myDb.insert();
        myDb.select();
    }
}
