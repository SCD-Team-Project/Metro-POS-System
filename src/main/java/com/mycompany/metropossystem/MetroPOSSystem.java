

package com.mycompany.metropossystem;

import Model.DatabaseConnector;
import java.sql.Connection;


public class MetroPOSSystem 
{

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
        
        Connection con=DatabaseConnector.connect();
    }
}
