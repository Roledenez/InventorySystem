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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author srole_000
 */
public class VehicalItemTable {
    
    public static VehicalItem getRow(String vName, String iName) throws SQLException {
        String sql = "SELECT * FROM vehical_item WHERE vehicalName=? and itemName=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setString(1, vName);
                    stmt.setString(2, iName);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      VehicalItem bean = new VehicalItem();
                      bean.setItemName(iName);
                      bean.setVehicalName(vName);
                      bean.setQuantityUnit(rs.getInt("quantity_unit"));
                      bean.setQuantityBox(rs.getInt("quantity_Box"));
                      
                      bean.setDate(rs.getDate("date"));
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

    public static boolean insert(VehicalItem bean) throws Exception{
    
        String sql="INSERT INTO vehical_item(vehicalName,itemName,quantity_unit,date,quantity_Box)"+
                    "values(?,?,?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setString(1, bean.getVehicalName());            
            stmt.setString(2, bean.getItemName()); 
            stmt.setInt(3, bean.getQuantityUnit()); 
            stmt.setDate(4,new java.sql.Date(bean.getDate().getTime()) );
            stmt.setInt(5, bean.getQuantityBox());
            
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
    
    public static  TableModel getVehicalDetailsToTable(String vehicalName, Date date){  
     String sql="SELECT * FROM vehical_item WHERE vehicalName=? and date=?";
      ResultSet rs=null;
     try(
        Connection conn = DBUtil.getConnection(DBType.MYSQL);
        Statement stmt = conn.createStatement();
       
        PreparedStatement ps = conn.prepareStatement(sql);
    ){
        
            //DeliveryNote dvn=new DeliveryNote();  
           // ResultSet rs =dvn.getRs();
            ps.setString(1,vehicalName);
            ps.setDate(2,new java.sql.Date(date.getTime()));
            rs = ps.executeQuery();
            
            ResultSetMetaData md = rs.getMetaData();
        
            int columnCount = md.getColumnCount();
        
            Vector data = new Vector(columnCount);
            Vector row = new Vector(columnCount);
            Vector columnNames = new Vector(columnCount);
        
            //add column names
            columnNames.addElement("vehicalName");
            columnNames.addElement("itemName");
            columnNames.addElement("quantity_unit");
            columnNames.addElement("date");
            
                                
            while (rs.next()) 
            {
                for (int i = 1; i <= columnCount; i++) 
                {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
                row = new Vector(columnCount); // Create a new row Vector
            }
                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                return model;         
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
      }
    
     
     public static boolean delete(String vNumber, String itemName,String date) throws Exception{
    
        String sql ="DELETE FROM vehical_item WHERE vehicalName=? and itemName=? and date=?";
         try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                )
         {
             stmt.setString(1, vNumber);
             stmt.setString(2, itemName);
             stmt.setString(3, date);
             int affacted = stmt.executeUpdate();
             
             if(affacted==1){
                 return true;
             }else{
                 return false;
             }
            
         }catch(Exception e){
             return false;
         }
    }
     
}
