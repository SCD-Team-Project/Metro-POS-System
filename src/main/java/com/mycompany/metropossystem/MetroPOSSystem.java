

package com.mycompany.metropossystem;

import Model.DatabaseConnector;
import View.Login;
import View.SuperAdminStub;
import java.sql.Connection;


public class MetroPOSSystem 
{

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
        
        //Connection con=DatabaseConnector.connect();
        
        SuperAdminStub admin=new SuperAdminStub("sAdmin","sAdmin","admin@123");
        admin.handleLogin();
        
        //admin.addNewBranch("Johar Town Branch", "03333333333", "Johar Town Block B", "Lahore");
        admin.displayBranches();
        
        //admin.updateBranchStatus(1001, false);
    }
}
