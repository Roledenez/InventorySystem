/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;

import inventorysystem.Beans.*;
import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author srole_000
 */
public class ItemTable {
    
    public static Item getRow(String name) throws SQLException {
        String sql = "SELECT * FROM item WHERE name=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setString(1, name);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      Item bean = new Item();
                      bean.setName(name);
                      bean.setItemId(rs.getInt("itemId"));
                      bean.setAgentPrice_pack(rs.getFloat("agentPrice_Pack"));
                      bean.setWsPrice_pack(rs.getFloat("wsPrice_Pack"));
                      bean.setRetailPrice_pack(rs.getFloat("retailPrice_Pack"));
                      bean.setAgentPrice_unit(rs.getFloat("agentPrice_Unit"));
                      bean.setWsPrice_unit(rs.getFloat("wsPrice_Unit"));
                      bean.setRetailPrice_unit(rs.getFloat("retailPrice_Unit"));
                      bean.setUnitPerBox(rs.getInt("unitPerBox"));
                      //bean.setCurrentStock(rs.getInt("currentStock"));
                      return bean;
                    }else{
                    JOptionPane.showMessageDialog(null, "There are no items with name : "+name, "Error", JOptionPane.ERROR_MESSAGE);
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

    public static boolean insert(Item bean) throws Exception{
    
        String sql="INSERT INTO item(name,agentPrice_Pack,wsPrice_Pack,retailPrice_Pack,agentPrice_Unit,wsPrice_Unit,retailPrice_Unit,unitPerBox)"+
                    "values(?,?,?, ?,?,?,  ?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setString(1, bean.getName());            
            stmt.setFloat(2, bean.getAgentPrice_pack()); 
            stmt.setFloat(3, bean.getWsPrice_pack()); 
            stmt.setFloat(4, bean.getRetailPrice_pack()); 
            stmt.setFloat(5, bean.getAgentPrice_unit());
            stmt.setFloat(6, bean.getWsPrice_unit()); 
            stmt.setFloat(7, bean.getRetailPrice_unit()); 
            stmt.setInt(8, bean.getUnitPerBox()); 
            //stmt.setInt(9, bean.getCurrentStock()); 
           
            
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
    
    
    public static boolean update(Item bean) throws Exception{
    
        String sql = "UPDATE item SET "+
                     "agentPrice_Pack=?, "+
                     "wsPrice_Pack=?,"+
                     "retailPrice_Pack=?, "+
                     "agentPrice_Unit=?, "+
                     "wsPrice_Unit=?, "+
                     "retailPrice_Unit=?, "+
                     "unitPerBox=?, "+
                     //"currentStock=?, "+
                     "name=? "+
                     "WHERE itemId=? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setFloat(1,bean.getAgentPrice_pack());
            stmt.setFloat(2,bean.getWsPrice_pack());
            stmt.setFloat(3,bean.getRetailPrice_pack());
            stmt.setFloat(4,bean.getAgentPrice_unit());
            stmt.setFloat(5,bean.getWsPrice_unit());
            stmt.setFloat(6,bean.getRetailPrice_unit());
            stmt.setInt(7,bean.getUnitPerBox());
            //stmt.setInt(8,bean.getCurrentStock());
            stmt.setString(8,bean.getName());
            stmt.setInt(9, bean.getItemId());
           
            int affacted = stmt.executeUpdate();
            
            if(affacted==1){
                return true;
            }else{
                System.err.println("No rows affacted");
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            
        }
        
    }
      
//    public static ResultSet getAllItems(){
//         String sql = "SELECT * FROM item";
//        try (
//        Connection conn = DBUtil.getConnection(DBType.MYSQL);
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//    ){
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(inventorysystem.AddToVehicle.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    
    public static DefaultComboBoxModel getList(String key) throws SQLException{
      DefaultComboBoxModel model  = new DefaultComboBoxModel();
      
      String sql = "SELECT name FROM item WHERE name LIKE ? ";
      
        ResultSet rs = null;
        key="%"+key+"%";
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setString(1, key);
                    rs = stmt.executeQuery();
                    
                    while(rs.next())
                    {
                      
                      model.addElement(rs.getString("name"));
                      
                    }
                    
                } catch(SQLException e){
                     JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                } finally{
            if(rs!=null){
                rs.close();
            }
            
      return model;
    }
    
    }
    
    
}
