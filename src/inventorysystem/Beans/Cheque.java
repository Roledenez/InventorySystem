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
public class Cheque {
    private int chequeNo;
    private String bank;
    private Date exDate;
    private float amount;
    private int paymentId;

    /**
     * @return the chequeNo
     */
    public int getChequeNo() {
        return chequeNo;
    }

    /**
     * @param chequeNo the chequeNo to set
     */
    public void setChequeNo(int chequeNo) {
        this.chequeNo = chequeNo;
    }

    /**
     * @return the bank
     */
    public String getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * @return the exDate
     */
    public Date getExDate() {
        return exDate;
    }

    /**
     * @param exDate the exDate to set
     */
    public void setExDate(Date exDate) {
        this.exDate = exDate;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

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
    
}
