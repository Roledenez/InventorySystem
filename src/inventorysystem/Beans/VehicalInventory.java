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
public class VehicalInventory {
    
    private String vehicalName;
    private String itemName;
    private int quantityUnit;
    private String companyName;
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
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the quantityUnit
     */
    public int getQuantityUnit() {
        return quantityUnit;
    }

    /**
     * @param quantityUnit the quantityUnit to set
     */
    public void setQuantityUnit(int quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
