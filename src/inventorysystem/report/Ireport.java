/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.report;

import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;

/**
 *
 * @author srole_000
 */
public class Ireport extends JFrame{
    public Ireport(String fileName, HashMap para){
        super("Report");
        try(Connection conn = DBUtil.getConnection(DBType.MYSQL)){
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            JasperPrint print = JasperFillManager.fillReport(fileName, para,conn);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        setBounds(10,10,600,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
