
package Model.DataEntryOperator;

import Model.Category;
import Model.Product;
import Model.Sale;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataEntryOperatorService 
{
    private Connection conn;
    private static final String FLAG_FILE_PATH = "dataFlag.txt"; // Path to the flag file
    private static final String TEMP_DATA_FILE = "tempData.txt"; 
    
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
        String query="SELECT productID,productName,categoryID,purchasePrice,salesPrice FROM PRODUCT";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery())
        {
            while (rs.next()) 
    {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                int categoryID = rs.getInt("categoryID");
                int purchasePrice = rs.getInt("purchasePrice");
                int salesPrice = rs.getInt("salesPrice");

                Product product = new Product(productID, productName, categoryID, purchasePrice, salesPrice);
                productList.add(product);
    }
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
                        /*if (rowsAffected <= 0) 
                        {
                            System.out.println("Failed to update stock for product: " + product.getProductName());
                            isSuccess = false;
                        }*/
                        //if failed to save it means that it already exists and trigger will update it automatically
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

    public int getSalesPrice(String productName) 
    {
         String query = "SELECT salesPrice FROM PRODUCT WHERE productName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, productName);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("salesPrice");
            }
        }
        } catch (SQLException e) {
        System.out.println("Error retrieving sales price: " + e.getMessage());
        }

        return -1; // Return -1 if product not found or error occurs
    }

    public boolean saveSales(List<Sale> saleList, int branchID)
    {
        ///salelist have: name of product to be sold, quantity sold, unit salesprice
        //it will be saved in the db in the table: sales having columns:
        //salesID, productID,numofitemssold,saleprice,saledate,branchid
        //if not able to store in the db then storing in the file okay?
        
        String insertQuery= "INSERT INTO sales (productID, numofitemssold, saleprice, branchID) VALUES (?, ?, ?, ?)";
        boolean isSuccess=true;
        try(PreparedStatement ps = conn.prepareStatement(insertQuery))
        {
            for(Sale sale: saleList)
            {
                int productId=getProductID(sale.getProductName());
                
                ps.setInt(1, productId);
                ps.setInt(2, sale.getNumOfItemsSold());
                ps.setDouble(3, sale.getSalePrice());
               // ps.setDate(4, Date.valueOf(LocalDate.now()));
                ps.setInt(4, branchID);
                ps.addBatch();
            }
              ps.executeBatch(); 
              
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+ e.getMessage());
            isSuccess=false;
            //saving tofile in case of error
            
        }
        return isSuccess;
    }

    private int getProductID(String productName)
    {
        String query = "SELECT productid FROM PRODUCT WHERE productname = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(query)) 
    {
        pstmt.setString(1, productName);

        try (ResultSet rs = pstmt.executeQuery()) 
        {
            if (rs.next()) 
            {
                 ResultSetMetaData metaData = rs.getMetaData();
                System.out.println("Column name: " + metaData.getColumnName(1));
                return rs.getInt("productid");
            }
        }
    } 
    catch (SQLException e) 
    {
        System.out.println("Error retrieving product ID: " + e.getMessage());
    }

    return -1; // Returning -1 if product not found
    }

    private void saveSalesToFile(List<Sale> saleList, int branchID) 
    {
    String fileName = "TEMP_DATA_FILE";
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
        for (Sale sale : saleList) 
        {
            writer.write(String.format("%s,%d,%d,%s,%d%n",
            sale.getProductName(), sale.getNumOfItemsSold(), sale.getSalePrice(), LocalDate.now(), branchID));
        }
        System.out.println("Sales data saved to file: " + fileName);
    }
    catch (IOException ex) 
    {
       System.out.println("Error saving data into the file too: " + ex.getMessage());
    }
}
 public boolean saveDataIfFlagSet() 
 {
     boolean res=false;
        if (checkFlag())
        {
            // Save data to the database
            res= saveDataFromFile();
            
            // Reset the flag after saving data
            resetFlag();
        }
        return res;
}
  private void resetFlag() 
  {
        try 
        {
            Files.write(Paths.get(FLAG_FILE_PATH), "0".getBytes());
        } 
        catch (IOException e)
        {
            System.out.println("Error resetting flag file: " + e.getMessage());
        }
    }
  private boolean checkFlag() 
  {
        try 
        {
            String flag = new String(Files.readAllBytes(Paths.get(FLAG_FILE_PATH))).trim();
            return "1".equals(flag);
        }
        catch (IOException e)
        {
            System.out.println("Error reading flag file: " + e.getMessage());
            return false;
        }
  }
    private boolean saveDataFromFile() 
 {
     boolean success=true;
        try (BufferedReader br = new BufferedReader(new FileReader(TEMP_DATA_FILE)))
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                // Logic to parse the line and insert it into the database
                // Assume the data in the temp file is in the format "ProductName,Quantity,Price,BranchID"
                String[] data = line.split(",");
                String productName = data[0];
                int quantity = Integer.parseInt(data[1]);
                int salesprice = Integer.parseInt(data[2]);
                //Date date=Date.parse(data[3]);
                int branchid = Integer.parseInt(data[4]);
                
                // Call your method to insert the product into the database
                saveSaletoDB(productName, quantity, salesprice, branchid);  // Assuming salesPrice is same as purchasePrice
                success=true;
            }
        } catch (IOException e) 
        {
            System.out.println("Error reading temporary data file: " + e.getMessage());
            success=false;
        }
        return success;
    }

    private void saveSaletoDB(String productName, int quantity, int salesprice, int branchid)
    {
         String insertQuery = "INSERT INTO sales (productID, numofitemssold, saleprice, branchID) VALUES (?, ?, ?, ?)";
    
    try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
        int productId = getProductID(productName);
        
        if (productId != -1)
        {
            ps.setInt(1, productId);
            ps.setInt(2, quantity);
            ps.setDouble(3, salesprice);
           // ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setInt(4, branchid);
            ps.executeUpdate();
            
        }
        else
        {
            System.out.println("Error: Product not found for " + productName);
        }
    } 
    catch (SQLException e)
    {
        System.out.println("Error saving sale to DB: " + e.getMessage());
    }
    }

    public int getCurrentQuantityOfProduct(int branchID, String productName) 
    {
    String query = "SELECT stockQuantity FROM BRANCH_PRODUCT_STOCK WHERE branchID = ? AND productID = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(query)) 
    {
        pstmt.setInt(1, branchID);
        pstmt.setInt(2, getProductID(productName));

        try (ResultSet rs = pstmt.executeQuery()) 
        {
            if (rs.next()) 
            {
                return rs.getInt("productID");
            }
        }
    } 
    catch (SQLException e) 
    {
        System.out.println("Error retrieving product ID: " + e.getMessage());
    }

    return -1; // Returning -1 if product not found
    }
}
