/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;


import inventorysystem.Beans.Cheque;
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
public class ChequeTable {
     public static Cheque getRow(int cNo,String bank) throws SQLException {
        String sql = "SELECT * FROM cheque WHERE chequeNo=? and Bank=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, cNo);
                    stmt.setString(2,bank);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      Cheque bean = new Cheque();
                      bean.setChequeNo(cNo);
                      bean.setBank(bank);
                      bean.setExDate(rs.getDate("exDate"));
                      bean.setAmount(rs.getFloat("amount"));
                      bean.setPaymentId(rs.getInt("paymentId"));
                      
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

    public static boolean insert(Cheque bean) throws Exception{
    
        String sql="INSERT INTO cheque(chequeNo,Bank,exDate,Amount,paymentId)"+
                    "values(?,?,?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setInt(1, bean.getChequeNo());            
            stmt.setString(2, bean.getBank()); 
            stmt.setDate(3, new java.sql.Date(bean.getExDate().getTime())); 
            stmt.setFloat(4, bean.getAmount());
            stmt.setInt(5, bean.getPaymentId());
            
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


