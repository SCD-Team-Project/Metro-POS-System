
package Model;


public class Employee 
{
    int employeeID;
    String employeeEmail;
    String password;
    String employeeName;
    EmployeeType type;
    int branchID;
    String phoneNumber;
    String address;
    int salary;

    public Employee(int employeeID, String employeeEmail, String password, String employeeName, EmployeeType type, int branchID, String phoneNumber, String address, int salary) 
    {
        this.employeeID = employeeID;
        this.employeeEmail = employeeEmail;
        this.password = password;
        this.employeeName = employeeName;
        this.type = type;
        this.branchID = branchID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    //this will most prolly be called when a new user entered the chat yk
    public Employee(String employeeEmail, String employeeName, EmployeeType type, int branchID, String phoneNumber, String address, int salary)
    {
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.type = type;
        this.branchID = branchID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public int getEmployeeID() 
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) 
    {
        this.employeeID = employeeID;
    }

    public String getEmployeeEmail()
    {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) 
    {
        this.employeeEmail = employeeEmail;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public EmployeeType getType()
    {
        return type;
    }

    public void setType(EmployeeType type) 
    {
        this.type = type;
    }

    public int getBranchID() 
    {
        return branchID;
    }

    public void setBranchID(int branchID) 
    {
        this.branchID = branchID;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getSalary() 
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    
    
    
    
}
