
package Model;


public enum EmployeeType 
{
    BRANCH_MANAGER("Branch Manager"),
    CASHIER("Cashier"),
    DATA_ENTRY_OPERATOR("Data Entry Operator");

    public static boolean valueOf(boolean equals)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
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
