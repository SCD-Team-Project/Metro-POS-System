
package Model;

import java.sql.Timestamp;

public class Sale 
{
    int salesID;
    int productID;
    int numOfItemsSold;
    int salePrice;
    Timestamp saleDate;

    public Sale(int salesID, int productID, int numOfItemsSold, int salePrice) 
    {
        this.salesID = salesID;
        this.productID = productID;
        this.numOfItemsSold = numOfItemsSold;
        this.salePrice = salePrice;
    }

    public Sale(int salesID, int productID, int numOfItemsSold, int salePrice, Timestamp saleDate) 
    {
        this.salesID = salesID;
        this.productID = productID;
        this.numOfItemsSold = numOfItemsSold;
        this.salePrice = salePrice;
        this.saleDate = saleDate;
    }

    public int getSalesID() 
    {
        return salesID;
    }

    public void setSalesID(int salesID) 
    {
        this.salesID = salesID;
    }

    public int getProductID() 
    {
        return productID;
    }

    public void setProductID(int productID) 
    {
        this.productID = productID;
    }

    public int getNumOfItemsSold() 
    {
        return numOfItemsSold;
    }

    public void setNumOfItemsSold(int numOfItemsSold) 
    {
        this.numOfItemsSold = numOfItemsSold;
    }

    public int getSalePrice() 
    {
        return salePrice;
    }

    public void setSalePrice(int salePrice) 
    {
        this.salePrice = salePrice;
    }

    public Timestamp getSaleDate()
    {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) 
    {
        this.saleDate = saleDate;
    }
    
    
}
