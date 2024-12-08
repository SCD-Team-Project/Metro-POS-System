
package Model;

import java.sql.Timestamp;


//no actual need of this class tbh. remove the lastUpdated and transfer the last 2 things in the product class kindlyyyy
//and add 2 triggers on "PurchasedProduct" and "Sales"or incrementing/decrementing the quantity
public class ProductStock 
{
    int productID;
    int stockQuantity;
    int purchasePrice;
    Timestamp lastUpdated;  //ig I should take it as last updated waladata as a report BUTT for product quantity phir yeh nai chahiay ho ga

    public ProductStock(int productID, int stockQuantity, int purchasePrice) 
    {
        this.productID = productID;
        this.stockQuantity = stockQuantity;
        this.purchasePrice = purchasePrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ProductStock(int productID, int stockQuantity, int purchasePrice, Timestamp lastUpdated) 
    {
        this.productID = productID;
        this.stockQuantity = stockQuantity;
        this.purchasePrice = purchasePrice;
        this.lastUpdated = lastUpdated;
    }
    
    
}
