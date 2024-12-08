/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model.SAdmin;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Model.Branch;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.data.category.DefaultCategoryDataset;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dell
 */
public class SuperAdminServiceTest {
    
   /* public SuperAdminServiceTest() {
    }
    */
    @Mock
    private Connection mockConn;
    @Mock
    private PreparedStatement mockStmnt;
    @Mock private ResultSet mockrs;
    
    private SuperAdminService sAdminService;
    
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
            sAdminService=new SuperAdminService(mockConn);
            when(mockConn.prepareStatement(anyString())).thenReturn(mockStmnt);
            
        }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of login method, of class SuperAdminService.
     */
    @Test
    public void testLoginSuccess() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("correctPassword");
        String username="sAdmin";
        boolean response=sAdminService.login(username,"correctPassword");
        
        assertTrue(response,"Login is successful");
        
        verify(mockStmnt).setString(1,username);
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    @Test
    public void testLogin_IncorrectPass(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("storedPass");
        String username="sAdmin";
        String wrongPass="IncorrectPassword";
        boolean response=sAdminService.login(username,wrongPass);
        
        assertFalse(response,"Login Failed(Incorrect Password)");
        
        //to check the methods were called with the given arguments
        verify(mockStmnt).setString(1,username);
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        
    }
    @Test
    public void testLogin_IncorrectUsername(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(false); //incorrect username== no such user existence
      //  when(mockrs.getString("password")).thenReturn("storedPass");
        String username="wronguser";
        String password="password";
        boolean response=sAdminService.login(username,password);
        
        assertFalse(response,"Login Failed(Incorrect Username)");
        
        verify(mockStmnt).setString(1,username);
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.getMessage();
        }
    }

    /**
     * Test of insertNewBranch method, of class SuperAdminService.
     */
    //new Branch is inserted
    @Test
    public void testInsertNewBranch() {
        
        try
        {
            when(mockStmnt.executeUpdate()).thenReturn(1);
            String branchName="ThokerBranch";
            String city="Lahore";
            String address="xyz";
            String phoneNumber="12345678910";
            boolean expected=true;
            boolean actual=sAdminService.insertNewBranch(branchName, city, address, phoneNumber);
            
           assertEquals(expected,actual);
            
            verify(mockStmnt).setString(1,branchName);
            verify(mockStmnt).setString(2,city);
            verify(mockStmnt).setString(3,address);
            verify(mockStmnt).setString(4,phoneNumber);
            verify(mockStmnt).executeUpdate();
            
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
       
    }
    @Test
   public void testInsertNewBranch_Failure() {
        
        try
        {
            when(mockStmnt.executeUpdate()).thenReturn(0);
            String branchName="ThokerBranch";
            String city="Lahore";
            String address="xyz";
            String phoneNumber="12345678910";
            boolean expected=false;
            boolean actual=sAdminService.insertNewBranch(branchName, city, address, phoneNumber);
            
           assertEquals(expected,actual);
            
            verify(mockStmnt).setString(1,branchName);
            verify(mockStmnt).setString(2,city);
            verify(mockStmnt).setString(3,address);
            verify(mockStmnt).setString(4,phoneNumber);
            verify(mockStmnt).executeUpdate();
            
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    
   }
    /**
     * Test of getAllBranches method, of class SuperAdminService.
     */
   //returns branches
    @Test
    public void testGetAllBranches() {
        try{
         when(mockStmnt.executeQuery()).thenReturn(mockrs);
         when(mockrs.next()).thenReturn(true);
         Map<Integer,Branch> BranchMap=sAdminService.getAllBranches();
         int expected=2;//replace with number of entries in the database
         assertEquals(expected,BranchMap.size());
         
         verify(mockStmnt).executeQuery();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
       
    }
    @Test
    public void testGetAllBranches_Failure(){
        try{
         when(mockStmnt.executeQuery()).thenReturn(mockrs);
         when(mockrs.next()).thenReturn(true);
         Map<Integer,Branch> BranchMap=sAdminService.getAllBranches();
         int expected=0; 
         assertEquals(expected,BranchMap.size());
         
         verify(mockStmnt).executeQuery();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
       
    }
    
    

    /**
     * Test of updateBranchStatus method, of class SuperAdminService.
     */
    //branch status is updated!
    @Test
      public void testUpdateBranchStatus(){
         try
        {
            when(mockStmnt.executeUpdate()).thenReturn(1);
              int branchID=2;
              boolean isActive=false;
            boolean expected=true;
            boolean actual=sAdminService.updateBranchStatus(branchID, isActive);
            
             assertEquals(expected,actual);
            
           verify(mockStmnt).setInt(1, branchID);
           verify(mockStmnt).setBoolean(2, isActive);
            verify(mockStmnt).executeUpdate();
          
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
      }
    
    @Test
    public void testUpdateBranchStatus_Failure(){
         try
        {
            when(mockStmnt.executeUpdate()).thenReturn(0);
            int branchID=2;
            boolean isActive=false;
            boolean expected=false;
            boolean actual=sAdminService.updateBranchStatus(branchID, isActive);
            
             assertEquals(expected,actual);
            
           verify(mockStmnt).setInt(1, branchID);
           verify(mockStmnt).setBoolean(2, isActive);
           verify(mockStmnt).executeUpdate();
          
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of deleteBranch method, of class SuperAdminService.
     */
    //branch will be successfully deleted
    @Test
    public void testDeleteBranch() {
        try{
         when(mockStmnt.executeQuery()).thenReturn(mockrs);
         when(mockrs.next()).thenReturn(true);
         when(mockrs.getInt(1)).thenReturn(0);
         
         when(mockStmnt.executeUpdate()).thenReturn(1);
         
         int BranchID=2;
         boolean expected=true;
         boolean actual=sAdminService.deleteBranch(BranchID);
         
         assertEquals(expected,actual);
        
         verify(mockStmnt).setInt(1, BranchID);
         verify(mockStmnt).executeUpdate();
       
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
       
    }
    //employees are still assigned to the branch
    @Test 
    public void testDeleteBranch_Failure(){
         try{
         when(mockStmnt.executeQuery()).thenReturn(mockrs);
         when(mockrs.next()).thenReturn(true);
         when(mockrs.getInt(1)).thenReturn(3);
         
         int BranchID=2;
         boolean expected=false;
         boolean actual=sAdminService.deleteBranch(BranchID);
         
         assertEquals(expected,actual);
        
         verify(mockStmnt).setInt(1, BranchID);
         verify(mockStmnt).executeUpdate();
       
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of login method, of class SuperAdminService.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        SuperAdminService instance = new SuperAdminService();
        boolean expResult = false;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataSetReports method, of class SuperAdminService.
     */
    @Test
    public void testGetDataSetReports() {
        System.out.println("getDataSetReports");
        int branchID = 0;
        String startDate = "";
        String endDate = "";
        Object = null;
        SuperAdminService instance = new SuperAdminService();
        DefaultCategoryDataset expResult = null;
        DefaultCategoryDataset result = instance.getDataSetReports(branchID, startDate, endDate, <error>);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
