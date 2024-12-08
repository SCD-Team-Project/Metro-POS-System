
package Model.DataEntryOperator;

import Model.Category;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataEntryOperatorService 
{
    private Connection conn;
    
    public DataEntryOperatorService(Connection conn)
    {
        this.conn=conn;
    }
    
    public DataEntryOperatorService()
    {
        //this.conn=conn;
    }
    
    public boolean addVendor(String vendorName,String phoneNumber,String email,String address)
    {
        String query="INSERT INTO VENDOR (vendorName,phoneNumber,email,address) VALUES (?,?,?,?)";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setString(1, vendorName);
            pstmt.setString(2, phoneNumber);
            pstmt.setString(3, email);
            pstmt.setString(4, address);
            
            int rowsAffected=pstmt.executeUpdate();
            
            return rowsAffected>0;
        } 
        catch (SQLException ex)
        {
            System.out.println("Error adding vendor "+ex.getMessage());
        }
        return false;
    }
    
    public List<String> getAllVendorNames()
    {
        List<String> vendorNames=new ArrayList<>();
        String query="SELECT vendorName FROM VENDOR";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery())
        {
            while(rs.next())
            {
                vendorNames.add(rs.getString("vendorName"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error while retrieving vendor names: "+e.getMessage());
        }
        return vendorNames;
    }
     public int getVendorID(String vendorName)
    {
        String query = "SELECT vendorID FROM VENDOR WHERE vendorName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setString(1, vendorName);

            try (ResultSet rs = pstmt.executeQuery()) 
            {
                if (rs.next())
                {
                    return rs.getInt("vendorID");
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error retrieving vendor ID: " + e.getMessage());
        }

        return -1; // Returning -1 if vendor not found
    }

    //change this and add the categoryID with it too kindly //doneee
    public List<Category> getAllCategories() 
    {
        List<Category> categories =new ArrayList<>();
        
        String query="SELECT categoryID,categoryName from CATEGORY";
        try(PreparedStatement pstmt=conn.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery())
        {
            while(rs.next())
            {
                categories.add(new Category(rs.getInt("categoryID"),rs.getString("categoryName")));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error fetching categories: "+ e.getMessage());
        }
        return categories;
    }
     public int getCategoryID(String categoryName)
    {
        String query = "SELECT categoryID FROM CATEGORY WHERE categoryName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setString(1, categoryName);

            try (ResultSet rs = pstmt.executeQuery()) 
            {
                if (rs.next()) 
                {
                    return rs.getInt("categoryID");
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error retrieving category ID: " + e.getMessage());
        }

        return -1; // Returning -1 if category not found
    }

    
    public boolean addCategory(String categoryName)
    {
        String query="INSERT INTO CATEGORY (categoryName) VALUES (?)";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setString(1, categoryName);
            
            int rowsAffected=pstmt.executeUpdate();
            return rowsAffected>0;
        }
        catch(SQLException e)
        {
            System.out.println("Error adding new category: "+e.getMessage());
        }
        return false;
    }
    
    public List<String> getAllProductNames()
    {
        List<String> productNames=new ArrayList<>();
        String  query="SELECT productName FROM PRODUCT";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery())
        {
            while(rs.next())
            {
                productNames.add(rs.getString("productName"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error retrieving product names: "+ e.getMessage());
        }
        return productNames;
    }
    
    public List<Product> getAllProducts()
    {
        List<Product> productList=new ArrayList<>();
        String query="SELECT productID,productName,categoryID,stockQuantity,purchasePrice,salesPrice FROM PRODUCT";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery())
        {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                int categoryID = rs.getInt("categoryID");
                int stockQuantity = rs.getInt("stockQuantity");
                int purchasePrice = rs.getInt("purchasePrice");
                int salesPrice = rs.getInt("salesPrice");

                Product product = new Product(productID, productName, categoryID, stockQuantity, purchasePrice, salesPrice);
                productList.add(product);
        } 
        catch (SQLException e)
        {
            System.out.println("Error retrieving products: " + e.getMessage());        
        }
        
        return productList;
    }
    
    public boolean addProduct(String productName,int categoryID, int stockQuantity, int purchasePrice, int salesPrice)
    {
        String query = "INSERT INTO PRODUCT (productName, categoryID, stockQuantity, purchasePrice, salesPrice) VALUES (?, ?, ?, ?, ?)";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setString(1, productName);
            pstmt.setInt(2, categoryID);
            pstmt.setInt(3, stockQuantity);
            pstmt.setInt(4, purchasePrice);
            pstmt.setInt(5, salesPrice);
        
            int rowsAffected=pstmt.executeUpdate();
            return rowsAffected>0;
        }
        catch(SQLException e)
        {
            System.out.println("Error while adding new product: "+ e.getMessage());
        }
        return false;
    }
    
    /*public boolean addAllProducts(int branchID, int vendorID, List<Product> productList) 
    {
         boolean isSuccess = true;

        String saveProductQuery = "INSERT INTO PRODUCT (productName, categoryID, purchasePrice, salesPrice) " +
                              "VALUES (?, ?, ?, ?) " +
                              "ON CONFLICT (productName) " +
                              "DO UPDATE SET " +
                              "purchasePrice = EXCLUDED.purchasePrice, " +
                              "salesPrice = EXCLUDED.salesPrice " +
                              "RETURNING productID";

        String purchaseProductQuery = "INSERT INTO PURCHASED_PRODUCTS (productID, vendorID, numOfItemsPurchased, unitPurchasePrice, branchID) " +
                                    "VALUES (?, ?, ?, ?, ?)";

         String updateStockQuery = "INSERT INTO BRANCH_PRODUCT_STOCK (branchID, productID, stockQuantity) " +
                              "VALUES (?, ?, ?) " +
                              "ON CONFLICT (branchID, productID) " +
                              "DO UPDATE SET stockQuantity = BRANCH_PRODUCT_STOCK.stockQuantity + EXCLUDED.stockQuantity";
        try
        {
            for (Product product : productList) 
            {
                int productID = -1;

                // Step 1: Insert or update product (if it already exists) and get productID in return
                try (PreparedStatement saveProductStmt = conn.prepareStatement(saveProductQuery)) 
                {
                    saveProductStmt.setString(1, product.getProductName());
                    saveProductStmt.setInt(2, product.getCategoryID());
                    saveProductStmt.setInt(3, product.getPurchasePrice());
                    saveProductStmt.setInt(4, product.getSalesPrice());

                    try (ResultSet rs = saveProductStmt.executeQuery()) 
                    {
                        if (rs.next()) 
                        {
                            productID = rs.getInt("productID");
                        }
                    }
                }

                if (productID == -1)
                {
                    System.out.println("Failed to save or retrieve product ID for product: " + product.getProductName());
                    isSuccess = false;
                    continue;
                }

                // Step 2: Inserting into PURCHASED_PRODUCTS (trigger will handle stock update)
                try (PreparedStatement purchaseProductStmt = conn.prepareStatement(purchaseProductQuery)) 
                {
                    purchaseProductStmt.setInt(1, productID);
                    purchaseProductStmt.setInt(2, vendorID);
                    purchaseProductStmt.setInt(3, product.getStockQuantity());
                    purchaseProductStmt.setInt(4, product.getPurchasePrice());
                    purchaseProductStmt.setInt(5, branchID);

                    int rowsAffected = purchaseProductStmt.executeUpdate();
                    if (rowsAffected <= 0)
                    {
                        System.out.println("Failed to insert purchase details for product: " + product.getProductName());
                        isSuccess = false;
                    }
                }
                
                // Step 3: Insert or update stock in BRANCH_PRODUCT_STOCK
                try (PreparedStatement updateStockStmt = conn.prepareStatement(updateStockQuery))
                {
                updateStockStmt.setInt(1, branchID);
                updateStockStmt.setInt(2, productID);
                updateStockStmt.setInt(3, product.getStockQuantity());

                int rowsAffected = updateStockStmt.executeUpdate();
                if (rowsAffected <= 0) {
                    System.out.println("Failed to update stock for product: " + product.getProductName());
                    isSuccess = false;
                }
            }
        } 
        catch (SQLException e)
        {
            System.out.println("Error in addAllProducts: " + e.getMessage());
            isSuccess = false;
        }

        return isSuccess;
    }*/
        public boolean addAllProducts(int branchID, int vendorID, List<Product> productList) 
        {
            boolean isSuccess = true;

    String saveProductQuery = "INSERT INTO PRODUCT (productName, categoryID, purchasePrice, salesPrice) " +
                              "VALUES (?, ?, ?, ?) " +
                              "ON CONFLICT (productName) " +
                              "DO UPDATE SET " +
                              "purchasePrice = EXCLUDED.purchasePrice, " +
                              "salesPrice = EXCLUDED.salesPrice " +
                              "RETURNING productID";

    String purchaseProductQuery = "INSERT INTO PURCHASED_PRODUCTS (productID, vendorID, numOfItemsPurchased, unitPurchasePrice, branchID) " +
                                  "VALUES (?, ?, ?, ?, ?)";

    String updateStockQuery = "INSERT INTO BRANCH_PRODUCT_STOCK (branchID, productID, stockQuantity) " +
                              "VALUES (?, ?, ?) " +
                              "ON CONFLICT (branchID, productID) DO NOTHING";

            try 
            {
                for (Product product : productList) 
                {
                    int productID = -1;

                    // Step 1: Insert or update product and get productID
                    try (PreparedStatement saveProductStmt = conn.prepareStatement(saveProductQuery))
                    {
                        saveProductStmt.setString(1, product.getProductName());
                        saveProductStmt.setInt(2, product.getCategoryID());
                        saveProductStmt.setInt(3, product.getPurchasePrice());
                        saveProductStmt.setInt(4, product.getSalesPrice());

                        try (ResultSet rs = saveProductStmt.executeQuery())
                        {
                            if (rs.next()) 
                            {
                                productID = rs.getInt("productID");
                            }
                        }
                    }

                    if (productID == -1) 
                    {
                        System.out.println("Failed to save or retrieve product ID for product: " + product.getProductName());
                        isSuccess = false;
                        continue;
                    }

                    // Step 2: Insert into PURCHASED_PRODUCTS
                    try (PreparedStatement purchaseProductStmt = conn.prepareStatement(purchaseProductQuery)) 
                    {
                        purchaseProductStmt.setInt(1, productID);
                        purchaseProductStmt.setInt(2, vendorID);
                        purchaseProductStmt.setInt(3, product.getStockQuantity());
                        purchaseProductStmt.setInt(4, product.getPurchasePrice());
                        purchaseProductStmt.setInt(5, branchID);

                        int rowsAffected = purchaseProductStmt.executeUpdate();
                        if (rowsAffected <= 0) 
                        {
                            System.out.println("Failed to insert purchase details for product: " + product.getProductName());
                            isSuccess = false;
                        }
                    }

                    // Step 3: Insert or update stock in BRANCH_PRODUCT_STOCK
                    try (PreparedStatement updateStockStmt = conn.prepareStatement(updateStockQuery)) 
                    {
                        updateStockStmt.setInt(1, branchID);
                        updateStockStmt.setInt(2, productID);
                        updateStockStmt.setInt(3, product.getStockQuantity());

                        int rowsAffected = updateStockStmt.executeUpdate();
                        if (rowsAffected <= 0) 
                        {
                            System.out.println("Failed to update stock for product: " + product.getProductName());
                            isSuccess = false;
                        }
                    }
                }
            } 
            catch (SQLException e) 
            {
                System.out.println("Error in addAllProducts: " + e.getMessage());
                isSuccess = false;
            }

            return isSuccess;
        }

    
    
    //look into it if the product already exists yk
    //to be modified yk adding the stock thingyy too
    //no instead I would recommend settling for a trigger
    //trigger socho and go with it okayy!??
    public boolean addPurchasedProduct(String productName,int categoryID,int vendorID,int quantity,int uniPurchasePrice)
    {
        String productQuery="INSERT INTO PRODUCT (productName,categoryID) VALUES (?,?) RETURNING productID";
        String purchasedQuery="INSERT INTO PURCHASED_PRODUCTS (productID,vendorID,numOfItemsPurchased,unitPurchasePrice) VALUES (?,?,?,?)";
        int productID=-1;
        
        try(PreparedStatement productStmt=conn.prepareStatement(productQuery);
                PreparedStatement purchasedStmt=conn.prepareStatement(purchasedQuery))
        {
            productStmt.setString(1, productName);
            productStmt.setInt(2, categoryID);
            try(ResultSet rs=productStmt.executeQuery())
            {
                if(rs.next())
                {
                    productID=rs.getInt("productID");
                }
                
                if(productID>0)
                {
                    purchasedStmt.setInt(1, productID);
                    purchasedStmt.setInt(2, productID);
                    purchasedStmt.setInt(3, productID);
                    purchasedStmt.setInt(4, productID);
                    
                    int rowsAffected= purchasedStmt.executeUpdate();
                    return rowsAffected>0;
                }
                
            }
             catch(SQLException e)
            {
                System.out.println("Error adding purchased product: "+ e.getMessage());   
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error adding purchased product: "+ e.getMessage());   
        }
        return false;
    }
    
    
    //now for sales function aka minus the product quantity from stock when a new sale is done and add it into the new sale button okayyy!???

}
