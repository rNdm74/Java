
package pprogramming3assignmentone;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Adam Charlton
 */
public class Find {
    public enum Methods{
        MAX,
        MIN,
        MEAN,
        MEDIAN,
        MODE,
        RANGE    
    }
    
    private int column;
    private ArrayList<Object[]> data;
    
    /**
     *
     * @param home constructor that accesses variables from the home class
     */
    public Find(Home home){
        data = home.csvData.getData();
    }
    
    public Find(ArrayList<Object[]> data){
        this.data = data;
    }
    
    /**
     *
     * @param column receives specific column to calculate statistics
     * @return object array of all calculations for specified column
     */
    public Object[] returnStats(int column){
        this.column = column;
        
        Object[] items = {
                ((String)data.get(0)[column]).toUpperCase(),
                calculate(Methods.MAX),
                calculate(Methods.MIN),
                calculate(Methods.MEAN),
                calculate(Methods.MEDIAN),
                calculate(Methods.MODE),
                calculate(Methods.RANGE),
        };
        
        return items;        
    }
    
    private String calculate(Methods calcs){
        String result;        
                        
        if (new Validation().number(data.get(1)[column])) {
            result = methodReturnValue(calcs);
        }
        else{
            return "null";
        }
        
        return result;
    }
    
    private String methodReturnValue(Methods calcs){
        switch(calcs){
            case MAX:
                return max();
            case MIN:
                return min();
            case MEAN:
                return mean();
            case MEDIAN:
                return median();
            case MODE:
                return mode();
            case RANGE:
                return range(max(), min());
            default:
                return null;            
        }            
    }
    
    /**
     *
     * @return max value of specific column
     */
    public String max(){
        double maxValue = 0;
        
        for (int row = 1; row < data.size(); row++) {
            Object item = data.get(row)[column];
            
            double temp = Double.parseDouble((String)item);
            
            if (temp > maxValue) {
                maxValue = temp;
            }
        }
      
        return Double.toString(maxValue);
    }
    
    public String min(){
        double minValue;   
        
        Object item = data.get(1)[column];
        
        minValue = Double.parseDouble((String)item);
        
        for (int row = 1; row < data.size(); row++) {
            item = (String)data.get(row)[column];

            double temp = Double.parseDouble((String)item);

            if (temp < minValue) {
                minValue = temp;
            }            
        }
      
        return Double.toString(minValue);
    }    
    
    public String mean(){
        double sum = 0;
    
        Object item = data.get(1)[column];
        
        for (int row = 1; row < data.size(); row++) {
            sum += Double.parseDouble((String)item);
        }
        
        return Double.toString(sum / data.size());
    }   
    
    public String median(){       
        double[] values = new double[data.size()];
                
        for (int i = 1; i < values.length-1; i++) {
            values[i-1] = Double.parseDouble((String)data.get(i)[column]);
        }
        
        Arrays.sort(values);
        
        int middle = values.length/2;
                
        if (values.length%2 == 1) {
            return Double.toString(values[middle]);
        } else {
            return Double.toString((values[middle-1] + values[middle]) / 2.0);
        }        
    }   
    
    public String mode(){
        double maxValue = 0, maxCount = 0;
                
        for (int i = 1; i < data.size(); ++i) {                
            double count = 0;

            for (int j = 1; j < data.size(); ++j) {
                String s1 = (String)data.get(j)[column];
                String s2 = (String)data.get(i)[column];

                if (s1.equals(s2)){
                    ++count;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = Double.parseDouble((String)data.get(i)[column]);
            }
        }

        return Double.toString(maxValue);
    }
    
    public String range(String max, String min){
        double maximum = Double.parseDouble(max);
        double minimum = Double.parseDouble(min);
        
        return Double.toString(maximum - minimum);        
    }    
}
