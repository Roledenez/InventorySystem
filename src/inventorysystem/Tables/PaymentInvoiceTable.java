/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;


import inventorysystem.Beans.PaymentInvoice;
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
public class PaymentInvoiceTable {
    
    public static PaymentInvoice getRow(int iId,int pId) throws SQLException {
        String sql = "SELECT * FROM payment_invoice WHERE invoiceId=? and paymentId=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, iId);
                    stmt.setInt(2, pId);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      PaymentInvoice bean = new PaymentInvoice();
                      bean.setInvoiceId(iId);
                      bean.setPaymentId(pId);
                      
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
    
    
    public static boolean insert(PaymentInvoice bean) throws Exception{
    
        String sql="INSERT INTO payment_invoice(invoiceId,paymentId)"+
                    "values(?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setInt(1, bean.getInvoiceId());            
            stmt.setInt(2, bean.getPaymentId());
            
            int affacted = stmt.executeUpdate();
            
            if(affacted==1){
               
            }else{
                
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
