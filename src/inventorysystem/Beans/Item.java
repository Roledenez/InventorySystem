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
public class Item {
    private int itemId;
    private String name;
    private float agentPrice_pack;
    private float wsPrice_pack;
    private float retailPrice_pack;
    private float agentPrice_unit;
    private float wsPrice_unit;
    private float retailPrice_unit;
    private int unitPerBox;

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

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
     * @return the retailPrice_pack
     */
    public float getRetailPrice_pack() {
        return retailPrice_pack;
    }

    /**
     * @param retailPrice_pack the retailPrice_pack to set
     */
    public void setRetailPrice_pack(float retailPrice_pack) {
        this.retailPrice_pack = retailPrice_pack;
    }

    /**
     * @return the agentPrice_unit
     */
    public float getAgentPrice_unit() {
        return agentPrice_unit;
    }

    /**
     * @param agentPrice_unit the agentPrice_unit to set
     */
    public void setAgentPrice_unit(float agentPrice_unit) {
        this.agentPrice_unit = agentPrice_unit;
    }

    /**
     * @return the wsPrice_unit
     */
    public float getWsPrice_unit() {
        return wsPrice_unit;
    }

    /**
     * @param wsPrice_unit the wsPrice_unit to set
     */
    public void setWsPrice_unit(float wsPrice_unit) {
        this.wsPrice_unit = wsPrice_unit;
    }

    /**
     * @return the retailPrice_unit
     */
    public float getRetailPrice_unit() {
        return retailPrice_unit;
    }

    /**
     * @param retailPrice_unit the retailPrice_unit to set
     */
    public void setRetailPrice_unit(float retailPrice_unit) {
        this.retailPrice_unit = retailPrice_unit;
    }

    /**
     * @return the unitPerBox
     */
    public int getUnitPerBox() {
        return unitPerBox;
    }

    /**
     * @param unitPerBox the unitPerBox to set
     */
    public void setUnitPerBox(int unitPerBox) {
        this.unitPerBox = unitPerBox;
    }

   
    
}
