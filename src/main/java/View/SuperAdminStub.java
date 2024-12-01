
package View;

import javax.swing.JButton;
import Controller.SuperAdminController;
import Model.Branch;
import Model.UserSession;
import java.util.Map;

//stub to only test the backend
public class SuperAdminStub 
{
    //JButton login;
    SuperAdminController SAdminController;

    public SuperAdminStub(SuperAdminController sAdminController) 
    {
        this.SAdminController=sAdminController;
    }
    
    //overall alllogin stub
    public void handleLogin(String type,String username,String password)
    {
        if("sAdmin".equals(type))
        {
            boolean isLoggedIn=SAdminController.verifyUser(username,password);
            if(isLoggedIn)
            {
                UserSession.create(username, type,0); //since this is admin so branchID is 0 for it
                System.out.println("Logged In");
            }
            else
            {
                //display errorr logging in. incorrect username or password
                System.out.println("Invalid Input");
            }
        }
        else
        {
            //in the employee controller the other login stub
        }
    }
    
    public void addNewBranch(String name,String phonenumber,String address,String city)
    {
        boolean result=SAdminController.insertNewBranch(name, city, address, phonenumber);
        if(result)
        {
            System.out.println("new branch addredd successfully");
        }
        else
        {
            System.out.println("Error: Failed to add new branch");
        }
    }
    
    public void displayBranches()
    {
        Map<Integer,Branch> branches=SAdminController.getAllBranches();
        
        for(Map.Entry<Integer,Branch> entry: branches.entrySet())
        {
            System.out.println(entry.toString());
        }
    }
    
    public void updateBranchStatus(int branchID,boolean status)
    {
        boolean result=SAdminController.updateBranchStatus(branchID,status); 
        //here it will go like that.user selects a row then click on activate/deactivate status.
        //the !currentstatus + row.getBranchID is taken from the table and controller is called!!
        if(result)
        {
            System.out.println("Status changed successfully");
        }
        else
        {
            System.out.println("Error: Failed to change status of the branch");
        }
    }
    
   /* public void addBranchManager(int branchID)
    {
        //branch id from row in the table yk
        //a row from table is selected. 
        //if the manager id there is zero then the add manager button will be enabled else disabled
        //the selected row branchID is sent to the controller so that a branch manager is added against him!
        boolean result=SAdminController.addBranchManager(branchID);
        if(result)
        {
            System.out.println("Branch Manager Added successfully");
        }
        else
        {
            System.out.println("Error: Failed to add branch manager");
        }
        
    } */
    
}
