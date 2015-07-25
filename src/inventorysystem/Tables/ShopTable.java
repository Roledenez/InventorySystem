/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;


import inventorysystem.Beans.Shop;
import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ShopTable {
    
    public static Shop getRow(String name) throws SQLException {
        String sql = "SELECT * FROM shop WHERE name=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setString(1, name);
                    
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      Shop bean = new Shop();
                      bean.setName(name);
                      bean.setAddress(rs.getString("address"));
                      bean.setRegisteredDate(rs.getDate("registrateDate"));
                      bean.setRemainingAmount(rs.getFloat("remainingAmount"));
                      
                      
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
    
    
    
    public static boolean insert(Shop bean) throws Exception{
    
        String sql="INSERT INTO shop(name,address,registrateDate,remainingAmount)"+
                    "values(?,?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setString(1, bean.getName()); 
            stmt.setString(2, bean.getAddress());
            stmt.setDate(3,new java.sql.Date(bean.getRegisteredDate().getTime())); 
            stmt.setFloat(4, bean.getRemainingAmount());
            
           
            
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
    
    
    public static DefaultComboBoxModel getList(String key) throws SQLException{
      DefaultComboBoxModel model  = new DefaultComboBoxModel();
      
      String sql = "SELECT name FROM shop WHERE name LIKE ? ";
      
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
