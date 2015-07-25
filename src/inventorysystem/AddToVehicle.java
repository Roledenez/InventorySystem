/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem;

import inventorysystem.Beans.InvoiceItem;
import inventorysystem.Beans.Item;
import inventorysystem.Beans.Vehical;
import inventorysystem.Beans.VehicalInventory;
import inventorysystem.Beans.VehicalItem;
import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import inventorysystem.Tables.InvoiceItemTable;
import inventorysystem.Tables.ItemTable;
import inventorysystem.Tables.VehicalInventoryTable;
import inventorysystem.Tables.VehicalItemTable;
import inventorysystem.Tables.VehicalTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author HP
 */
public class AddToVehicle extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddToVehicle
     */
    AddVehical av;
    public InvoiceItem i = new InvoiceItem();
    
    public AddToVehicle() {
        initComponents();
        
        // disable featues
        //
        
        nameCmb.setEnabled(false);
        vehicalNoTxb.setEnabled(false);
        dateDtp.setEnabled(false);
        addVehicalTxb.setEnabled(false);
        
        chooseTxb.setEnabled(false);
        newTxb.setEnabled(true);
         vehicalNoTxb.setText("");
         
         
         
        //// get vehical details
        String sql = "SELECT * FROM vehical";
        try (
        Connection conn = DBUtil.getConnection(DBType.MYSQL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
    ){
            if(nameCmb.getItemCount()!=0)
             nameCmb.removeAllItems();
            while(rs.next())
            {
                nameCmb.addItem(rs.getString("vehicalName"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddToVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
         sql = "SELECT * FROM company";
        try (
        Connection conn = DBUtil.getConnection(DBType.MYSQL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
    ){
            if(companyCmbx.getItemCount()!=0)
             companyCmbx.removeAllItems();
            while(rs.next())
            {
                companyCmbx.addItem(rs.getString("name"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddToVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /////////////////////////////////////////////////////
         itemNameCmbx.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
          @Override
          public void keyReleased(KeyEvent evt){
              String str = itemNameCmbx.getEditor().getItem().toString();
              if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90 || evt.getKeyCode()>=96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8)
               {
                  try {
                      itemNameCmbx.setModel(ItemTable.getList(str));
                      if(itemNameCmbx.getItemCount()>0){
                         itemNameCmbx.showPopup();
                         if(evt.getKeyCode()!=8){
                             ((JTextComponent)itemNameCmbx.getEditor().getEditorComponent()).select(str.length(), itemNameCmbx.getEditor().getItem().toString().length());
                         }else{
                             itemNameCmbx.getEditor().setItem(str);
                         }
                      }else{
                          itemNameCmbx.getEditor().setItem(str);
                      }
                  } catch (SQLException ex) {
                      Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                  }
               }
           }
       });
        
        //////////////////////////////////////////////////////
         
          //////////////////////////////////////////////////////////////
       itemNameCmbx.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
          @Override
          public void keyReleased(KeyEvent evt){
              if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                  i.setItemName(itemNameCmbx.getSelectedItem().toString());
                  i.setCompanyName(companyCmbx.getSelectedItem().toString());
                  redundentItemTable.setModel(InvoiceItemTable.getChangedItemsToTable(itemNameCmbx.getSelectedItem().toString()));
              }
           }
       });
       
       /////////////////////////////////////////////////////////////////////////////
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addVehicalTxb = new javax.swing.JButton();
        chooseTxb = new javax.swing.JButton();
        quantityBoxTxb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        vehicalNoTxb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameCmb = new javax.swing.JComboBox();
        msgLbl = new javax.swing.JLabel();
        dateDtp = new datechooser.beans.DateChooserCombo();
        newTxb = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        redundentItemTable = new javax.swing.JTable();
        itemNameCmbx = new javax.swing.JComboBox();
        companyCmbx = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add to Vehicle");

        addVehicalTxb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        addVehicalTxb.setText("+");
        addVehicalTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVehicalTxbActionPerformed(evt);
            }
        });

        chooseTxb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        chooseTxb.setText("Choose");
        chooseTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseTxbActionPerformed(evt);
            }
        });

        quantityBoxTxb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        jLabel5.setText("Add to vehicle");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        vehicalNoTxb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setText("Vehicle No:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Quantity(Boxes)");

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(dataTable);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Item Name");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel1.setText("Name of Lorry");

        nameCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCmbActionPerformed(evt);
            }
        });

        msgLbl.setText("jLabel6");

        dateDtp.setFormat(2);

        newTxb.setText("New");
        newTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTxbActionPerformed(evt);
            }
        });

        redundentItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(redundentItemTable);

        itemNameCmbx.setEditable(true);
        itemNameCmbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameCmbxActionPerformed(evt);
            }
        });

        jLabel6.setText("Company Name");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Cancel");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehicalNoTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chooseTxb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newTxb))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(addVehicalTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(companyCmbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateDtp, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(itemNameCmbx, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quantityBoxTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(msgLbl))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addVehicalTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicalNoTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newTxb))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemNameCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityBoxTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(msgLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jToggleButton1)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addVehicalTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVehicalTxbActionPerformed
        // TODO add your handling code here:
        if ( av!=null){
            av.dispose();
        }
        av = new AddVehical();
        av.setVisible(true);
        av.setAlwaysOnTop(true);
    }//GEN-LAST:event_addVehicalTxbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(redundentItemTable.getSelectedRow()>=0)
        {
        
        try {
            // get Item details
            
            VehicalItem v = new VehicalItem();
            v.setVehicalName(nameCmb.getSelectedItem().toString());
            //v.setVehicalNo(title); add this one letter
            v.setQuantityBox(InputHelper.getIntegerInput(quantityBoxTxb.getText()));
            v.setDate(InputHelper.getValidFormatedDate(dateDtp.getText().toString())); //use system date or datetime picker
            v.setItemName(itemNameCmbx.getSelectedItem().toString());

            Item i =ItemTable.getRow(v.getItemName());
            
            v.setQuantityUnit(v.getQuantityBox()*i.getUnitPerBox());
            
             String invoiceNo= redundentItemTable.getModel().getValueAt(redundentItemTable.getSelectedRow(), 0).toString();
             String itemName= redundentItemTable.getModel().getValueAt(redundentItemTable.getSelectedRow(), 1).toString();
                        
             InvoiceItem newInvoie = InvoiceItemTable.getRow(InputHelper.getIntegerInput(invoiceNo), itemName);
                        
            if(newInvoie.getRemainingCapacity()>=v.getQuantityBox()){ // check the current quantity greather than remaining
            if(VehicalItemTable.insert(v)){ // check the data are inserted to the vehical_item table
                newInvoie.setRemainingCapacity(newInvoie.getRemainingCapacity()-v.getQuantityBox());
                if(InvoiceItemTable.update(newInvoie)){ // update the item table
                    // update vehical inventory
                    VehicalInventory vehicalInventory = VehicalInventoryTable.getRow(v.getVehicalName(),itemName,companyCmbx.getSelectedItem().toString());
                    int q = vehicalInventory.getQuantityUnit()+v.getQuantityUnit();
                    vehicalInventory.setQuantityUnit(q);
                    
                    // update vehical inventory
                    //VehicalInventory vi = VehicalInventoryTable.getRow(nameCmb.getSelectedItem().toString(), itemNameCmbx.getSelectedItem().toString());
                    //vi.setItemName(itemNameTxb.getText());
                    //vi.setQuantityUnit(vi.getQuantityUnit()+(InputHelper.getIntegerInput(quantityBoxTxb.getText())*i.getUnitPerBox()));
                    //vi.setVehicalName(nameCmb.getSelectedItem().toString());
                    
                    if(VehicalInventoryTable.update(vehicalInventory)){ // update the vehical stock
                        
                        //update the current stock inrespect to the invoiceNo in invoice_item table
                       
                        
                            redundentItemTable.setModel(InvoiceItemTable.getChangedItemsToTable(itemNameCmbx.getSelectedItem().toString()));
                        
                        
                            dataTable.setModel(VehicalItemTable.getVehicalDetailsToTable(v.getVehicalName(), v.getDate()));
                        
                    msgLbl.setText("Successfully inserted");
                    }else{
                    msgLbl.setText("Vehical stock not updated");
                    }
                  
                }else{
                msgLbl.setText("Current stock not updated");
                }
            }
            }else{
                msgLbl.setText("Current stock out of hand");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        }else{
            JOptionPane.showMessageDialog(null, "Difference prices are available, please select one row in the table", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nameCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameCmbActionPerformed
        try {
            // TODO add your handling code here:

            Vehical v = VehicalTable.getRow(nameCmb.getSelectedItem().toString());
            vehicalNoTxb.setText(v.getVehicalNo());
            
        } catch (SQLException ex) {
            Logger.getLogger(AddToVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_nameCmbActionPerformed

    private void chooseTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseTxbActionPerformed
        // TODO add your handling code here:
        nameCmb.setEnabled(false);
        vehicalNoTxb.setEnabled(false);
        dateDtp.setEnabled(false);
        addVehicalTxb.setEnabled(false);
        
        chooseTxb.setEnabled(false);
        newTxb.setEnabled(true);
    }//GEN-LAST:event_chooseTxbActionPerformed

    private void newTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTxbActionPerformed
        // TODO add your handling code here:
        
        nameCmb.setEnabled(true);
        vehicalNoTxb.setEnabled(true);
        dateDtp.setEnabled(true);
        addVehicalTxb.setEnabled(true);
        
        chooseTxb.setEnabled(true);
        newTxb.setEnabled(false);
    }//GEN-LAST:event_newTxbActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(dataTable.getSelectedRow()>=0){
        // get invoice_item table details from user
      JTextField invoiceNo = new JTextField(15);
      JTextField companyName = new JTextField(15);
      
      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Enter Invoice No :"));
      myPanel.add(invoiceNo);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Enter Company Name"));
      myPanel.add(companyName);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter InvoiceNo and CompanyName", JOptionPane.OK_CANCEL_OPTION);
      
      if (result == JOptionPane.OK_OPTION) {
        
        try {
            
            //table 01 data
            //String invoiceNo= redundentItemTable.getModel().getValueAt(redundentItemTable.getSelectedRow(), 0).toString();
            
            // datablse 02 data
            //String invoiceNo= dataTable.getModel().getValueAt(dataTable.getSelectedRow(), 1).toString();
            String vehicalName= dataTable.getModel().getValueAt(dataTable.getSelectedRow(), 0).toString();
            String itemName= dataTable.getModel().getValueAt(dataTable.getSelectedRow(), 1).toString();
            String quantity= dataTable.getModel().getValueAt(dataTable.getSelectedRow(), 2).toString();
            //String date= dataTable.getModel().getValueAt(dataTable.getSelectedRow(), 3).toString();
            
            // GUI data
            //String companyName = companyCmbx.getSelectedItem().toString();
            Date date = InputHelper.getValidFormatedDate(dateDtp.getText().toString());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            //Date ddate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(date);
            if(VehicalItemTable.delete(vehicalName,itemName,sqldate.toString())){
                
                // update the vehical inventory
                VehicalInventory vi = VehicalInventoryTable.getRow(vehicalName.toString(), itemName.toString(),companyCmbx.getSelectedItem().toString());
                
                Item item = ItemTable.getRow(itemName.toString());
                
                vi.setQuantityUnit(vi.getQuantityUnit()-(InputHelper.getIntegerInput(quantity)/item.getUnitPerBox()));
                if(VehicalInventoryTable.update(vi)){
                //update the invoice_item table
                int x =InputHelper.getIntegerInput(invoiceNo.getText().toString());
                
                InvoiceItem invoiceItem = InvoiceItemTable.getRow(InputHelper.getIntegerInput(invoiceNo.getText().toString()), itemName);
                invoiceItem.setRemainingCapacity(invoiceItem.getRemainingCapacity()+(InputHelper.getIntegerInput(quantity)/item.getUnitPerBox()));
                
                if(InvoiceItemTable.update(invoiceItem)){
                        
                        dataTable.setModel(VehicalItemTable.getVehicalDetailsToTable(vehicalName, date));
                        
                        redundentItemTable.setModel(InvoiceItemTable.getChangedItemsToTable(itemNameCmbx.getSelectedItem().toString()));
                
                }else{
                    JOptionPane.showMessageDialog(null, "Invoice Data not updated", "Error", JOptionPane.ERROR_MESSAGE);
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Vehical Data not updated", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Can't delete the row", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row to delete", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void itemNameCmbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameCmbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameCmbxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddToVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddToVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddToVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddToVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddToVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVehicalTxb;
    private javax.swing.JButton chooseTxb;
    private javax.swing.JComboBox companyCmbx;
    private javax.swing.JTable dataTable;
    private datechooser.beans.DateChooserCombo dateDtp;
    private javax.swing.JComboBox itemNameCmbx;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel msgLbl;
    private javax.swing.JComboBox nameCmb;
    private javax.swing.JButton newTxb;
    private javax.swing.JTextField quantityBoxTxb;
    private javax.swing.JTable redundentItemTable;
    private javax.swing.JTextField vehicalNoTxb;
    // End of variables declaration//GEN-END:variables
}
