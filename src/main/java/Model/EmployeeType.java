
package Model;


public enum EmployeeType 
{
    BRANCH_MANAGER("Branch Manager"),
    CASHIER("Cashier"),
    DATA_ENTRY_OPERATOR("Data Entry Operator");
    
    private String type;
    
    EmployeeType(String type)
    {
        this.type=type;
    }
    
    public String getType()
    {
        return type;
    }
}