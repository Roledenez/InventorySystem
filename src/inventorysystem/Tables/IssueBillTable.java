/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;


import inventorysystem.Beans.IssueBill;
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
public class IssueBillTable {
    public static IssueBill getRow(int bNo) throws SQLException {
        String sql = "SELECT * FROM issuebill WHERE billNo=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    
                    stmt.setInt(1,bNo);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      IssueBill bean = new IssueBill();
                      bean.setBillNo(bNo);
                      bean.setVehicleName(rs.getString("vehicalName"));
                      bean.setShopName(rs.getString("shopName"));
                      
                      
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
    
    
     public static boolean insert(IssueBill bean) throws Exception{
    
        String sql="INSERT INTO issuebill(vehicalName,billNo,shopName)"+
                    "values(?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setString(1, bean.getVehicleName());            
            stmt.setInt(2, bean.getBillNo()); 
            stmt.setString(3, bean.getShopName());
            
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
     
     public static boolean hasRow(int billNo) throws SQLException{
       IssueBill ib = IssueBillTable.getRow(billNo);
       if(ib != null){
          return true;
       }else{
           return false;
       }
     }
}
