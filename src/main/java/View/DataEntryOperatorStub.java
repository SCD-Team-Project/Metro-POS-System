
package View;

import Controller.DataEntryOperatorController;
import java.util.List;


public class DataEntryOperatorStub 
{
    DataEntryOperatorController deoController;

    public DataEntryOperatorStub(DataEntryOperatorController deoController)
    {
        this.deoController = deoController;
    }
    
    public void addNewVendor(String name,String phoneNumber,String email,String address)
    {
        boolean result=deoController.addNewVendor(name, phoneNumber, email, address);
        if(result)
        {
            System.out.println("New Vendor Added Successfully");
        }
        else
        {
            System.out.println("Error adding new Vendor");
        }
    }
    
    public void getAllVendors()
    {
        List<String> vendorNames=deoController.getAllVendorNames();
        
        System.out.println("Vendor names are: ");
        for(String vendor: vendorNames)
        {
            System.out.println(vendor+"\t");
        }
    }
    
}
