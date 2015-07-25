/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem.Tables;

import inventorysystem.Beans.Bill;
import inventorysystem.Beans.BillItem;
import inventorysystem.Beans.Discount;
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
public class DiscountTable {

    public static Discount getRow(int billNo) throws SQLException {
        String sql = "SELECT * FROM discount WHERE billNo=?";
        ResultSet rs = null;
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, billNo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Discount bean = new Discount();
                bean.setBillNo(billNo);
                bean.setDiscountId(rs.getInt("discountId"));
                bean.setItemName(rs.getString("itemName"));
                bean.setQuantity(rs.getInt("quantity"));
                bean.setTotal(rs.getFloat("total"));
                bean.setType(rs.getString("type"));
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

    public static boolean insert(Discount bean) throws Exception {

        String sql = "INSERT INTO discount(billNo,itemName,quantity,total,type)"
                + "values(?,?,?,?,?);";
        ResultSet keys = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setInt(1, bean.getBillNo());
            stmt.setString(2, bean.getItemName());
            stmt.setInt(3, bean.getQuantity());
            stmt.setFloat(4, bean.getTotal());
            stmt.setString(5, bean.getType());

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

    // get discount for a bill
    public static float getDiscountForBill(int billNo) {
        String sql = "SELECT sum(total) FROM `discount` WHERE billNo=?";
        ResultSet rs = null;
        float price;
        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, billNo);
            rs = stmt.executeQuery();

            if (rs.next()) {

                price = rs.getFloat(1);

            } else {
                price = 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            price = -99;
        } finally {
        }
        return price;
    }

}
