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
public class Discount {
    private int discountId;
    private int billNo;
    private String itemName;
    private int quantity;
    private float total;
    private String type;
    /**
     * @return the discountId
     */
    public int getDiscountId() {
        return discountId;
    }

    /**
     * @param discountId the discountId to set
     */
    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    /**
     * @return the billNo
     */
    public int getBillNo() {
        return billNo;
    }

    /**
     * @param billNo the billNo to set
     */
    public void setBillNo(int billNo) {
        this.billNo = billNo;
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
}
