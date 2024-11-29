
package Model;


public class UserSession 
{
    static String username;  
    static String type;
    static int branchID;
    
    public static void create(String username,String type,int branchID)
    {
        UserSession.username=username;
        UserSession.type=type;
        UserSession.branchID=branchID;
    }
    
    public static void clear()
    {
        username=null;
        type=null;
        branchID=0;
    }
    
    public static String getUsername()
    {
        return username;
    }
    
    public static String getType()
    {
        return type;
    }
    
    public static int getBranchID()
    {
        return branchID;
    }
    
    public boolean isLoggedIn()
    {
        return username!=null; //if username is not null then return true since user islogged in
    }
    
}
