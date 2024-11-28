
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SuperAdminService
{
    Connection conn=DatabaseConnector.connect();
    
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
    
}
