
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
