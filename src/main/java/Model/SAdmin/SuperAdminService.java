
package Model.SAdmin;

import Model.Branch;
import Model.DatabaseConnector;
import View.ViewReports;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.category.DefaultCategoryDataset;


public class SuperAdminService
{
    Connection conn;

    public SuperAdminService(Connection conn) 
    {
        this.conn=conn;
    }
    
    public SuperAdminService() 
    {
        
    }
    
    public boolean login(String username, String password) 
    {
        String query="SELECT password FROM superadmin WHERE username = ?";
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String storedPassword = rs.getString("password");
                if (storedPassword.equals(password)) 
                { 
                    return true;
                }
            }
        }   
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean insertNewBranch(String branchName,String city,String address,String phoneNumber)
    {
        String query="INSERT INTO BRANCH(branchName,city,address,phoneNumber)"
                + " VALUES (?,?,?,?)";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setString(1, branchName);
            pstmt.setString(2, city);
            pstmt.setString(3, address);
            pstmt.setString(4, phoneNumber);
            
            int rowsAffected=pstmt.executeUpdate();
            
            return rowsAffected>0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public Map<Integer,Branch> getAllBranches()
    {
        Map<Integer,Branch> branchMap=new HashMap<>();
        String query="SELECT * FROM BRANCH";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();)
        {
            while(rs.next())
            {
                int branchID=rs.getInt("branchID");
                String branchName=rs.getString("branchName");
                String city=rs.getString("city");
                String address=rs.getString("address");
                String phoneNumber=rs.getString("phoneNumber");
                int numOfEmployees=rs.getInt("num_of_employees");
                int managerID=rs.getInt("managerID");
                boolean isActive=rs.getBoolean("isActive");
                
                Branch branch=new Branch(branchID,branchName,city,address,phoneNumber,numOfEmployees,managerID,isActive);
                branchMap.put(branchID, branch);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error fetching branches:"+ e.getMessage());
        }
        return branchMap;
    }

    public boolean updateBranchStatus(int branchID,boolean isActive)
    {
        String query="UPDATE BRANCH SET isActive= ? WHERE branchID=?";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setBoolean(1,isActive);
            pstmt.setInt(2,branchID);
            
            int rowsUpdated=pstmt.executeUpdate();
            return rowsUpdated>0;
        }
        catch(SQLException e)
        {
            System.out.println("Error updating branch status: "+e.getMessage());
        }
        return false;
    }

      public boolean deleteBranch(int branchID)
    {
        // First checking if there are employees assigned to this branch
        String checkEmployeesQuery = "SELECT COUNT(*) FROM EMPLOYEE WHERE branchID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(checkEmployeesQuery)) 
        {
            pstmt.setInt(1, branchID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                int employeeCount = rs.getInt(1);
                if (employeeCount > 0)
                {
                    System.out.println("Cannot delete branch. Employees are still assigned to this branch.");
                    return false;
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error checking employees: " + e.getMessage());
            return false;
        }

        // Now proceeding to delete the branch if no employees are found.
        String deleteQuery = "DELETE FROM BRANCH WHERE branchID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) 
        {
            pstmt.setInt(1, branchID);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // If rows were affected, return true (branch deleted).
        } 
        catch (SQLException e) 
        {
            System.out.println("Error deleting branch: " + e.getMessage());
        }

        return false;
    }    
      
     //for update branch if required later
    /*public boolean updateBranch(int branchID,String branchName,String city,String address,String phoneNumber, Boolean isActive)
    {
        StringBuilder queryBuilder=new StringBuilder("UPDATE BRANCH SET ");
        boolean isFirstField=true;
        
        if(branchName!=null &&!branchName.isEmpty())
        {
            queryBuilder.append("branchName=?");
            isFirstField=false;
        }
        
        if (city != null && !city.isEmpty())
         {
            if (!isFirstField) queryBuilder.append(", ");
            queryBuilder.append("city = ?");
            isFirstField = false;
        }
        if (address != null && !address.isEmpty())
        {
            if (!isFirstField) queryBuilder.append(", ");
            queryBuilder.append("address = ?");
            isFirstField = false;
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) 
        {
            if (!isFirstField) queryBuilder.append(", ");
            queryBuilder.append("phoneNumber = ?");
            isFirstField = false;
        }
        if (isActive != null) 
        {
            if (!isFirstField) queryBuilder.append(", ");
            queryBuilder.append("isActive = ?");
        }

        // Add the WHERE clause for the branchID
        queryBuilder.append(" WHERE branchID = ?");

        // Prepare the query string
        String query = queryBuilder.toString();

        try (PreparedStatement pstmt = conn.prepareStatement(query)) 
        {
            int parameterIndex = 1;

            // Set the values for each field dynamically based on the provided parameters
            if (branchName != null && !branchName.isEmpty()) 
            {
                pstmt.setString(parameterIndex++, branchName);
            }
            if (city != null && !city.isEmpty())
            {
                pstmt.setString(parameterIndex++, city);
            }
            if (address != null && !address.isEmpty())
            {
                pstmt.setString(parameterIndex++, address);
            }
            if (phoneNumber != null && !phoneNumber.isEmpty()) 
            {
                pstmt.setString(parameterIndex++, phoneNumber);
            }
            if (isActive != null)
            {
                pstmt.setBoolean(parameterIndex++, isActive);
            }

            // Set the branchID at the end
            pstmt.setInt(parameterIndex, branchID);

            // Execute the update
            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;  // Return true if any rows were updated
        } 
        catch (SQLException e)
        {
            System.out.println("Error updating branch: " + e.getMessage());
        }

        return false;  // Return false if the update failed
    } */

    public DefaultCategoryDataset getDataSetReports(int branchID,String startDate,String endDate) 
    {
         String query = "SELECT " +
                   "    branchID, " +
                   "    SUM(sales.numOfItemsSold * sales.salePrice) AS totalSales, " +
                   "    SUM(purchased_products.numOfItemsPurchased * purchased_products.unitPurchasePrice) AS totalPurchases, " +
                   "    SUM(sales.numOfItemsSold * sales.salePrice) - SUM(purchased_products.numOfItemsPurchased * purchased_products.unitPurchasePrice) AS totalProfit " +
                   "FROM " +
                   "    sales " +
                   "JOIN " +
                   "    purchased_products ON sales.productID = purchased_products.productID AND sales.branchID = purchased_products.branchID " +
                   "WHERE " +
                   "    sales.branchID = ? " +
                   "    AND sales.saleDate BETWEEN ? AND ? " +
                   "GROUP BY " +
                   "    branchID";

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, branchID);
        pstmt.setTimestamp(2, Timestamp.valueOf(startDate + " 00:00:00"));
        pstmt.setTimestamp(3, Timestamp.valueOf(endDate + " 23:59:59"));

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int totalSales = rs.getInt("totalSales");
                int totalPurchases = rs.getInt("totalPurchases");
                int totalProfit = rs.getInt("totalProfit");

                // Add data to the dataset
                dataset.addValue(totalSales, "Sales", "Branch " + branchID);
                dataset.addValue(totalPurchases, "Purchases", "Branch " + branchID);
                dataset.addValue(totalProfit, "Profit", "Branch " + branchID);

                // Update the labels
                //ViewReports.purchasevar.setText(String.valueOf(totalPurchases));
                //ViewReports.salesvar.setText(String.valueOf(totalSales));
                //ViewReports.profitvar.setText(String.valueOf(totalProfit));
            } else {
                System.out.println("No data found for the given criteria.");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error generating report: " + e.getMessage());
    }
    return dataset;
}

    public List<Integer> getAllBranchIDs() 
    {
        List<Integer> branchIDs = new ArrayList<>();
    String query = "SELECT branchID FROM BRANCH";

    try (PreparedStatement pstmt = conn.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            int branchID = rs.getInt("branchID");
            branchIDs.add(branchID);
        }
    } catch (SQLException e) {
        System.out.println("Error fetching branch IDs: " + e.getMessage());
    }

    return branchIDs;
    }
}
