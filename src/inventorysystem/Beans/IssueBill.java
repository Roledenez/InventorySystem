/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Beans;

/**
 *
 * @author HP
 */
public class IssueBill {
    private String vehicleName;
    private int billNo;
    private String shopName;

    /**
     * @return the vehicleName
     */
    public String getVehicleName() {
        return vehicleName;
    }

    /**
     * @param vehicleName the vehicleName to set
     */
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
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
     * @return the shopName
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * @param shopName the shopName to set
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    
}
