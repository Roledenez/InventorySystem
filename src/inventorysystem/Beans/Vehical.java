/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Beans;

/**
 *
 * @author srole_000
 */
public class Vehical {
    private String vehicalNo;
    private String vehicalName;
    private int remainingCapacity;
    /**
     * @return the vehicalNo
     */
    public String getVehicalNo() {
        return vehicalNo;
    }

    /**
     * @param vehicalNo the vehicalNo to set
     */
    public void setVehicalNo(String vehicalNo) {
        this.vehicalNo = vehicalNo;
    }

    /**
     * @return the vehicalName
     */
    public String getVehicalName() {
        return vehicalName;
    }

    /**
     * @param vehicalName the vehicalName to set
     */
    public void setVehicalName(String vehicalName) {
        this.vehicalName = vehicalName;
    }

    /**
     * @return the remainingCapacity
     */
    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    /**
     * @param remainingCapacity the remainingCapacity to set
     */
    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }
    
}
