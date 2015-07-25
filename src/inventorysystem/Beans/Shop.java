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
public class Shop {
    private String name;
    private String address;
    private Date registeredDate;
    private float remainingAmount;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the registeredDate
     */
    public Date getRegisteredDate() {
        return registeredDate;
    }

    /**
     * @param registeredDate the registeredDate to set
     */
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    /**
     * @return the remainingAmount
     */
    public float getRemainingAmount() {
        return remainingAmount;
    }

    /**
     * @param remainingAmount the remainingAmount to set
     */
    public void setRemainingAmount(float remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
    
}
