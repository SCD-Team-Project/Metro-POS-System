/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DatabaseConnector 
{
    private static final String URL="jdbc:postgresql://metrosystem-umaimakamran73-33f8.j.aivencloud.com:28109/metroPOSdb";
    private static final String username="avnadmin";
    private static final String password="AVNS_0iie8esrCjTRiIs3ngD";
    
    
    public static Connection connect()
    {
        Connection conn=null;
        try
        {
            conn = DriverManager.getConnection(URL,username,password);
            System.out.println("Connected to DB successfully");
        }
        catch(SQLException e)
        {
            System.out.println("Connection failed: "+e.getMessage());
        }
        return conn;
    }
}
