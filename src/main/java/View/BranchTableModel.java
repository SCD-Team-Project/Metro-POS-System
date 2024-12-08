
package View;


import Controller.SuperAdminController;
import Model.Branch;
import Model.SAdmin.SuperAdminService;
import javax.swing.table.AbstractTableModel;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class BranchTableModel extends AbstractTableModel 
{
    private Map<Integer, Branch> branchMap;
    private List<Branch> branchList;

    public BranchTableModel() 
    {
        //getting the branchMapfrom controller
        SuperAdminController sAdminController=SuperAdminController.getInstance(new SuperAdminService());
        this.branchMap=sAdminController.getAllBranches();
        //this.branchMap = branchMap;
        this.branchList = new ArrayList<>(branchMap.values());  // Converting the map to a list for easier handling
    }

    @Override
    public int getRowCount() 
    {
        return branchList.size();
    }

    @Override
    public int getColumnCount() 
    {
        return 8; // Columns: BranchID, BranchName, City, Address, PhoneNumber, NumOfEmployees, ManagerID, IsActive
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Branch branch = branchList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> branch.getBranchID();
            case 1 -> branch.getBranchName();
            case 2 -> branch.getCity();
            case 3 -> branch.getAddress();
            case 4 -> branch.getPhoneNumber();
            case 5 -> branch.getNum_of_employees();
            case 6 -> branch.getManagerID();
            case 7 -> branch.isActive() ? "Active" : "Inactive";
            default -> null;
        }; // BranchID
        // BranchName
        // City
        // Address
        // PhoneNumber
        // NumOfEmployees
        // ManagerID
        // IsActive (display as string)
    }

    @Override
    public String getColumnName(int column)
    {
        return switch (column) 
        {
            case 0 -> "BranchID";
            case 1 -> "BranchName";
            case 2 -> "City";
            case 3 -> "Address";
            case 4 -> "PhoneNumber";
            case 5 -> "NumOfEmployees";
            case 6 -> "ManagerID";
            case 7 -> "Status";
            default -> "";
        };
    }
}
