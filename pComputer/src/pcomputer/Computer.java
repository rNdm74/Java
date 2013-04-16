
package pcomputer;

/**
 *
 * @author rndm
 */
abstract class Computer {

    /**
     * @return the count
     */
    
    protected String manufacturer;
    protected String processor;
    protected int ramSize;
    protected int diskSize;
    private static int count;

    public Computer(String manufacturer, String processor, int ramSize, int diskSize) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        count++;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getProcessor() {
        return processor;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public int getRamSize() {
        return ramSize;
    }
    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }
    public int getDiskSize() {
        return diskSize;
    }
    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }
    public static int getCount() {
        return count;
    }   
    
    @Override
    public String toString(){
        String result = manufacturer + "\n" 
                        + processor + "\n"
                        + ramSize + "\n"
                        + diskSize;
        return result;
    }    
}
