package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8";
    private static final String DB_USER;
    private static final String DB_PASS;

    static{
        try{
            Path path = Paths.get("dbUserPs");

            List<String> lines = Files.readAllLines(path);
            DB_USER = lines.get(0);
            DB_PASS = lines.get(1);

        }catch (IOException e){
            System.out.println("couldt get user and password for DB");
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}



