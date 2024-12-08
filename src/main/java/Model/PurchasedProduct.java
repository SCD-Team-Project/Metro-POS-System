
package Model;

import java.sql.Timestamp;


public class PurchasedProduct 
{
    int productID;
    int vendorID;
    int numOfItemsPurchased;
    int unitPurchasePrice;
    Timestamp purchaseDate;

    public PurchasedProduct(int productID, int vendorID, int numOfItemsPurchased, int unitPurchasePrice, Timestamp purchaseDate) 
    {
        this.productID = productID;
        this.vendorID = vendorID;
        this.numOfItemsPurchased = numOfItemsPurchased;
        this.unitPurchasePrice = unitPurchasePrice;
        this.purchaseDate = purchaseDate;
    }

    public PurchasedProduct(int productID, int vendorID, int numOfItemsPurchased, int unitPurchasePrice) 
    {
        this.productID = productID;
        this.vendorID = vendorID;
        this.numOfItemsPurchased = numOfItemsPurchased;
        this.unitPurchasePrice = unitPurchasePrice;
    }

    public PurchasedProduct(int productID, int vendorID, int numOfItemsPurchased) 
    {
        this.productID = productID;
        this.vendorID = vendorID;
        this.numOfItemsPurchased = numOfItemsPurchased;
    }

    public int getProductID() 
    {
        return productID;
    }

    public void setProductID(int productID) 
    {
        this.productID = productID;
    }

    public int getVendorID()
    {
        return vendorID;
    }

    public void setVendorID(int vendorID) 
    {
        this.vendorID = vendorID;
    }

    public int getNumOfItemsPurchased() 
    {
        return numOfItemsPurchased;
    }

    public void setNumOfItemsPurchased(int numOfItemsPurchased) {
        this.numOfItemsPurchased = numOfItemsPurchased;
    }

    public int getUnitPurchasePrice() 
    {
        return unitPurchasePrice;
    }

    public void setUnitPurchasePrice(int unitPurchasePrice) 
    {
        this.unitPurchasePrice = unitPurchasePrice;
    }

    public Timestamp getPurchaseDate() 
    {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) 
    {
        this.purchaseDate = purchaseDate;
    }
    
    
    
}
