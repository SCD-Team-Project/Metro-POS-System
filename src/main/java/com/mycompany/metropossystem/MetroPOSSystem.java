

package com.mycompany.metropossystem;

import Controller.DataEntryOperatorController;
import Controller.EmployeeController;
import Controller.SuperAdminController;
import Model.DataEntryOperator.DataEntryOperatorService;
import Model.DatabaseConnector;
import Model.Employee.EmployeeService;
import Model.EmployeeType;
import Model.SAdmin.SuperAdminService;
import View.DataEntryOperatorStub;
import View.EmployeeStub;
import View.Login;
import View.SplashScreen;
//import View.Login;
//import View.SplashScreen;
import View.SuperAdminStub;
import java.sql.Connection;


public class MetroPOSSystem 
{

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
        
        new SplashScreen().setVisible(true);
        Connection conn=DatabaseConnector.connect();
        
       // SuperAdminStub admin=new SuperAdminStub(Controller);

       // SuperAdminStub admin=new SuperAdminStub("sAdmin","sAdmin","admin@123");
        //admin.handleLogin();
        
        //admin.addNewBranch("Johar Town Branch", "03333333333", "Johar Town Block B", "Lahore");
       // admin.displayBranches();
        
        //admin.updateBranchStatus(1001, false);
   
        
        
        //deoStub.addNewVendor("Candyland", "11111111111", "candyland@suport.com", "Raiwand, Lahore");
       // deoStub.addNewVendor("Candyland", "11111111111", "candyland@suport.com", "Raiwand, Lahore");
        //deoStub.getAllVendors();
        //admin.deleteBranch(1001);
       // admin.deleteBranch(1000);
       // admin.addBranchManager(1000, "umaima@gmail.com", "Umaima", "03333333333", "Lahore", 20000, EmployeeType.BRANCH_MANAGER);
          
        //EmployeeStub empStub=new EmployeeStub(); 
       // empStub.delteEmployee(1000, EmployeeType.BRANCH_MANAGER);
       // empStub.changeEmployeePassword(1000,EmployeeType.BRANCH_MANAGER,"qwerty123");
      //empStub.verifyEmployeeLogin(1000, "password_123", EmployeeType.BRANCH_MANAGER);
       // empStub.verifyEmployeeLogin(1001, "password_123", EmployeeType.BRANCH_MANAGER);
        
       // admin.displayBranches();
       
       SuperAdminService superAdminService=new SuperAdminService(conn);
       SuperAdminController sAdminController=SuperAdminController.getInstance(superAdminService);
       
       EmployeeService employeeService=new EmployeeService(conn);
       EmployeeController employeeController=EmployeeController.getInstance(employeeService);
       
        DataEntryOperatorService deoService=new DataEntryOperatorService(conn);
        DataEntryOperatorController deoController=DataEntryOperatorController.getInstance(deoService);
        //DataEntryOperatorStub deoStub=new DataEntryOperatorStub(deoController);
       
       new Login(sAdminController,employeeController).setVisible(true);
       
       
        System.out.println("EmployeeTYpe: "+ EmployeeType.BRANCH_MANAGER+" "+ EmployeeType.DATA_ENTRY_OPERATOR+" "+ EmployeeType.CASHIER);
        
    }
}
