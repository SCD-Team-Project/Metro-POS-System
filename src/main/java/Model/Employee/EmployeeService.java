
package Model.Employee;

import Model.EmployeeType;
import Model.PasswordUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;


public class EmployeeService 
{
    Connection conn;

    public EmployeeService(Connection conn) 
    {
        this.conn=conn;
    }
    public EmployeeService() 
    {
       
    }
    
    public int addEmployee(String email,String name,EmployeeType type,int branchID,String phone,String address, int salary)
    {
        String encryptedPassword=PasswordUtils.getInitialPassword();
        
        String query="INSERT INTO EMPLOYEE(employeeEmail,password,employeeName,type,branchID,phoneNumber,address,salary)"
                +"VALUES (?,?,?,?,?,?,?,?) RETURNING employeeID";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setString(1, email);
            pstmt.setString(2, encryptedPassword);
            pstmt.setString(3, name);
            pstmt.setString(4, type.getType());
            pstmt.setInt(5, branchID);
            pstmt.setString(6, phone);
            pstmt.setString(7, address);
            pstmt.setInt(8, salary);
            
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                return rs.getInt("employeeID");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    
    public int verifyLogin(int employeeID,String enteredPassword,EmployeeType type)
    {
        String query="SELECT password FROM EMPLOYEE WHERE employeeID=? AND type=?";
        
        try(PreparedStatement pstmt=conn.prepareStatement(query))
        {
            pstmt.setInt(1,employeeID);
            pstmt.setString(2, type.getType());
            
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                
                String storedPassword=rs.getString("password");
                if(BCrypt.checkpw(enteredPassword, storedPassword))
                {
                    if(BCrypt.checkpw(enteredPassword, PasswordUtils.getInitialPassword()))
                    {
                        //if it is logged in and the login is 1st time then 0 will be returned
                        return 0;
                    }
                    else
                    {
                        //logged in but not first time log in
                        return 1;
                    }
                }
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        return -1; //not able to login
    }
    
    //changing password
    public boolean changePassword(int employeeID,EmployeeType type,String newPassword)
    {
        //if the password is te same as previous one then error
        if(newPassword.equals(PasswordUtils.getInitialPassword()))
        {
            return false; //new password cannot be the previous one
        }
        else
        {
            String encryptedPassword=BCrypt.hashpw(newPassword, BCrypt.gensalt());
            //query thingyy
            String query="UPDATE EMPLOYEE SET password=? where employeeID=? AND type=?";
            
            try(PreparedStatement pstmt=conn.prepareStatement(query))
            {
                pstmt.setString(1, encryptedPassword);
                pstmt.setInt(2, employeeID);
                pstmt.setString(3, type.getType());
                
                int result=pstmt.executeUpdate();
                return result>0;
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
            return false;
        }
    }
    
    public boolean deleteEmployee(int employeeID,EmployeeType type) 
    {
        // Query to delete the employee based on the employeeID
        String query = "DELETE FROM EMPLOYEE WHERE employeeID = ? AND type=?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, employeeID);
            pstmt.setString(2, type.getType());

            int rowsAffected = pstmt.executeUpdate();

            // Return true if the employee was deleted, false if not
            return rowsAffected > 0;
        } 
        catch (SQLException e) 
        {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
        return false; // Return false if the deletion fails
    }

    public int getBranchID(int employeeID,EmployeeType type) 
    {
        String query="SELECT branchID FROM EMPLOYEE WHERE employeeID=? AND type=?";
        
        
         try (PreparedStatement pstmt = conn.prepareStatement(query))
         {
            pstmt.setInt(1, employeeID);
            pstmt.setString(2, type.getType());
           ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                int branchID=rs.getInt("branchID");
                return branchID;
            }
         }
         catch(SQLException e) 
        {
            System.out.println("Error fetching branchID : " + e.getMessage());
        }
         return 0; //if no branchID is found
    }
    
}
