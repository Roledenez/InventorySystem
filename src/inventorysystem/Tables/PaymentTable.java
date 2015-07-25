/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;


import inventorysystem.Beans.Payment;
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
public class PaymentTable {
    public static Payment getRow(int pId) throws SQLException {
        String sql = "SELECT * FROM payment WHERE paymentId=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, pId);
                    
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      Payment bean = new Payment();
                      bean.setPaymentId(pId);
                      bean.setBillNo(rs.getInt("billNo"));
                      bean.setPaymentType(rs.getString("paymentType"));
                      bean.setStatus(rs.getString("status"));
                      bean.setPaidDate(rs.getDate("paidDate"));
                      bean.setInout(rs.getString("inout"));
                      bean.setTotalAmount(rs.getFloat("totalAmount"));
                      bean.setPaidAmount(rs.getFloat("paidAmount"));
                      
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
    
    
    public static boolean insert(Payment bean) throws Exception{
    
        String sql="INSERT INTO payment(billNo,paymentType,status,paidDate,_inout,totalAmount,paidAmount)"+
                    "values(?,?,?,?,?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            //stmt.setInt(1, bean.getPaymentId()); 
            stmt.setInt(1, bean.getBillNo());
            stmt.setString(2,bean.getPaymentType());
            stmt.setString(3, bean.getStatus());
            stmt.setDate(4,new java.sql.Date(bean.getPaidDate().getTime())); 
            stmt.setString(5,bean.getInout());
            stmt.setFloat(6, bean.getTotalAmount());
            stmt.setFloat(7,bean.getPaidAmount());
           
            
            int affacted = stmt.executeUpdate();
            
            if(affacted==1){
                keys=stmt.getGeneratedKeys();
                keys.next();
                String newKey = keys.getString(1);
                bean.setPaymentId(Integer.parseInt(newKey));
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
