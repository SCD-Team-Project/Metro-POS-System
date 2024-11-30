/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.EmployeeController;
import Model.EmployeeType;

/**
 *
 * @author LENOVO
 */
public class EmployeeStub 
{
    EmployeeController empController=new EmployeeController();
    
    public void verifyEmployeeLogin(int employeeID,String password, EmployeeType type)
    {
       
        int result=empController.verifyLogin(employeeID,password,type);
        switch (result) 
        {
            case 0 -> 
            {
                System.out.println("Logged In Successfully!");
                System.out.println("First time log in of user");
                System.out.println("Change password Kindly");
            }
            case 1 -> System.out.println("Logged in successfully!");
            default -> System.out.println("Error: Failed to log in!");
        }
            
        
    }

    public void changeEmployeePassword(int employeeID, EmployeeType type, String newPassword) 
    {
        boolean result=empController.changePassword(employeeID, type, newPassword);
        if(result)
        {
            System.out.println("Password Changed Successfully!");
        }
        else
        {
            System.out.println("Error Changing the password");
        }
    }
    
    public void delteEmployee(int employeeID,EmployeeType type)
    {
        boolean result=empController.deleteEmployee(employeeID, type);
        if(result)
        {
            System.out.println("Deleted Successfully");
        }
        else
        {
            System.out.println("Error deleting it");
        }
    }
}
