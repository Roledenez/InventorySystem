/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;

import inventorysystem.Beans.AddToVehicle;
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
 * @author HP
 */
public class AddToVehicleTable {
    public static AddToVehicle getRow(String vNo,int iNo,String iName) throws SQLException {
        String sql = "SELECT * FROM addtovehical WHERE vehicleNo=? and invoiceNo=? and itemName=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setString(1, vNo);
                    stmt.setInt(2,iNo);
                    stmt.setString(3,iName);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      AddToVehicle bean = new AddToVehicle();
                      bean.setVehicleNo(vNo);
                      bean.setInvoiceNo(iNo);
                      bean.setItemName(iName);
                      bean.setDate(rs.getDate("date"));
                      bean.setQuantity_Pack(rs.getInt("quantity_Pack"));
                      bean.setQuantity_Unit(rs.getInt("quantity_Unit"));
                      
                      return bean;
                    }else{
                    
                    return null;
                    }
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                } finally{
            if(rs!=null){
                rs.close();
            }
              
        }
    }

    
     public static boolean insert(AddToVehicle bean) throws Exception{
    
        String sql="INSERT INTO addtovehical(vehicalNo,invoiceNo,itemName,quantity_unit,date,quantity_Pack)"+
                    "values(?,?,?,?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setString(1, bean.getVehicleNo());            
            stmt.setInt(2, bean.getInvoiceNo()); 
            stmt.setString(3, bean.getItemName()); 
            stmt.setInt(4, bean.getQuantity_Unit());
            stmt.setDate(5,new java.sql.Date(bean.getDate().getTime()) );
            stmt.setInt(6, bean.getQuantity_Pack());
            
            int affacted = stmt.executeUpdate();
            
            if(affacted==1){
               
            }else{
                JOptionPane.showMessageDialog(null, "Can't insert data", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            if(keys!=null) keys.close();
        }
        return true;
    }
}
