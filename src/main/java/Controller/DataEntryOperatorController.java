
package Controller;

import Model.Category;
import Model.DataEntryOperator.DataEntryOperatorService;
import java.util.List;


public class DataEntryOperatorController 
{
    DataEntryOperatorService DEOService;

    public DataEntryOperatorController(DataEntryOperatorService DEOService) 
    {
        this.DEOService = DEOService;
    }
    
    public boolean addNewVendor(String vendorName,String phoneNumber,String email,String address)
    {
        return DEOService.addVendor(vendorName, phoneNumber, email, address);
    }
    
    public List<String> getAllVendorNames()
    {
        return DEOService.getAllVendorNames();
    }
    
    public List<Category> getAllCategories()
    {
        return DEOService.getAllCategories();
    }
    
    //get all products
    
    //insert new product
}
