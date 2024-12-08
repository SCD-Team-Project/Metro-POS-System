/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
//package Model.DataEntryOperator;

import Model.Category;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Dell
 */
public class DataEntryOperatorServiceTest {
    
    public DataEntryOperatorServiceTest() {
    }
     @Mock
    private Connection mockConn;
    @Mock
    private PreparedStatement mockStmnt;
    @Mock private ResultSet mockrs;
    @Mock
    private PreparedStatement mockSaveStmt;

    @Mock
    private PreparedStatement mockPurchaseStmt;

    @Mock
    private PreparedStatement mockStockStmt;
    
    private DataEntryOperatorService deoService;
    
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
            deoService=new DataEntryOperatorService();
            when(mockConn.prepareStatement(anyString())).thenReturn(mockStmnt);
            
        }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }
  @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addVendor method, of class DataEntryOperatorService.
     */
    //vendor will not be added
    @Test
    public void testAddVendor_Failure() {
        try{
       when(mockStmnt.executeUpdate()).thenReturn(0);
       String vendorName="vName";
       String phone="`12345678910";
       String email="testemail@gmail.com";
      // String address="Street 123 Block B house 1";
       
       boolean expected =false;
       boolean actual=deoService.addVendor(vendorName, phone, email,null);
       
       assertEquals(expected,actual);
       
       verify(mockStmnt).setString(1,vendorName);
       verify(mockStmnt).setString(2,phone);
       verify(mockStmnt).setString(3, email);
       verify(mockStmnt).setString(4,null);
       verify(mockStmnt).executeUpdate();
       
        }
 catch(SQLException ex){
            ex.printStackTrace();
        }
       
    }
   //vendor will be added
     @Test
    public void testAddVendor() {
        try{
       when(mockStmnt.executeUpdate()).thenReturn(1);
       String vendorName="vName";
       String phone="`12345678910";
       String email="testemail@gmail.com";
       String address="Street 123 Block B house 1";
       
       boolean expected =true;
       boolean actual=deoService.addVendor(vendorName, phone, email, address);
       
       assertEquals(expected,actual);
       
       verify(mockStmnt).setString(1,vendorName);
       verify(mockStmnt).setString(2,phone);
       verify(mockStmnt).setString(3, email);
       verify(mockStmnt).setString(4,address);
       verify(mockStmnt).executeUpdate();
       
        }
        catch(SQLException ex){
            ex.printStackTrace();
   }
       
    }
   
    /**
     * Test of getAllVendorNames method, of class DataEntryOperatorService.
     */
    //returns a list
    @Test
    public void testGetAllVendorNames() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        
        List<String>vendorName=deoService.getAllVendorNames();
        
        int expected=3;//replace with the number of entries in the database
        int actual=vendorName.size();
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    //returns an empty null list
 @Test
    public void testGetAllVendorNames_nullList() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        
        List<String>vendorName=deoService.getAllVendorNames();
        
        int expected=0;
        int actual=vendorName.size();
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of getVendorID method, of class DataEntryOperatorService.
     */
    //returns an id
    @Test
    public void testGetVendorID() {
        try{
  when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getInt("vendorID")).thenReturn(3);
        
        String vendorName="Name";
        
        int expected=3;
        int actual=deoService.getVendorID(vendorName);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, vendorName);
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    //returns -1
     @Test
    public void testGetVendorID_Failure() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(false);
       // when(mockrs.getInt("vendorID")).thenReturn(3);
String vendorName="Name";
        
        int expected=-1;
        int actual=deoService.getVendorID(vendorName);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, vendorName);
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of getAllCategories method, of class DataEntryOperatorService.
     */
    //returns a list
    @Test
    public void testGetAllCategories() {
         try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        
        List<Category>categories=deoService.getAllCategories();
        
        int expected=3;//replace with the number of entries in the database
 int actual=categories.size();
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).executeQuery();
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    //doesnot return anything
     @Test
    public void testGetAllCategories_nullList() {
         try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        
        List<Category>categories=deoService.getAllCategories();
        
        int expected=0;
        int actual=categories.size();
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).executeQuery();
        
        }
        catch(SQLException ex){
   ex.printStackTrace();
        }
    }

    /**
     * Test of getCategoryID method, of class DataEntryOperatorService.
     */
    //returns an ID
    @Test
    public void testGetCategoryID() {
         try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getInt("categoryID")).thenReturn(3);
        
        String categoryName="CategoryName";
        
        int expected=3;
        int actual=deoService.getVendorID(categoryName);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, categoryName);
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
 ex.printStackTrace();
        }
    }
    //returns -1
     @Test
    public void testGetCategoryID_Failure() {
         try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(false);
       // when(mockrs.getInt("categoryID")).thenReturn(3);
        
        String categoryName="CategoryName";
        
        int expected=-1;
        int actual=deoService.getVendorID(categoryName);
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, categoryName);
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
  /**
     * Test of addCategory method, of class DataEntryOperatorService.
     */
    //adds a category
    @Test
    public void testAddCategory() {
         try{
       when(mockStmnt.executeUpdate()).thenReturn(1);
       String categoryName="categoryName";
       
       boolean expected =true;
       boolean actual=deoService.addCategory(categoryName);
       
       assertEquals(expected,actual);
       
       verify(mockStmnt).setString(1,categoryName);
       
       verify(mockStmnt).executeUpdate();
       
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
     
    }
    //categoryName is null doesnot add anything
    @Test 
    public void testAddCategory_Failure(){
         try{
       when(mockStmnt.executeUpdate()).thenReturn(0);
       String categoryName="categoryName";
   boolean expected =false;
       boolean actual=deoService.addCategory(categoryName);
       
       assertEquals(expected,actual);
       
       verify(mockStmnt).setString(1,categoryName);
       
       verify(mockStmnt).executeUpdate();
       
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of getAllProductNames method, of class DataEntryOperatorService.
     */
    //returns a list 
    @Test
    public void testGetAllProductNames() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        
        List<String>productNames=deoService.getAllProductNames();
  int expected=3;//replace with the number of entries in the database
        int actual=productNames.size();
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    //returns null
    @Test
    public void testGetAllProductNames_Null() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        
        List<String>productNames=deoService.getAllProductNames();
        
        int expected=0;
        int actual=productNames.size();
        
        assertEquals(expected,actual);
        
        verify(mockStmnt).executeQuery();
   
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of getAllProducts method, of class DataEntryOperatorService.
     */
    
    @Test
    public void testGetAllProducts() {
        try{
         when(mockStmnt.executeQuery()).thenReturn(mockrs);

        // Simulate two products in the ResultSet
        when(mockrs.next()).thenReturn(true, true, false);
        when(mockrs.getInt("productID")).thenReturn(1, 2);
        when(mockrs.getString("productName")).thenReturn("Product A", "Product B"); //Adjust according to DB
        when(mockrs.getInt("categoryID")).thenReturn(20, 30); //adjust according to DB
        when(mockrs.getInt("stockQuantity")).thenReturn(50, 200);
        when(mockrs.getInt("purchasePrice")).thenReturn(500, 600);
        when(mockrs.getInt("salesPrice")).thenReturn(750, 850);

       
        List<Product> products = deoService.getAllProducts();
  assertNotNull(products);
        int expected=2;
        int actual=products.size();
        assertEquals(expected, actual);

       

        verify(mockStmnt).executeQuery();
        verify(mockrs, times(2)).getInt(anyString());
        verify(mockrs, times(2)).getString("productName");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    @Test 
    public void testGetAllProducts_nullList(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        
        List<Product>products=deoService.getAllProducts();
        
        int expected=0;
        int actual=products.size();
        
        assertEquals(expected,actual);
 verify(mockStmnt).executeQuery();
        
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of addProduct method, of class DataEntryOperatorService.
     */
    //adds a product
    @Test
    public void testAddProduct() {
        try{
     when(mockStmnt.executeUpdate()).thenReturn(1); 

        String productName = "ProductName";
        int categoryID = 1; //adjust this
        int stockQuantity = 100;
        int purchasePrice = 50;
        int salesPrice = 75;

        boolean expected=true;
        boolean actual = deoService.addProduct(productName, categoryID, stockQuantity, purchasePrice, salesPrice);
       
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, productName);
 verify(mockStmnt).setInt(2, categoryID);
        verify(mockStmnt).setInt(3, stockQuantity);
        verify(mockStmnt).setInt(4, purchasePrice);
        verify(mockStmnt).setInt(5, salesPrice);
        verify(mockStmnt).executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
  //doesnot add anything
    public void testAddProduct_Failure(){
          try{
     when(mockStmnt.executeUpdate()).thenReturn(0); 

      //  String productName = "ProductName";
        int categoryID = 1; //adjust this
        int stockQuantity = 100;
        int purchasePrice = 50;
        int salesPrice = 75;

        boolean expected=true;
        boolean actual = deoService.addProduct(null, categoryID, stockQuantity, purchasePrice, salesPrice);
       
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, null);
        verify(mockStmnt).setInt(2, categoryID);
        verify(mockStmnt).setInt(3, stockQuantity);
        verify(mockStmnt).setInt(4, purchasePrice);
  verify(mockStmnt).setInt(5, salesPrice);
        verify(mockStmnt).executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    /**
     * Test of addAllProducts method, of class DataEntryOperatorService.
     */
    @Test
    public void testAddAllProducts() {
        try{
        when(mockConn.prepareStatement(anyString())).thenReturn(mockSaveStmt).thenReturn(mockPurchaseStmt).thenReturn(mockStockStmt);
         List<Product> productList = Arrays.asList(
            new Product("Product 1", 2, 500, 600, 100),
            new Product("Product 2", 3, 40, 50, 200)
        );
         
         
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Test of addPurchasedProduct method, of class DataEntryOperatorService.
     */
    //adds a purchased product
 @Test
    public void testAddPurchasedProduct() {
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(true);
        when(mockrs.getInt("productID")).thenReturn(1004);
        
        when(mockConn.prepareStatement(anyString(), anyInt())).thenReturn(mockPurchaseStmt);
        when(mockPurchaseStmt.executeUpdate()).thenReturn(1);
        
        String productName = "Product1";
        int categoryID = 1002;
        int vendorID = 1005;
        int quantity = 10;
        int unitPrice = 50;
        boolean expected=true;
        boolean actual=deoService.addPurchasedProduct(productName, categoryID, vendorID, quantity, unitPrice);
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, productName);
        verify(mockStmnt).setInt(2, categoryID);
        verify(mockPurchaseStmt).setInt(1, 123);
        verify(mockPurchaseStmt).setInt(2, vendorID);
        verify(mockPurchaseStmt).setInt(3, quantity);
        verify(mockPurchaseStmt).setInt(4, unitPrice);
        
        verify(mockStmnt).executeQuery();
        verify(mockPurchaseStmt).executeUpdate();
        
        }catch(SQLException ex){
   ex.printStackTrace();
        }
        
    }
    //willNot add a purchased product
    @Test 
    public void AddPurchasedProduct_Failure(){
        try{
        when(mockStmnt.executeQuery()).thenReturn(mockrs);
        when(mockrs.next()).thenReturn(false);
        
        String productName = "Product1";
        int categoryID = 1002;
        int vendorID = 1005;
        int quantity = 10;
        int unitPrice = 50;
        boolean expected=false;
        boolean actual=deoService.addPurchasedProduct(productName, categoryID, vendorID, quantity, unitPrice);
        assertEquals(expected,actual);
        
        verify(mockStmnt).setString(1, productName);
        verify(mockStmnt).setInt(2, categoryID);
        
        verify(mockStmnt).executeQuery();
        verifyNoInteractions(mockPurchaseStmt);
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
    }
    }
    
}