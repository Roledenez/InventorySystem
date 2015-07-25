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
public class Payment {
    private int paymentId;
    private int billNo;
    private String paymentType;
    private String status;
    private Date paidDate;
    private String inout;
    private float totalAmount;
    private float paidAmount;

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the paidDate
     */
    public Date getPaidDate() {
        return paidDate;
    }

    /**
     * @param paidDate the paidDate to set
     */
    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    /**
     * @return the inout
     */
    public String getInout() {
        return inout;
    }

    /**
     * @param inout the inout to set
     */
    public void setInout(String inout) {
        this.inout = inout;
    }

    /**
     * @return the totalAmount
     */
    public float getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the paidAmount
     */
    public float getPaidAmount() {
        return paidAmount;
    }

    /**
     * @param paidAmount the paidAmount to set
     */
    public void setPaidAmount(float paidAmount) {
        this.paidAmount = paidAmount;
    }
}
