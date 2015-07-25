/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem.Tables;

import inventorysystem.Beans.Company;
import inventorysystem.Beans.Item;
import inventorysystem.Beans.VehicalInventory;
import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author srole_000
 */
public class VehicalInventoryTable {

    public static VehicalInventory getRow(String vName, String itemName, String cName) throws SQLException {
        String sql = "SELECT * FROM vehicalinventory WHERE vehicalName=? and itemName=? and companyName=? ";
        ResultSet rs = null;
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, vName);
            stmt.setString(2, itemName);
            stmt.setString(3, cName);
            rs = stmt.executeQuery();

            if (rs.next()) {
                VehicalInventory bean = new VehicalInventory();
                bean.setVehicalName(vName);
                bean.setItemName(itemName);
                bean.setCompanyName(rs.getString("companyName"));
                bean.setQuantityUnit(rs.getInt("quantity_unit"));

                return bean;
            } else {

                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }

        }
    }

    public static boolean insert(VehicalInventory bean) throws Exception {

        String sql = "INSERT INTO vehicalInventory(vehicalName,itemName, companyName)"
                + "values(?,?,?);";
        ResultSet keys = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, bean.getVehicalName());
            stmt.setString(2, bean.getItemName());
            stmt.setString(3, bean.getCompanyName());
            //stmt.setInt(3, bean.getQuantityUnit()); 

            int affacted = stmt.executeUpdate();

            if (affacted == 1) {

            } else {
                JOptionPane.showMessageDialog(null, "Can't insert data", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            if (keys != null) {
                keys.close();
            }
        }
        return true;
    }

    public static boolean update(VehicalInventory bean) throws Exception {

        String sql = "UPDATE vehicalinventory SET "
                + "quantity_unit=? "
                + "WHERE vehicalName=? and itemName=? and companyName=?";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setInt(1, bean.getQuantityUnit());
            stmt.setString(2, bean.getVehicalName());
            stmt.setString(3, bean.getItemName());
            stmt.setString(4, bean.getCompanyName());
            int affacted = stmt.executeUpdate();

            if (affacted == 1) {
                return true;
            } else {
                System.err.println("No rows affacted");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {

        }

    }

}
