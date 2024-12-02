
package Model.Cashier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CashierService 
{
    Connection conn;

    public CashierService(Connection conn) 
    {
        this.conn = conn;
    }
    
    public boolean addSale(int productID,int quantitySold,int salePrice)
    {
        String saleQuery="INSERT INTO SALES (productID,numOfItemsSold,salPrice,saleDate) VALUES (?,?,?,CURRENT_TIMESTAMP)";
        String updateStockQuery="UPDATE PRODUCT_STOCK SET stockQuantity= ? WHERE productID=? AND stockQuantity>=?";
        
        try(PreparedStatement saleStmt=conn.prepareStatement(saleQuery);
            PreparedStatement stockStmt=conn.prepareStatement(updateStockQuery))
        {
            stockStmt.setInt(1, quantitySold);
            stockStmt.setInt(2,productID);
            stockStmt.setInt(3, quantitySold);
            int stockRowsAffected=stockStmt.executeUpdate();
            
            if(stockRowsAffected>0)
            {
                saleStmt.setInt(1, productID);
                saleStmt.setInt(2,quantitySold);
                saleStmt.setInt(3,salePrice);
                int saleRowsAffected=saleStmt.executeUpdate();
                return saleRowsAffected>0;
            }
            else
            {
                //in this case it is technically not possible so wahun pe check lag jai ga yk product ik send kr dein gy so that check kr le if the quantity is more than that
                //yk pehle us k liay kuch call kr k check kr le pehle. in 2 chizon ko alag alag kr dein 
                System.out.println("Error: Not enough stock for productID "+ productID);
                //in this case it will be
            }
            
        }
        catch (SQLException e) 
        {
            System.out.println("Error adding sales " +  e.getMessage());
        }
        return false;
    }
}
