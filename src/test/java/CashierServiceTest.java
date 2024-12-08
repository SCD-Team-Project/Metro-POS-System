/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model.Cashier;

import Model.DataEntryOperator.DataEntryOperatorService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Dell
 */
public class CashierServiceTest {
    
    public CashierServiceTest() {
    }
     @Mock
    private Connection mockConn;
    @Mock
    private PreparedStatement mockSaleStmnt;
    @Mock
    private PreparedStatement mockStockStmnt;
    
    @Mock private ResultSet mockrs;
    
   
    
    private CashierService cService;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        try{
            MockitoAnnotations.openMocks(this);
            cService=new CashierService();
            when(mockConn.prepareStatement(anyString())).thenReturn(mockSaleStmnt);
            when(mockConn.prepareStatement(anyString())).thenReturn(mockStockStmnt);
            
        }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }
    //1 record is added
    @Test
    public void testaddSale(){
        try{
        when(mockStockStmnt.executeUpdate()).thenReturn(1);
        when(mockSaleStmnt.executeUpdate()).thenReturn(1);
        
        int productID=1002;
        int q_Sold=2;
        int salePrice=300;
        
        boolean expected=true;
        boolean actual=cService.addSale(productID,q_Sold,salePrice);
        
        assertEquals(expected,actual);
        
        verify(mockStockStmnt).setInt(1, q_Sold);
        verify(mockStockStmnt).setInt(2, productID);
        verify(mockStockStmnt).setInt(3, q_Sold);
        verify(mockSaleStmnt).executeUpdate();
        verify(mockStockStmnt).executeUpdate();
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }    
    }
    //no updates
     @Test
    public void testaddSale_Failure(){
        try{
        when(mockStockStmnt.executeUpdate()).thenReturn(0);
     //   when(mockSaleStmnt.executeUpdate()).thenReturn(1);
        
        int productID=1002;
        int q_Sold=2;
        int salePrice=300;
        
        boolean expected=false;
        boolean actual=cService.addSale(productID,q_Sold,salePrice);
        
        assertEquals(expected,actual);
        
        verify(mockStockStmnt).setInt(1, q_Sold);
        verify(mockStockStmnt).setInt(2, productID);
        verify(mockStockStmnt).setInt(3, q_Sold);
        verify(mockStockStmnt).executeUpdate();
        verifyNoInteractions(mockSaleStmnt);
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
}
