
package Controller;

import Model.Category;
import Model.DataEntryOperator.DataEntryOperatorService;
import Model.Product;
import Model.Sale;
import java.util.List;


public class DataEntryOperatorController 
{
    final DataEntryOperatorService DEOService;
    private static DataEntryOperatorController instance;
    public DataEntryOperatorController(DataEntryOperatorService DEOService) 
    {
        this.DEOService = DEOService;
    }
    
    public static DataEntryOperatorController getInstance(DataEntryOperatorService service)
     {
        if (instance == null) 
        {
            instance = new DataEntryOperatorController(service);
        }
        return instance;
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
    
     public int getVendorID(String vendorName) 
    {
        return DEOService.getVendorID(vendorName);
    }
    //get all products
    //public boolean addProducts(List<Product> products)
    //{
    //return DEOService.saveAllProducts(products);
//    }
    //insert new product

    public boolean addProducts(int branchID, int vendorID, List<Product> productList) 
    {
        return DEOService.addAllProducts(branchID,vendorID,productList);
    }

    public int getCategoryID(String categoryName)
    {
        return DEOService.getCategoryID(categoryName);
    }

    public List<Product> getAllProducts() 
    {
        return DEOService.getAllProducts();
    }

    public int getSalesPrice(String productName)
    {
        return DEOService.getSalesPrice(productName);
    }

    public boolean saveSales(List<Sale> saleList, int branchID) 
    {
        return DEOService.saveSales(saleList,branchID);
    }

    public int getCurrentQuantityOfProduct(int branchID, String productName) 
    {
        return DEOService.getCurrentQuantityOfProduct(branchID,productName);
    }

    public boolean saveDataIfFlagSet()
    {
         return DEOService.saveDataIfFlagSet();
    }

   

   
}
