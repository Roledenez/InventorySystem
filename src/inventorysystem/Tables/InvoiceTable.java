/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;

import inventorysystem.Beans.*;
import inventorysystem.DB.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author srole_000
 */
public class InvoiceTable {
    
    public static Invoice getRow(int invoiceNo) throws SQLException {
        String sql = "SELECT * FROM Invoice WHERE invoiceNo=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, invoiceNo);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      Invoice bean = new Invoice();
                      bean.setInvoiceNo(invoiceNo);
                      bean.setDate(rs.getDate("date"));                      
                      bean.setCompanyName(rs.getString("companyName"));
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

    public static boolean insert(Invoice bean) throws Exception{
    
        String sql="INSERT INTO invoice(invoiceNo,date,companyName)"+
                    "values(?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setInt(1, bean.getInvoiceNo());            
            stmt.setDate(2, new java.sql.Date(bean.getDate().getTime()));
            stmt.setString(3, bean.getCompanyName());
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
    
//    public static boolean update(Invoice bean) throws Exception{
//    
//        String sql = "UPDATE invoice SET "+
//                     "noOfBox=?"+
//                     "WHERE invoiceNo=?";
//        try (
//                Connection conn = DBUtil.getConnection(DBType.MYSQL);
//                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//             ){
//            stmt.setString(1,bean.getBowserRegNo());
//            stmt.setFloat(2,bean.getCapacityOfBowser());
//           
//            int affacted = stmt.executeUpdate();
//            
//            if(affacted==1){
//                return true;
//            }else{
//                System.err.println("No rows affacted");
//                return false;
//            }
//            
//        } catch (Exception e) {
//            System.err.println(e);
//            return false;
//        } finally{
//            
//        }
//        
//    }
//       
    
    
}
