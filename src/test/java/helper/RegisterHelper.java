package helper;

import io.cucumber.datatable.DataTable;
import java.util.List;

public class RegisterHelper
{
    private List<List<String>> dataTable;

    public RegisterHelper(DataTable fields)
    {
        dataTable = fields.cells();
    }

    public String getName() {return dataTable.get(0).get(1);}
    public String getFirstLastName() {return dataTable.get(1).get(1);}
    public String getSecondLastName() {return dataTable.get(2).get(1);}
    public String getEmail() {return dataTable.get(3).get(1);}
    public String getPassword() {return dataTable.get(4).get(1);}
    public String getConfirmPassword() {return dataTable.get(5).get(1);}
    public String getCountry() {return dataTable.get(6).get(1);}
    public String getDocumentType() {return dataTable.get(7).get(1);}
    public String getDocumentNum() {return dataTable.get(8).get(1);}
    public String getDay() {return dataTable.get(9).get(1);}
    public String getMonth() {return dataTable.get(10).get(1);}
    public String getYear() {return dataTable.get(11).get(1);}
    public String getCellphone() {return dataTable.get(12).get(1);}
}
