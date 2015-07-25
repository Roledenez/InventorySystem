/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import inventorysystem.Beans.Bill;
import inventorysystem.Beans.BillItem;
import inventorysystem.Beans.Discount;
import inventorysystem.Beans.IssueBill;
import inventorysystem.Beans.Item;
import inventorysystem.Beans.Vehical;
import inventorysystem.Beans.VehicalInventory;
import inventorysystem.DB.DBType;
import inventorysystem.DB.DBUtil;
import inventorysystem.Tables.BillItemTable;
import inventorysystem.Tables.BillTable;
import inventorysystem.Tables.DiscountTable;
import inventorysystem.Tables.IssueBillTable;
import inventorysystem.Tables.ItemTable;
import inventorysystem.Tables.ShopTable;
import inventorysystem.Tables.VehicalInventoryTable;
import inventorysystem.Tables.VehicalTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author srole_000
 */
public class Receive extends javax.swing.JInternalFrame {

    /**
     * Creates new form Receive
     */
    Bill bill;

    public Receive() {
        initComponents();

        // enable/disables
        itemNameCmbx.setEnabled(false);
        quantityTxb.setEnabled(false);
        statusCmbo.setEnabled(false);
        newBillTxb.setEnabled(false);

        shopCmbx.setEditable(true);
        nameCmb.setEditable(true);
        //
        nameCmb.removeAllItems();
        shopCmbx.removeAllItems();

        // discount variables
        freeItemRbtn.setSelected(true);
        freeItemRbtn.setEnabled(false);
        manualDisRbtn.setEnabled(false);
        amountTbx.setEditable(false);
        discountBtn.setEnabled(false);
        editBtn.setEnabled(false);
        //////////fill the company details
        String sql = "SELECT * FROM company";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            if (companyCmbx.getItemCount() != 0) {
                companyCmbx.removeAllItems();
            }
            while (rs.next()) {
                companyCmbx.addItem(rs.getString("name"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddToVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///////////////////

        // fill the vehical name combo
        sql = "SELECT * FROM vehical";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                nameCmb.addItem(rs.getString("vehicalName"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddToVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }

        // fill the shop combo
//         sql = "SELECT * FROM shop";
//        try (
//        Connection conn = DBUtil.getConnection(DBType.MYSQL);
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//    ){
//            while(rs.next())
//            {
//                shopCmbx.addItem(rs.getString("name"));
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AddToVehicle.class.getName()).log(Level.SEVERE, null, ex);
//        }
        /////////////////////////////////////////////////////////////////////Search item 
        shopCmbx.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String str = shopCmbx.getEditor().getItem().toString();
                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    try {
                        shopCmbx.setModel(ShopTable.getList(str));
                        if (shopCmbx.getItemCount() > 0) {
                            shopCmbx.showPopup();
                            if (evt.getKeyCode() != 8) {
                                ((JTextComponent) shopCmbx.getEditor().getEditorComponent()).select(str.length(), shopCmbx.getEditor().getItem().toString().length());
                            } else {
                                shopCmbx.getEditor().setItem(str);
                            }
                        } else {
                            shopCmbx.getEditor().setItem(str);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        /////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////Search item 
        itemNameCmbx.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String str = itemNameCmbx.getEditor().getItem().toString();
                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    try {
                        itemNameCmbx.setModel(ItemTable.getList(str));
                        if (itemNameCmbx.getItemCount() > 0) {
                            itemNameCmbx.showPopup();
                            if (evt.getKeyCode() != 8) {
                                ((JTextComponent) itemNameCmbx.getEditor().getEditorComponent()).select(str.length(), itemNameCmbx.getEditor().getItem().toString().length());
                            } else {
                                itemNameCmbx.getEditor().setItem(str);
                            }
                        } else {
                            itemNameCmbx.getEditor().setItem(str);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        ///////////////////////////////////////////////
//        jComboBox1.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
//            
//            public void keyReleased(KeyEvent evt)
//                {
//                    String str = jComboBox1.getEditor().getItem().toString();
//                    if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90 ||evt.getKeyCode()>=65 && evt.getKeyCode()<=90 || evt.getKeyCode()==8)
//                    {
//                        try {
//                            jComboBox1.setModel(VehicalTable.getAll());
//                        } catch (SQLException ex) {
//                            //Logger.getLogger(ItemGUI.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        if(jComboBox1.getItemCount()>0)
//                        {
//                            jComboBox1.showPopup();
//                            if(evt.getKeyCode()!=8)
//                            {
//                                ((JTextComponent)jComboBox1.getEditor().getEditorComponent()).select(str.length(),jComboBox1.getEditor().getItem().toString().length());
//                            }
//                            else
//                            {
//                                jComboBox1.getEditor().setItem(str);
//                            }
//                        }
//                        else
//                        {
//                            jComboBox1.addItem(str);
//                        }
//                    }
//                }
//
//        });
        //////////////////////////////////////////////
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        billNoTxb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dateDtp = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        quantityTxb = new javax.swing.JTextField();
        returnChkbx = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        statusCmbo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        newBillTxb = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        createBillBtn = new javax.swing.JButton();
        nameCmb = new javax.swing.JComboBox();
        msgLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        shopCmbx = new javax.swing.JComboBox();
        itemNameCmbx = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        companyCmbx = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        discountCbx = new javax.swing.JCheckBox();
        freeItemRbtn = new javax.swing.JRadioButton();
        manualDisRbtn = new javax.swing.JRadioButton();
        amountTbx = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        discountBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        totalDiscountLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receiving item");

        jLabel1.setText("Bill NO");

        jLabel2.setText("Date");

        dateDtp.setFormat(2);

        jLabel3.setText("Quantity");

        returnChkbx.setText("Returned");
        returnChkbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnChkbxActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        statusCmbo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Expired", "Damage By Vehical", "Unsold" }));

        jLabel4.setText("Status");

        newBillTxb.setText("New Bill");
        newBillTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBillTxbActionPerformed(evt);
            }
        });

        jLabel5.setText("Vehical Name");

        jLabel6.setText("Shop Name");

        createBillBtn.setText("Create a Bill");
        createBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBillBtnActionPerformed(evt);
            }
        });

        msgLbl.setText("jLabel7");

        jLabel7.setText("Item Name");

        shopCmbx.setEditable(true);

        itemNameCmbx.setEditable(true);

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Company Name");

        companyCmbx.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgLbl)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(companyCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(itemNameCmbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusCmbo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateDtp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityTxb, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(billNoTxb)
                            .addComponent(shopCmbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(createBillBtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(returnChkbx)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(14, 14, 14)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBillTxb)
                            .addComponent(jButton4))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(companyCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(shopCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(billNoTxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(dateDtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(itemNameCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(quantityTxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createBillBtn)
                            .addComponent(newBillTxb))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(returnChkbx)
                    .addComponent(statusCmbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        billTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(billTable);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Total :");

        totalLbl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        totalLbl.setText("0");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Pay");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Discounts"));

        discountCbx.setText("Discount");
        discountCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountCbxActionPerformed(evt);
            }
        });

        buttonGroup1.add(freeItemRbtn);
        freeItemRbtn.setText("Free item");

        buttonGroup1.add(manualDisRbtn);
        manualDisRbtn.setText("Manual discount");

        jLabel10.setText("Amount");

        discountBtn.setText("Add Discount");
        discountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Discount:");

        totalDiscountLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalDiscountLbl.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountTbx, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(discountCbx))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(freeItemRbtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(manualDisRbtn))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(discountBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(editBtn))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(totalDiscountLbl)))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountCbx)
                    .addComponent(freeItemRbtn)
                    .addComponent(manualDisRbtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountTbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountBtn)
                    .addComponent(editBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(totalDiscountLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28)
                        .addComponent(totalLbl)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(totalLbl)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBillBtnActionPerformed
        // TODO add your handling code here:

        // please validate the flieds before perform the below actions
        //disable/enable
        nameCmb.setEnabled(false);
        shopCmbx.setEditable(false);
        billNoTxb.setEnabled(false);
        dateDtp.setEnabled(false);
        shopCmbx.setEnabled(false);
        createBillBtn.setEnabled(false);
        msgLbl.setText("");

        newBillTxb.setEnabled(true);
        itemNameCmbx.setEnabled(true);
        quantityTxb.setEnabled(true);

        bill = new Bill();
        bill.setBillNo(InputHelper.getIntegerInput(billNoTxb.getText()));
        bill.setDate(InputHelper.getValidFormatedDate(dateDtp.getText().toString()));
        try {
            if (BillTable.insert(bill)) {
                msgLbl.setText("Bill was successfully created");
            } else {
                msgLbl.setText("Bill was unable to create");
            }
        } catch (Exception ex) {
            Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createBillBtnActionPerformed

    private void returnChkbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnChkbxActionPerformed
        // TODO add your handling code here:
        if (returnChkbx.isSelected()) {
            statusCmbo.setEnabled(true);
        } else {
            statusCmbo.setEnabled(false);

        }
    }//GEN-LAST:event_returnChkbxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // coding...

        BillItem bi = new BillItem();
        bi.setBillNo(InputHelper.getIntegerInput(billNoTxb.getText()));
        bi.setItemName(itemNameCmbx.getSelectedItem().toString());
        bi.setCompanyName(companyCmbx.getSelectedItem().toString());
        if (!returnChkbx.isSelected()) {
            bi.setStatus("Issued");
            bi.setReason("Issued");
        } else { // if returned there may be extra codes, vehicle inventory must update
            // if it returned as a good return add to the vehicle inventory to that quantity
            // else keep a note and don't add to the vehicle inventory niether current stock or return stock of shop
            bi.setStatus("Returned");
            bi.setReason(statusCmbo.getSelectedItem().toString());
        }

        bi.setQuantityUnit(InputHelper.getIntegerInput(quantityTxb.getText()));

        try {
            Item i = ItemTable.getRow(bi.getItemName()); // get the item data
            bi.setPrice(bi.getQuantityUnit() * i.getWsPrice_unit());
        } catch (SQLException ex) {
            msgLbl.setText("Error: Can't get Item data");
        }

        try {
            VehicalInventory vi = VehicalInventoryTable.getRow(nameCmb.getSelectedItem().toString(), bi.getItemName(), companyCmbx.getSelectedItem().toString());

            if (vi.getQuantityUnit() >= bi.getQuantityUnit()) {
                if (bi.getStatus().equalsIgnoreCase("Issued")) {
                    vi.setQuantityUnit(vi.getQuantityUnit() - bi.getQuantityUnit());
                } else if (bi.getStatus().equalsIgnoreCase("Returned")) {
                    vi.setQuantityUnit(vi.getQuantityUnit() + bi.getQuantityUnit());
                }
                if (BillItemTable.insert(bi)) { // set the bill data

                    if (VehicalInventoryTable.update(vi)) { // update the vehical inventory

                        IssueBill ib = new IssueBill();
                        ib.setBillNo(bi.getBillNo());
                        ib.setShopName(shopCmbx.getSelectedItem().toString());
                        ib.setVehicleName(vi.getVehicalName());
                        if (!IssueBillTable.hasRow(ib.getBillNo())) {
                            if (IssueBillTable.insert(ib)) {   // insert the data to issue bill table for payament perpuse 
                                msgLbl.setText("Successfully added the bill");
                                billTable.setModel(BillItemTable.getBillDetailsToTable(ib.getBillNo()));

                            }
                        } else {
                            msgLbl.setText("Successfully added the bill");
                            billTable.setModel(BillItemTable.getBillDetailsToTable(ib.getBillNo()));
                        }
                        float balance = BillItemTable.getBill(ib.getBillNo()) - DiscountTable.getDiscountForBill(ib.getBillNo());
                        totalLbl.setText(Float.toString(balance));
                    } else {
                        msgLbl.setText("Vehical Inventory not updated");
                    }
                }
            } else {
                msgLbl.setText("Vehical hasn't such a quantity to issue");
            }

        } catch (Exception ex) {
            msgLbl.setText("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newBillTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBillTxbActionPerformed
        // TODO add your handling code here:

        //disable/enable
        nameCmb.setEnabled(true);
        shopCmbx.setEditable(true);
        billNoTxb.setEnabled(true);
        dateDtp.setEnabled(true);
        shopCmbx.setEnabled(true);
        createBillBtn.setEnabled(true);

        itemNameCmbx.setEnabled(false);
        quantityTxb.setEnabled(false);
        newBillTxb.setEnabled(false);


    }//GEN-LAST:event_newBillTxbActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (billNoTxb.getText() != null) {
            Payments p = new Payments("bill", Integer.parseInt(billNoTxb.getText()));
            p.setVisible(true);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ShopUI s = new ShopUI();
        s.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        if (billTable.getSelectedRow() >= 0) {
            String billNo = billTable.getModel().getValueAt(billTable.getSelectedRow(), 1).toString();
            String itemName = billTable.getModel().getValueAt(billTable.getSelectedRow(), 2).toString();
            String status = billTable.getModel().getValueAt(billTable.getSelectedRow(), 3).toString();
            String quantityUnit = billTable.getModel().getValueAt(billTable.getSelectedRow(), 3).toString();

            try {
                if (BillItemTable.delete(billNo, itemName, status, quantityUnit)) {
                    IssueBill issueBill = IssueBillTable.getRow(InputHelper.getIntegerInput(billNo)); // to get the vahical name
                    VehicalInventory vehicalInventoty = VehicalInventoryTable.getRow(issueBill.getVehicleName(), itemName, companyCmbx.getSelectedItem().toString());
                    if (VehicalInventoryTable.update(vehicalInventoty)) {
                        // print the toatla bill

                        // refresh the bill table
                        billTable.setModel(BillItemTable.getBillDetailsToTable(issueBill.getBillNo()));
                    }

                }
            } catch (Exception ex) {
                Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void discountCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountCbxActionPerformed
        // TODO add your handling code here:
        if (discountCbx.isSelected()) {
            freeItemRbtn.setEnabled(true);
            manualDisRbtn.setEnabled(true);
            amountTbx.setEditable(true);
            discountBtn.setEnabled(true);
            editBtn.setEnabled(true);

        } else {
            freeItemRbtn.setEnabled(false);
            manualDisRbtn.setEnabled(false);
            amountTbx.setEditable(false);
            discountBtn.setEnabled(false);
            editBtn.setEnabled(false);
        }

    }//GEN-LAST:event_discountCbxActionPerformed

    private void discountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountBtnActionPerformed
        // TODO add your handling code here:
        //String invoice= billTable.getModel().getValueAt(billTable.getSelectedRow(), 1).toString();
        String itemName = billTable.getModel().getValueAt(billTable.getSelectedRow(), 2).toString();

        Discount d = new Discount();
        d.setBillNo(Integer.parseInt(billNoTxb.getText()));

        if (freeItemRbtn.isSelected()) {
            try {
                // free item discount

                Item i = ItemTable.getRow(itemName);

                d.setQuantity(Integer.parseInt(amountTbx.getText()));
                d.setItemName(itemName);

                d.setType("Free Item Discount");
                d.setTotal(i.getWsPrice_unit() * d.getQuantity()); // make sure that w/s or retail price ?
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Can't get data", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (manualDisRbtn.isSelected()) {
            d.setItemName(null);
            d.setQuantity(0);
            d.setTotal(Float.parseFloat(amountTbx.getText()));
            d.setType("Manual Discount");

        }

        try {
            if (DiscountTable.insert(d)) {
                msgLbl.setText("Discount sucessfully added!");
                totalDiscountLbl.setText(Float.toString(DiscountTable.getDiscountForBill(d.getBillNo())));
                // update total amount of bill
                float balance = BillItemTable.getBill(d.getBillNo()) - DiscountTable.getDiscountForBill(d.getBillNo());
                totalLbl.setText(Float.toString(balance));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Can't insert data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_discountBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receive().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTbx;
    private javax.swing.JTextField billNoTxb;
    private javax.swing.JTable billTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox companyCmbx;
    private javax.swing.JButton createBillBtn;
    private datechooser.beans.DateChooserCombo dateDtp;
    private javax.swing.JButton discountBtn;
    private javax.swing.JCheckBox discountCbx;
    private javax.swing.JButton editBtn;
    private javax.swing.JRadioButton freeItemRbtn;
    private javax.swing.JComboBox itemNameCmbx;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton manualDisRbtn;
    private javax.swing.JLabel msgLbl;
    private javax.swing.JComboBox nameCmb;
    private javax.swing.JButton newBillTxb;
    private javax.swing.JTextField quantityTxb;
    private javax.swing.JCheckBox returnChkbx;
    private javax.swing.JComboBox shopCmbx;
    private javax.swing.JComboBox statusCmbo;
    private javax.swing.JLabel totalDiscountLbl;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
