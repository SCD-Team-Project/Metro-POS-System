
package Controller;

import Model.Branch;
import Model.SAdmin.SuperAdminService;
import java.util.Map;

public class SuperAdminController 
{
    private final SuperAdminService sAdminService;
    private static SuperAdminController instance;
    
    
    private SuperAdminController(SuperAdminService sAdminService)
    {
        this.sAdminService=sAdminService;
    }
    public static SuperAdminController getInstance(SuperAdminService sAdminService)
    {
        if(instance==null)
        {
           instance=new SuperAdminController(sAdminService);
        }
        return instance;
    }
    public boolean verifyUser(String username, String password) 
    {
        return sAdminService.login(username,password);
    }
    
    public boolean insertNewBranch(String branchName,String city,String address,String phoneNumber)
    {
        return sAdminService.insertNewBranch(branchName, city, address, phoneNumber);
    }

    public Map<Integer, Branch> getAllBranches() 
    {
        return sAdminService.getAllBranches();
    }

    public boolean updateBranchStatus(int branchID, boolean status) 
    {
        return sAdminService.updateBranchStatus(branchID, status);
    }

    public boolean deleteBranch(int branchID)
    {
        return sAdminService.deleteBranch(branchID);
    }
   // public boolean addBranchManager(int branchID,Employee manager) 
    //{
     //   return addBranchManager(branchID,manager);
   // }
    
    
    
}
