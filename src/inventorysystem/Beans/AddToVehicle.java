/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Beans;

import java.util.Date;
/**
 *
 * @author HP
 */
public class AddToVehicle {
    private String vehicleNo;
    private int invoiceNo;
    private String itemName;
    private Date date;
    private int quantity_Pack;
    private int quantity_Unit;

    /**
     * @return the vehicleNo
     */
    public String getVehicleNo() {
        return vehicleNo;
    }

    /**
     * @param vehicleNo the vehicleNo to set
     */
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    /**
     * @return the invoiceNo
     */
    public int getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo the invoiceNo to set
     */
    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
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
     * @return the quantity_Pack
     */
    public int getQuantity_Pack() {
        return quantity_Pack;
    }

    /**
     * @param quantity_Pack the quantity_Pack to set
     */
    public void setQuantity_Pack(int quantity_Pack) {
        this.quantity_Pack = quantity_Pack;
    }

    /**
     * @return the quantity_Unit
     */
    public int getQuantity_Unit() {
        return quantity_Unit;
    }

    /**
     * @param quantity_Unit the quantity_Unit to set
     */
    public void setQuantity_Unit(int quantity_Unit) {
        this.quantity_Unit = quantity_Unit;
    }
    
    
}
