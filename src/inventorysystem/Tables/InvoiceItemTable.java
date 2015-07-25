/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.Tables;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import inventorysystem.Beans.*;
import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author srole_000
 */
public class InvoiceItemTable {
    
    public static InvoiceItem getRow(int invoiceNo, String itemName) throws SQLException {
        String sql = "SELECT * FROM `invoice_item` WHERE invoiceNo=? AND itemName=?";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, invoiceNo);
                    stmt.setString(2, itemName);
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      InvoiceItem bean = new InvoiceItem();
                      bean.setInvoiceNo(invoiceNo);
                      bean.setItemName(rs.getString("itemName"));
                      bean.setNoOfBox(rs.getInt("noOfBox"));
                      bean.setAgentPrice_pack(rs.getFloat("agentPrice_Pack"));
                      bean.setWsPrice_pack(rs.getFloat("wsPrice_Pack"));
                      bean.setRtailPrice_pack(rs.getFloat("retailPrice_Pack"));
                      bean.setRemainingCapacity(rs.getInt("remainingCapacity_Box"));
                      bean.setTotal(rs.getFloat("total"));
                      bean.setStockId(rs.getInt("stockId"));
                      bean.setTableId(rs.getInt("tableID"));
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

    public static boolean insert(InvoiceItem bean) throws Exception{
    
        String sql="INSERT INTO invoice_item(invoiceNo,itemName,noOfBox,agentPrice_Pack,wsPrice_Pack,retailPrice_Pack,remainingCapacity_Box,total,stockId,companyName)"+
                    "values(?,?,?,   ?,?,?,?, ?,?,?);";
        ResultSet keys=null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            stmt.setInt(1, bean.getInvoiceNo());            
            stmt.setString(2, bean.getItemName());
            stmt.setInt(3,bean.getNoOfBox());
            stmt.setFloat(4, bean.getAgentPrice_pack());
            stmt.setFloat(5, bean.getWsPrice_pack());
            stmt.setFloat(6, bean.getRtailPrice_pack());
            stmt.setInt(7, bean.getRemainingCapacity());
            stmt.setFloat(8,bean.getTotal());
            stmt.setFloat(9,bean.getStockId());
            stmt.setString(10,bean.getCompanyName());
            
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
    
    
    public static boolean update(InvoiceItem bean) throws Exception{
    
        String sql="UPDATE invoice_item SET "
                + "noOfBox=?, "
                + "agentPrice_Pack=?, "
                + "wsPrice_Pack=?, "
                + "retailPrice_Pack=?, "
                + "remainingCapacity_Box=?, "
                + "total=?, "
                + "stockId=?, "
                + "companyName=? "
                + "WHERE invoiceNo=? "
                + "AND itemName=? ";
                
        
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ){
            
            stmt.setInt(1,bean.getNoOfBox());
            stmt.setFloat(2, bean.getAgentPrice_pack());
            stmt.setFloat(3, bean.getWsPrice_pack());
            stmt.setFloat(4, bean.getRtailPrice_pack());
            stmt.setInt(5, bean.getRemainingCapacity());
            stmt.setFloat(6,bean.getTotal());
            stmt.setFloat(7,bean.getStockId());
            stmt.setString(8,bean.getCompanyName());
            stmt.setInt(9, bean.getInvoiceNo());            
            stmt.setString(10, bean.getItemName());
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
           
        }
        return true;
    }
     
   
    public static float getBill(int invoiceNo){
        String sql="SELECT sum(total) FROM `invoice_item` WHERE invoiceNo=?";
        ResultSet rs = null;
        float price;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setInt(1, invoiceNo);
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
    
     public static  TableModel getInvoiceDetailsToTable(int invoiceNo){  
     String sql="SELECT invoiceNo, itemName, noOfBox, agentPrice_Pack, total FROM invoice_item WHERE invoiceNo=?";
      ResultSet rs=null;
     try(
        Connection conn = DBUtil.getConnection(DBType.MYSQL);
        Statement stmt = conn.createStatement();
       
        PreparedStatement ps = conn.prepareStatement(sql);
    ){
        
            //DeliveryNote dvn=new DeliveryNote();  
           // ResultSet rs =dvn.getRs();
            ps.setInt(1,invoiceNo);
            rs = ps.executeQuery();
            
            ResultSetMetaData md = rs.getMetaData();
        
            int columnCount = md.getColumnCount();
        
            Vector data = new Vector(columnCount);
            Vector row = new Vector(columnCount);
            Vector columnNames = new Vector(columnCount);
        
            //add column names
            columnNames.addElement("No");
            columnNames.addElement("invoiceNo");
            columnNames.addElement("itemName");
            columnNames.addElement("noOfBox");
            columnNames.addElement("agentPrice_Pack");
            columnNames.addElement("total");
            
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
    
      public static  TableModel getChangedItemsToTable(String itemName){  
      String sql="SELECT invoiceNo, itemName, agentPrice_Pack,remainingCapacity_Box FROM invoice_item WHERE itemName=? and remainingCapacity_Box >0 ";
      ResultSet rs=null;
     try(
        Connection conn = DBUtil.getConnection(DBType.MYSQL);
        Statement stmt = conn.createStatement();
       
        PreparedStatement ps = conn.prepareStatement(sql);
    ){
        
            //DeliveryNote dvn=new DeliveryNote();  
           // ResultSet rs =dvn.getRs();
            ps.setString(1,itemName);
            rs = ps.executeQuery();
            
            ResultSetMetaData md = rs.getMetaData();
        
            int columnCount = md.getColumnCount();
        
            Vector data = new Vector(columnCount);
            Vector row = new Vector(columnCount);
            Vector columnNames = new Vector(columnCount);
        
            //add column names
            
            columnNames.addElement("Invoice No");
            columnNames.addElement("Item Name");
            columnNames.addElement("Agent Price (Pack)");
            columnNames.addElement("Remainig Boxes");
            
            int j=0;                    
            while (rs.next()) 
            {
                
                 //row.addElement(++j);
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
    
     
     public static boolean delete(int invoiceNo, String itemName,String companyName) throws Exception{
    
        String sql ="DELETE FROM invoice_item WHERE invoiceNo=? and itemName=? and companyName=?";
         try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                )
         {
             stmt.setInt(1, invoiceNo);
             stmt.setString(2, itemName);
             stmt.setString(3, companyName);
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
     
     
     
     public static InvoiceItem getLastRow(String itemName, String companyName) throws SQLException {
        String sql = "SELECT * FROM invoice_item WHERE companyName=? and itemName=? order by stockId desc limit 1";
        ResultSet rs = null;
        try(    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
                    stmt.setString(1, companyName);
                    stmt.setString(2, itemName);
                    
                    rs = stmt.executeQuery();
                    
                    if(rs.next())
                    {
                      InvoiceItem bean = new InvoiceItem();
                      bean.setInvoiceNo(rs.getInt("invoiceNo"));
                      bean.setItemName(rs.getString("itemName"));
                      bean.setNoOfBox(rs.getInt("noOfBox"));
                      bean.setAgentPrice_pack(rs.getFloat("agentPrice_Pack"));
                      bean.setWsPrice_pack(rs.getFloat("wsPrice_Pack"));
                      bean.setRtailPrice_pack(rs.getFloat("retailPrice_Pack"));
                      bean.setRemainingCapacity(rs.getInt("remainingCapacity_Box"));
                      bean.setTotal(rs.getFloat("total"));
                      bean.setStockId(rs.getInt("stockId"));
                      bean.setTableId(rs.getInt("tableID"));
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

     // compare the current item prices with privious item price
      public static boolean isCompareItems(String itemName, String companyName) throws SQLException {
          
        
            Item i = ItemTable.getRow(itemName);
            
            InvoiceItem ii = InvoiceItemTable.getLastRow(itemName, companyName);
           
            if(Float.compare(i.getAgentPrice_pack(),ii.getAgentPrice_pack())!=0){
                return false;
            }
            
            if(Float.compare(i.getWsPrice_pack(),ii.getWsPrice_pack())!=0){
                return false;
            }
            
            if(Float.compare(i.getRetailPrice_pack(),ii.getRtailPrice_pack())!=0){
                return false;
            }
            
          
        
              return true;  
        }
    

     
}
