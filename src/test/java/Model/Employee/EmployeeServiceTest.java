/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model.Employee;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import Model.EmployeeType;
import Model.PasswordUtils;
//import Model.SAdmin.SuperAdminService;
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
import org.mindrot.jbcrypt.BCrypt;
        
     

/**
 *
 * @author Dell
 */
public class EmployeeServiceTest {
    
   /* public EmployeeServiceTest() {
    }*/
    
    @Mock
    private Connection mockConn;
    @Mock
    private PreparedStatement mockStmnt;
    @Mock private ResultSet mockrs;
    
    private EmployeeService empService;
    
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
            empService=new EmployeeService(mockConn);
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
     * Test of addEmployee method, of class EmployeeService.
     */
    @Test
    public void testAddEmployee_BranchManager() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        String email="Testemail@gmail.com";
        String name="TestName";
        EmployeeType type=EmployeeType.BRANCH_MANAGER; //agar ye cashier hai deo ke liye bhi karna hai toh isko copy paste karke two more functions bana ke wo type change  kardo
        int branchID=1001;
        String phone="12345678902";
        String address="Street 123 house number1";
        int salary=3000;
        
        int expected=1004; //adjust this value according to the DB state
        int actual=empService.addEmployee(email, name, type, branchID, phone, address, salary);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, email);
        verify(mockStmnt).setString(2, name);
        verify(mockStmnt).setString(3, type.getType());
        verify(mockStmnt).setInt(4, branchID);
        verify(mockStmnt).setString(5, phone);
        verify(mockStmnt).setString(6, address);
        verify(mockStmnt).setInt(7, salary);
        verify(mockStmnt).executeQuery();
      
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
      
    }
    @Test
    public void testAddEmployee_Cashier() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        String email="Testemail@gmail.com";
        String name="TestName";
        EmployeeType type=EmployeeType.CASHIER; //agar ye cashier hai deo ke liye bhi karna hai toh isko copy paste karke two more functions bana ke wo type change  kardo
        int branchID=1001;
        String phone="12345678902";
        String address="Street 123 house number1";
        int salary=3000;
        
        int expected=1004; //adjust this value according to the DB state
        int actual=empService.addEmployee(email, name, type, branchID, phone, address, salary);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, email);
        verify(mockStmnt).setString(2, name);
        verify(mockStmnt).setString(3, type.getType());
        verify(mockStmnt).setInt(4, branchID);
        verify(mockStmnt).setString(5, phone);
        verify(mockStmnt).setString(6, address);
        verify(mockStmnt).setInt(7, salary);
        verify(mockStmnt).executeQuery();
      
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
      
    }
    @Test
    public void testAddEmployee_DEO() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        String email="Testemail@gmail.com";
        String name="TestName";
        EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR; //agar ye cashier hai deo ke liye bhi karna hai toh isko copy paste karke two more functions bana ke wo type change  kardo
        int branchID=1001;
        String phone="12345678902";
        String address="Street 123 house number1";
        int salary=3000;
        
        int expected=1004; //adjust this value according to the DB state
        int actual=empService.addEmployee(email, name, type, branchID, phone, address, salary);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, email);
        verify(mockStmnt).setString(2, name);
        verify(mockStmnt).setString(3, type.getType());
        verify(mockStmnt).setInt(4, branchID);
        verify(mockStmnt).setString(5, phone);
        verify(mockStmnt).setString(6, address);
        verify(mockStmnt).setInt(7, salary);
        verify(mockStmnt).executeQuery();
      
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
      
    }
    @Test
    public void testaddEmployee_Failure_BranchManager(){ //returns 0 value i-e does not add anything
          try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(false);
        String email="Testemail@gmail.com";
        String name="TestName";
        EmployeeType type=EmployeeType.BRANCH_MANAGER;
        int branchID=1001;
        String phone="12345678902";
        String address="Street 123 house number1";
        int salary=3000;
        
        int expected=0; //adjust this value according to the DB state
        int actual=empService.addEmployee(email, name, type, branchID, phone, address, salary);
        
        assertEquals(expected,actual);
        
      /*  verify(mockStmnt).setString(1, email);
        verify(mockStmnt).setString(2, name);
        verify(mockStmnt).setString(3, type.getType());
        verify(mockStmnt).setInt(4, branchID);
        verify(mockStmnt).setString(5, phone);
        verify(mockStmnt).setString(6, address);
        verify(mockStmnt).setInt(7, salary);*/
        verify(mockStmnt).executeQuery();
      
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    @Test
     public void testaddEmployee_Failure_Cashier(){ //returns 0 value i-e does not add anything
          try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(false);
        String email="Testemail@gmail.com";
        String name="TestName";
        EmployeeType type=EmployeeType.CASHIER;
        int branchID=1001;
        String phone="12345678902";
        String address="Street 123 house number1";
        int salary=3000;
        
        int expected=0; //adjust this value according to the DB state
        int actual=empService.addEmployee(email, name, type, branchID, phone, address, salary);
        
        assertEquals(expected,actual);
        
      /*  verify(mockStmnt).setString(1, email);
        verify(mockStmnt).setString(2, name);
        verify(mockStmnt).setString(3, type.getType());
        verify(mockStmnt).setInt(4, branchID);
        verify(mockStmnt).setString(5, phone);
        verify(mockStmnt).setString(6, address);
        verify(mockStmnt).setInt(7, salary);*/
        verify(mockStmnt).executeQuery();
      
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
     @Test
     public void testaddEmployee_Failure_DEO(){ //returns 0 value i-e does not add anything
          try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(false);
        String email="Testemail@gmail.com";
        String name="TestName";
        EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
        int branchID=1001;
        String phone="12345678902";
        String address="Street 123 house number1";
        int salary=3000;
        
        int expected=0; //adjust this value according to the DB state
        int actual=empService.addEmployee(email, name, type, branchID, phone, address, salary);
        
        assertEquals(expected,actual);
        
      /*  verify(mockStmnt).setString(1, email);
        verify(mockStmnt).setString(2, name);
        verify(mockStmnt).setString(3, type.getType());
        verify(mockStmnt).setInt(4, branchID);
        verify(mockStmnt).setString(5, phone);
        verify(mockStmnt).setString(6, address);
        verify(mockStmnt).setInt(7, salary);*/
        verify(mockStmnt).executeQuery();
      
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of verifyLogin method, of class EmployeeService.
     */
    //First Time login
    @Test
    public void testVerifyLogin_BranchManager() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(true); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(true);
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.BRANCH_MANAGER;
        
        int expected=0;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setInt(1, empID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    @Test
    public void testVerifyLogin_Cashier() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(true); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(true);
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.CASHIER;
        
        int expected=0;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setInt(1, empID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    @Test
    public void testVerifyLogin_DEO() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(true); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(true);
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
        
        int expected=0;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setInt(1, empID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    //
    @Test
    public void testverifyLogin_noFirstLogin_branchManager(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(true); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(false);
        
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.BRANCH_MANAGER;
        
        int expected=1;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setInt(1, empID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
     @Test
    public void testverifyLogin_noFirstLogin_Cashier(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(true); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(false);
        
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.CASHIER;
        
        int expected=1;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setInt(1, empID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
     @Test
    public void testverifyLogin_noFirstLogin_DEO(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(true); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(false);
        
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
        
        int expected=1;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setInt(1, empID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    @Test
     public void testverifyLogin_unable_BranchManager(){
             
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(false); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(false);
        
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.BRANCH_MANAGER;
        
        int expected=-1;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
       // verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
     @Test
     public void testverifyLogin_unable_Cashier(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(false); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(false);
        
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.CASHIER;
        
        int expected=-1;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
       // verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
     
     @Test
     public void testverifyLogin_unable_DEO(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getString("password")).thenReturn("$2a$10$hashedPassword");
        when(BCrypt.checkpw(anyString(),anyString())).thenReturn(false); 
        when(BCrypt.checkpw(anyString(),PasswordUtils.getInitialPassword() )).thenReturn(false);
        
        
        int empID=1002;
        String pass="testPassword";
        EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
        
        int expected=-1;
        int actual=empService.verifyLogin(empID, pass, type);
        
        assertEquals(expected,actual);
        
       // verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of changePassword method, of class EmployeeService.
     */
    //password will be changed
    @Test
    public void testChangePassword_Cashier() {
        try{
       when(mockStmnt.executeUpdate()).thenReturn(1);
       
       int empID=1002;
       EmployeeType type=EmployeeType.CASHIER;
       String updatedPassword="testnewPassword";
       
       boolean expected=true;
       boolean actual=empService.changePassword(empID, type, updatedPassword);
       
       assertEquals(expected,actual);
       
       verify(mockStmnt).setString(1, anyString());
       verify(mockStmnt).setInt(2,empID );
       verify(mockStmnt).setString(3, type.getType());
       
       verify(mockStmnt).executeUpdate();
      
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
      @Test
    public void testChangePassword_BranchManager() {
        try{
       when(mockStmnt.executeUpdate()).thenReturn(1);
       
       int empID=1002;
       EmployeeType type=EmployeeType.BRANCH_MANAGER;
       String updatedPassword="testnewPassword";
       
       boolean expected=true;
       boolean actual=empService.changePassword(empID, type, updatedPassword);
       
       assertEquals(expected,actual);
       
       verify(mockStmnt).setString(1, anyString());
       verify(mockStmnt).setInt(2,empID );
       verify(mockStmnt).setString(3, type.getType());
       
       verify(mockStmnt).executeUpdate();
      
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
      @Test
    public void testChangePassword_DEO() {
        try{
       when(mockStmnt.executeUpdate()).thenReturn(1);
       
       int empID=1002;
       EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
       String updatedPassword="testnewPassword";
       
       boolean expected=true;
       boolean actual=empService.changePassword(empID, type, updatedPassword);
       
       assertEquals(expected,actual);
       
       verify(mockStmnt).setString(1, anyString());
       verify(mockStmnt).setInt(2,empID );
       verify(mockStmnt).setString(3, type.getType());
       
       verify(mockStmnt).executeUpdate();
      
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    @Test
    public void testChangePassword_Failure_Cashier(){
         try{
             
      when(mockStmnt.executeUpdate()).thenReturn(0);
       
       String oldPassword=PasswordUtils.getInitialPassword();
       
       int empID=1002;
       EmployeeType type=EmployeeType.CASHIER;
       String updatedPassword=oldPassword;
       
       boolean expected=false;
       boolean actual=empService.changePassword(empID, type, updatedPassword);
       
       assertEquals(expected,actual);
       
      verifyNoInteractions(mockStmnt);
      
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testChangePassword_Failure_BranchManager(){
         try{
             
      when(mockStmnt.executeUpdate()).thenReturn(0);
       
       String oldPassword=PasswordUtils.getInitialPassword();
       
       int empID=1002;
       EmployeeType type=EmployeeType.BRANCH_MANAGER;
       String updatedPassword=oldPassword;
       
       boolean expected=false;
       boolean actual=empService.changePassword(empID, type, updatedPassword);
       
       assertEquals(expected,actual);
       
      verifyNoInteractions(mockStmnt);
      
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testChangePassword_Failure_DEO(){
         try{
             
      when(mockStmnt.executeUpdate()).thenReturn(0);
       
       String oldPassword=PasswordUtils.getInitialPassword();
       
       int empID=1002;
       EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
       String updatedPassword=oldPassword;
       
       boolean expected=false;
       boolean actual=empService.changePassword(empID, type, updatedPassword);
       
       assertEquals(expected,actual);
       
      verifyNoInteractions(mockStmnt);
      
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of deleteEmployee method, of class EmployeeService.
     */
    //delete the employee
    @Test
    public void testDeleteEmployee_Cashier() {
        try{
        when(mockStmnt.executeUpdate()).thenReturn(1);
        int employeeID=1002;
        EmployeeType type=EmployeeType.CASHIER;
        boolean expected=true;
        boolean actual=empService.deleteEmployee(employeeID, type);
        
        assertEquals(expected,actual);
       
      
        verify(mockStmnt).setInt(1, employeeID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeUpdate();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    @Test
    public void testDeleteEmployee_BranchManager() {
        try{
        when(mockStmnt.executeUpdate()).thenReturn(1);
        int employeeID=1002;
        EmployeeType type=EmployeeType.BRANCH_MANAGER;
        boolean expected=true;
        boolean actual=empService.deleteEmployee(employeeID, type);
        
        assertEquals(expected,actual);
       
      
        verify(mockStmnt).setInt(1, employeeID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeUpdate();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    @Test
    public void testDeleteEmployee_DEO() {
        try{
        when(mockStmnt.executeUpdate()).thenReturn(1);
        int employeeID=1002;
        EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
        boolean expected=true;
        boolean actual=empService.deleteEmployee(employeeID, type);
        
        assertEquals(expected,actual);
       
      
        verify(mockStmnt).setInt(1, employeeID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeUpdate();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    @Test
    public void testDeleteEmployee_Failure_Cashier(){
          try{
        when(mockStmnt.executeUpdate()).thenReturn(0);
        int employeeID=1002;
        EmployeeType type=EmployeeType.CASHIER;
        boolean expected=false;
        boolean actual=empService.deleteEmployee(employeeID, type);
        
        assertEquals(expected,actual);
       
      
        verify(mockStmnt).setInt(1, employeeID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeUpdate();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
     @Test
    public void testDeleteEmployee_Failure_BranchManager(){
          try{
        when(mockStmnt.executeUpdate()).thenReturn(0);
        int employeeID=1002;
        EmployeeType type=EmployeeType.BRANCH_MANAGER;
        boolean expected=false;
        boolean actual=empService.deleteEmployee(employeeID, type);
        
        assertEquals(expected,actual);
       
      
        verify(mockStmnt).setInt(1, employeeID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeUpdate();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
     @Test
    public void testDeleteEmployee_Failure_DEO(){
          try{
        when(mockStmnt.executeUpdate()).thenReturn(0);
        int employeeID=1002;
        EmployeeType type=EmployeeType.DATA_ENTRY_OPERATOR;
        boolean expected=false;
        boolean actual=empService.deleteEmployee(employeeID, type);
        
        assertEquals(expected,actual);
       
      
        verify(mockStmnt).setInt(1, employeeID);
        verify(mockStmnt).setString(2, type.getType());
        verify(mockStmnt).executeUpdate();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
