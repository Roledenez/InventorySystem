/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;

import inventorysystem.Beans.BillItem;
import inventorysystem.Beans.Company;
import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import java.sql.Connection;
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
public class BillItemTable {
//    
//    public static BillItem getRow(String name) throws SQLException {
//        String sql = "SELECT * FROM bill_item WHERE name=?";
//        ResultSet rs = null;
//        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
//                PreparedStatement stmt = conn.prepareStatement(sql);
//                ){
//                    stmt.setString(1, name);
//                    rs = stmt.executeQuery();
//                    
//                    if(rs.next())
//                    {
//                      BillItem bean = new BillItem();
//                      bean.setName(name);
//                      bean.setId(rs.getInt("id"));
//                      bean.setPhone(rs.getString("phone"));
//                      
//                      return bean;
//                    }else{
//                    
//                    return null;
//                    }
//                } catch(SQLException e){
//                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                    return null;
//                } finally{
//            if(rs!=null){
//                rs.close();
//            }
//              
//        }
//    }

     public static boolean insert(BillItem bean) throws Exception{
    
        String sql="INSERT INTO bill_item(billNo,itemName,status,quantity_Unit,reason,price,companyName)"+
                    "values(?,?,?, ?,?,?, ?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setInt(1, bean.getBillNo());            
            stmt.setString(2, bean.getItemName()); 
            stmt.setString(3, bean.getStatus());
            stmt.setInt(4, bean.getQuantityUnit());
            stmt.setString(5, bean.getReason());
            stmt.setFloat(6, bean.getPrice());
            stmt.setString(7, bean.getCompanyName());
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
    
    
     public static  TableModel getBillDetailsToTable(int billNo){  
     String sql="SELECT * FROM bill_item WHERE billNo=?";
      ResultSet rs=null;
     try(
        Connection conn = DBUtil.getConnection(DBType.MYSQL);
        Statement stmt = conn.createStatement();
       
        PreparedStatement ps = conn.prepareStatement(sql);
    ){
        
            //DeliveryNote dvn=new DeliveryNote();  
           // ResultSet rs =dvn.getRs();
            ps.setInt(1,billNo);
            rs = ps.executeQuery();
            
            ResultSetMetaData md = rs.getMetaData();
        
            int columnCount = md.getColumnCount();
        
            Vector data = new Vector(columnCount);
            Vector row = new Vector(columnCount);
            Vector columnNames = new Vector(columnCount);
        
            //add column names
            columnNames.addElement("No");
            columnNames.addElement("billNo");
            columnNames.addElement("itemName");
            columnNames.addElement("status");
            columnNames.addElement("quantity_Unit");
            columnNames.addElement("reason");
            columnNames.addElement("price");
            columnNames.addElement("companyName");
            int j=0;                    
            while (rs.next()) 
            {
                
                 row.addElement(++j);
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
    
     // get issued item's bill
     public static float getIssuedBill(int billNo){
        String sql="SELECT sum(price) FROM `bill_item` WHERE billNo=? and status='issued'";
        ResultSet rs = null;
        float price;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, billNo);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                     
                      price = rs.getFloat(1);
                      
                      
                    }else{
                    price=-99;
                    }
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    price=-99;
                } finally{
        }
        return price;
    }
    
     // get returned item's bill
      public static float getReturnBill(int billNo){
        String sql="SELECT sum(price) FROM `bill_item` WHERE billNo=? and status='Returned'";
        ResultSet rs = null;
        float price;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, billNo);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                     
                      price = rs.getFloat(1);
                      
                      
                    }else{
                    price=-99;
                    }
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    price=-99;
                } finally{
        }
        return price;
    }
    
     // calculate total bill
     public static float getBill(int billNo){
         return getIssuedBill(billNo)-getReturnBill(billNo);
     } 
     
      
     // calculate the bill of the all items in the bill
      
     public static boolean delete(String billNo, String itemName,String status, String quantity) throws Exception{
    
        String sql ="DELETE FROM bill_item WHERE billNo=? and itemName=? and status=? and quantity_unit";
         try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                )
         {
             stmt.setString(1, billNo);
             stmt.setString(2, itemName);
             stmt.setString(3, status);
             stmt.setString(4, quantity);
             
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
