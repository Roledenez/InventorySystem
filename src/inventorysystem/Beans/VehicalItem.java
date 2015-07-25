/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Beans;

import java.util.Date;

/**
 *
 * @author srole_000
 */
public class VehicalItem {
    private String vehicalName;
    private String itemName;
    private int quantityUnit;
    private Date date;
    private int quantityBox;
   
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the quantityBox
     */
    public int getQuantityBox() {
        return quantityBox;
    }

    /**
     * @param quantityBox the quantityBox to set
     */
    public void setQuantityBox(int quantityBox) {
        this.quantityBox = quantityBox;
    }

    
}
