
package Model;

public class Product 
{
    int productID;
    String productName;
    int categoryID; //foreign key 
    int stockQuantity;
    int purchasePrice;
    int salesPrice;

    public Product(int productID, String productName, int categoryID, int stockQuantity, int purchasePrice, int salesPrice) 
    {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        if (stockQuantity < 0)
        {
            System.out.println("Stock quantity cannot be negative");;
        }
        else
        {
            this.stockQuantity = stockQuantity;
        }
        if (purchasePrice <= 0 || salesPrice <= 0)
        {
            System.out.println("Prices must be positive");
        }
        else
        {
            this.purchasePrice = purchasePrice;
            this.salesPrice = salesPrice;
        }
        
    }

    public Product(String productName, int categoryID, int purchasePrice, int salesPrice,int quantity) 
    {
        this.productName = productName;
        this.categoryID = categoryID;
        this.purchasePrice = purchasePrice;
        this.salesPrice = salesPrice;
        this.stockQuantity=quantity;
    }
    
    
    public int getProductID()
    {
        return productID;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public int getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }

    public int getStockQuantity() 
    {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) 
    {
        if(stockQuantity>=0)
        {
            this.stockQuantity = stockQuantity;
        }
        else
        {
            System.out.println("Error: Stock quantity cannot be negative");
        }
    }

    public int getPurchasePrice() 
    {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) 
    {
        if(purchasePrice>0)
        {
            this.purchasePrice = purchasePrice;
        }
        else
        {
            System.out.println("PurchasePrice must be postive;");
        }
    }

    public int getSalesPrice() 
    {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) 
    {
        if(salesPrice>0)
        {
            this.salesPrice = salesPrice;
        }
        else
        {
            System.out.println("Sales Price must be positive");
        }
    }
    
    
    
}
