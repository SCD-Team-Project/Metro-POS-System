

package com.mycompany.metropossystem;

import Controller.DataEntryOperatorController;
import Model.DataEntryOperator.DataEntryOperatorService;
import Model.DatabaseConnector;
import View.DataEntryOperatorStub;
import View.SuperAdminStub;
import java.sql.Connection;


public class MetroPOSSystem 
{

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
        
        Connection conn=DatabaseConnector.connect();
        
       // SuperAdminStub admin=new SuperAdminStub(Controller);
        //admin.handleLogin();
        
        //admin.addNewBranch("Johar Town Branch", "03333333333", "Johar Town Block B", "Lahore");
       // admin.displayBranches();
        
        //admin.updateBranchStatus(1001, false);
   
        DataEntryOperatorService deoService=new DataEntryOperatorService(conn);
        DataEntryOperatorController deoController=new DataEntryOperatorController(deoService);
        DataEntryOperatorStub deoStub=new DataEntryOperatorStub(deoController);
        
        deoStub.addNewVendor("Candyland", "11111111111", "candyland@suport.com", "Raiwand, Lahore");
        deoStub.addNewVendor("Candyland", "11111111111", "candyland@suport.com", "Raiwand, Lahore");
        deoStub.getAllVendors();
    }
}
