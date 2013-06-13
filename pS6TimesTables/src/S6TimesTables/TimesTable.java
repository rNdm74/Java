
package xml;

import java.util.ArrayList;

/**
 *
 * @author rNdm
 */
public class TimesTable {

    private String name;
    
    private ArrayList<Equation> timesTable;
    
    public TimesTable(String name){
        this.name = name;
        timesTable = new ReadXML("tables.xml").getTableData(name);   
    }   
    
    public void loadTimeTableEquations(){
        
    }

    public String getName() {
        return name;
    }

    public ArrayList<Equation> getTimesTable() {
        return timesTable;
    }

}
