
package Model;


public class Vendor 
{
    int vendorID;
    String vendorName;
    String phoneNumber;
    String email;
    String address;

    public Vendor(int vendorID, String vendorName, String phoneNumber, String email, String address) 
    {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Vendor(String vendorName, String phoneNumber, String email, String address) 
    {
        this.vendorName = vendorName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getVendorName() 
    {
        return vendorName;
    }

    public void setVendorName(String vendorName) 
    {
        this.vendorName = vendorName;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getVendorID()
    {
        return vendorID;
    }
    
}
