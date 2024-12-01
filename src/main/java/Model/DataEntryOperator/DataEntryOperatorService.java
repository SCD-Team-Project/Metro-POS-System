
package Model.DataEntryOperator;

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

    public List<String> getAllCategories() 
    {
        List<String> categories =new ArrayList<>();
        
        //to be implemented
        return categories;
    }
}
