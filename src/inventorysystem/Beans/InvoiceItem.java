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
public class InvoiceItem {
    private int invoiceNo;
    private String itemName;
    private int noOfBox;
    private float agentPrice_pack;
    private float wsPrice_pack;
    private float rtailPrice_pack;
    private int remainingCapacity;
    private float total;
    private int stockId;
    private int tableId;
    private String companyName;
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
     * @return the noOfBox
     */
    public int getNoOfBox() {
        return noOfBox;
    }

    /**
     * @param noOfBox the noOfBox to set
     */
    public void setNoOfBox(int noOfBox) {
        this.noOfBox = noOfBox;
    }

    /**
     * @return the agentPrice_pack
     */
    public float getAgentPrice_pack() {
        return agentPrice_pack;
    }

    /**
     * @param agentPrice_pack the agentPrice_pack to set
     */
    public void setAgentPrice_pack(float agentPrice_pack) {
        this.agentPrice_pack = agentPrice_pack;
    }

    /**
     * @return the wsPrice_pack
     */
    public float getWsPrice_pack() {
        return wsPrice_pack;
    }

    /**
     * @param wsPrice_pack the wsPrice_pack to set
     */
    public void setWsPrice_pack(float wsPrice_pack) {
        this.wsPrice_pack = wsPrice_pack;
    }

    /**
     * @return the rtailPrice_pack
     */
    public float getRtailPrice_pack() {
        return rtailPrice_pack;
    }

    /**
     * @param rtailPrice_pack the rtailPrice_pack to set
     */
    public void setRtailPrice_pack(float rtailPrice_pack) {
        this.rtailPrice_pack = rtailPrice_pack;
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
     * @return the stockId
     */
    public int getStockId() {
        return stockId;
    }

    /**
     * @param stockId the stockId to set
     */
    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    /**
     * @return the tableId
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * @param tableId the tableId to set
     */
    public void setTableId(int tableId) {
        this.tableId = tableId;
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
