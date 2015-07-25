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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author srole_000
 */
public class VehicalTable {
//    
    public static Vehical getRow(String vName) throws SQLException {
        String sql = "SELECT * FROM vehical WHERE vehicalName=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setString(1, vName);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      Vehical bean = new Vehical();
                      bean.setVehicalName(vName);
                      bean.setVehicalNo(rs.getString("vehicalNo"));
                      bean.setRemainingCapacity(rs.getInt("remainingCapacity_Uni"));
                                            
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

    public static ResultSet displayAllRows() throws SQLException{
    String sql = "SELECT * FROM vehical";
    try(
        Connection conn = DBUtil.getConnection(DBType.MYSQL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
    ){
        
        return rs;
    }
   }
    
    public static boolean insert(Vehical bean) throws Exception{
    
        String sql="INSERT INTO vehical(vehicalNo,vehicalName)"+
                    "values(?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setString(1, bean.getVehicalNo());            
            stmt.setString(2, bean.getVehicalName());
           
            
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
    
    
    public static boolean update(Vehical bean) throws Exception{
    
        String sql = "UPDATE vehical SET "+
                     "vehicalName=?, "+                     
                     "remainingCapacity_Uni=? "+
                     "WHERE vehicalNo=? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setString(1,bean.getVehicalName());
            stmt.setInt(2,bean.getRemainingCapacity());
            stmt.setString(3,bean.getVehicalNo());
           
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
     
    
     public static DefaultComboBoxModel getAll() throws SQLException
    {
        /////get all items in the database
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        String sql="SELECT vehicalName FROM vehical;";

        Connection cn = DBUtil.getConnection(DBType.MYSQL);
        PreparedStatement stmt = cn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next())
        {
            dcm.addElement(rs.getString("vehicalName"));
        }

        cn.close();
        return dcm;
    }
}
