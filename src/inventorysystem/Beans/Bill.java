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
public class Bill {
    private int billNo;
    private Date date;

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
    
}
