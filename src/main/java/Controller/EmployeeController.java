
package Controller;

import Model.Employee.EmployeeService;
import Model.EmployeeType;

public class EmployeeController 
{
    private final EmployeeService employeeService;
    private static EmployeeController instance;
    public EmployeeController(EmployeeService empService)
    {
        this.employeeService=empService;
    }
     public static EmployeeController getInstance(EmployeeService empService)
    {
        if(instance==null)
        {
           instance=new EmployeeController(empService);
        }
        return instance;
    }
    //for adding new employee
    //this function should be returning new employeeID if no new employee inserted then it will be returning zero 0
    public int addNewEmployee(String email,String name,EmployeeType type,int branchID,String phone,String address,int salary)
    {
        //returning employeeID  
        //kindly ensure in the case of manager already exists they cannot add a new branch manager(button dusabled
        return employeeService.addEmployee(email, name, type, branchID, phone, address, salary);
    }
    public int getBranchID(int employeeID,EmployeeType type)
    {
        return employeeService.getBranchID(employeeID,type);
    }
    
    //when user logs into the system (verifying the user while loging in. 
    //this function will return either 0,1 or -1
    //0 means verified with 1st log in
    //1 means verified but not the first time input(so no need of showing the enter new password thingy
    //-1 means unable to find/verify user 
    public int verifyLogin(int employeeID,String enteredPassword,EmployeeType type)
    {
        return employeeService.verifyLogin(employeeID, enteredPassword, type);
    }
    
    //changing password
    public boolean changePassword(int employeeID,EmployeeType type,String newPassword)
    {
       return employeeService.changePassword(employeeID, type, newPassword);
    }
    
    public boolean deleteEmployee(int employeeID,EmployeeType type)
    {
        return employeeService.deleteEmployee(employeeID, type);
    }
}
