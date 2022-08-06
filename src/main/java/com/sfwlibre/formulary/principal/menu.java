/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sfwlibre.formulary.principal;

import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.TransactionDTO;
import com.sfwlibre.formulary.dto.UserDTO;
import com.sfwlibre.formulary.service.CatalogServiceImpl;
import com.sfwlibre.formulary.service.TransactionServiceImpl;
import com.sfwlibre.formulary.service.UsuarioServiceImpl;
import com.sfwlibre.formulary.util.UtilMenu;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Raymundo
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    
    ButtonGroup group = new ButtonGroup();
    public  UserDTO user; 
    
    public menu(UserDTO user) {
        initComponents();
        this.setLocationRelativeTo(null); 
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        UtilMenu util = new UtilMenu();
        UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
        util.loadTableUser(usuarioService.listUser(), jTable1);
        this.user = user;
        group.add(jRadioButtonPersonal1);
        group.add(jRadioButtonPersonal2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldConcepto = new javax.swing.JTextField();
        jTextFieldMonto = new javax.swing.JTextField();
        jLabelMonto = new javax.swing.JLabel();
        jLabelConcepto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelUsuario = new javax.swing.JLabel();
        jComboBoxUsuario = new javax.swing.JComboBox<>();
        jLabelNoTarjeta = new javax.swing.JLabel();
        jLabelMsi = new javax.swing.JLabel();
        jComboBoxMsi = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabelPersonal = new javax.swing.JLabel();
        jRadioButtonPersonal1 = new javax.swing.JRadioButton();
        jRadioButtonPersonal2 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaComentarios = new javax.swing.JTextArea();
        jLabelComentarios = new javax.swing.JLabel();
        jComboBoxNoTarjeta = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido Paterno:");

        jLabel3.setText("Apellido Materno:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Usuario:");

        jLabel7.setText("Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel4.setText("Registrar Transacciones");

        jLabelMonto.setText("Monto:");

        jLabelConcepto.setText("Concepto:");

        jLabel9.setText("Tipo de Pago:");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabelUsuario.setText("Usuario:");

        jLabelNoTarjeta.setText("No Tarjeta:");

        jLabelMsi.setText("Msi:");

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelPersonal.setText("Es Personal?");

        jRadioButtonPersonal1.setText("Si");
        jRadioButtonPersonal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPersonal1ActionPerformed(evt);
            }
        });

        jRadioButtonPersonal2.setText("No");
        jRadioButtonPersonal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPersonal2ActionPerformed(evt);
            }
        });

        jTextAreaComentarios.setColumns(20);
        jTextAreaComentarios.setRows(5);
        jScrollPane2.setViewportView(jTextAreaComentarios);

        jLabelComentarios.setText("Comentarios::");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabelMsi)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxMsi, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(jLabelPersonal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonPersonal1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonPersonal2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabelUsuario)
                .addGap(29, 29, 29)
                .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelNoTarjeta)
                                    .addComponent(jLabelConcepto))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxNoTarjeta, 0, 363, Short.MAX_VALUE)
                                    .addComponent(jTextFieldConcepto))
                                .addGap(56, 56, 56)
                                .addComponent(jLabelMonto)
                                .addGap(29, 29, 29)
                                .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 307, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabelComentarios)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMsi))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNoTarjeta)
                    .addComponent(jComboBoxNoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConcepto)
                    .addComponent(jLabelMonto)
                    .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPersonal)
                    .addComponent(jRadioButtonPersonal1)
                    .addComponent(jRadioButtonPersonal2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelComentarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jMenu1.setText("Registrar Usuarios");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Listar Usuarios");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Registrar transacciones");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          String name = jTextField1.getText();
          String apellidoP = jTextField2.getText();
          String apellidoM = jTextField3.getText();
          String user = jTextField6.getText();
          String password = jTextField7.getText();
          
          UserDTO userDTO = new UserDTO();
          userDTO.setName(name);
          userDTO.setLastName(apellidoP);
          userDTO.setUser(name);
          userDTO.setPassword(password);
          UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
          usuarioService.createUser(userDTO);
          UtilMenu util = new UtilMenu();
          util.clearFields(jTextField1);
          util.clearFields(jTextField2);
          util.clearFields(jTextField3);
          util.clearFields(jTextField6);
          util.clearFields(jTextField7);
          jPanel1.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
          JOptionPane.showMessageDialog(null, "Event enableed");
          
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel4.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);    
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        UtilMenu util = new UtilMenu();
        UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
        util.loadTableUser(usuarioService.listUser(), jTable1);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);    
        jPanel3.setVisible(true);
        jPanel4.setVisible(true);
        UtilMenu util = new UtilMenu();
        
        CatalogServiceImpl catalogService = new CatalogServiceImpl();
        util.loadCombo(catalogService.listCatalog(), jComboBoxMsi);
        util.loadCombo(catalogService.listCatalogUsers(user.getId()), jComboBoxUsuario);
        String[] strArray = new String[] {"Una sola excibicion","A meses sin intereses", "A meses con intereses"};
        
        util.loadCombo(strArray, jComboBox1);
        util.loadCombo(catalogService.listCatalogCards(), jComboBoxNoTarjeta);
        hideFormularyTransaction();
        
       
        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        
        util.loadTableTransactionCashPayment(transactionServiceImpl.getListTransaction(), jTable2);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jRadioButtonPersonal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPersonal1ActionPerformed
          jLabelUsuario.setVisible(false);
          jComboBoxUsuario.setVisible(false);
      
    }//GEN-LAST:event_jRadioButtonPersonal1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
         String seleccionado = (String)jComboBox1.getSelectedItem();
          System.out.println(seleccionado);
          
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        switch (jComboBox1.getSelectedIndex()) {
            case 0:
                   hideFormularyTransaction();
                break;
            case 1:
                showFormularyTransactionOneExibition();
                break;    
            case 2:
                showFormularyTransactionMsi();
                break;
            default:
                throw new AssertionError();
        }
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          int comboTypeTransacction =  jComboBox1.getSelectedIndex();
          UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
          CatalogServiceImpl catalogService = new CatalogServiceImpl();
          TransactionServiceImpl transactionService = new TransactionServiceImpl();
          TransactionDomain transaction = null;
          if( comboTypeTransacction == 1){
                JOptionPane.showMessageDialog(null, "Realizaremos una transaccion a un solo pago");
                transaction = new TransactionDomain();
                transaction.setDescription(jTextFieldConcepto.getText());
                transaction.setAmount(  Integer.valueOf( jTextFieldMonto.getText() ) );
                
                
                transaction.setCard_id( catalogService.getCardsByDescription(String.valueOf( jComboBoxNoTarjeta.getSelectedItem() )) );
                if( UtilMenu.getSelectedButtonText(group).contentEquals("Si") ){
                    transaction.setUser_id(  user.getId() );
                }else{
                    transaction.setUser_id(  usuarioService.getUser(jComboBoxUsuario.getSelectedItem().toString() ));
                }
                transactionService.insertTransactionPaymentCash(transaction);
                
          }else if(comboTypeTransacction == 2){
                transaction = new TransactionDomain();
                System.out.println("value "+ String.valueOf(catalogService.getMsiByDescription(String.valueOf( jComboBoxMsi.getSelectedItem() ))));
                transaction.setDescription(jTextFieldConcepto.getText());
                transaction.setAmount(  Integer.valueOf( jTextFieldMonto.getText() ) );
               
                
                if( UtilMenu.getSelectedButtonText(group).contentEquals("Si") ){
                    transaction.setUser_id(  user.getId() );
                }else{
                    transaction.setUser_id(  usuarioService.getUser(jComboBoxUsuario.getSelectedItem().toString() ));
                }
                transaction.setMsi_id( catalogService.getMsiByDescription(jComboBoxMsi.getSelectedItem().toString()));
                transaction.setCard_id( catalogService.getCardsByDescription(String.valueOf( jComboBoxNoTarjeta.getSelectedItem() )) );
                JOptionPane.showMessageDialog(null, "Realizaremos una transaccion a MSI con un plazo de "+jComboBoxMsi.getSelectedItem()+ " MESES");
                 transactionService.insertTransactionMsi(transaction);
          }
 
        UtilMenu util = new UtilMenu();
        util.loadTableTransactionCashPayment(transactionService.getListTransaction(), jTable2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButtonPersonal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPersonal2ActionPerformed
          jLabelUsuario.setVisible(true);
          jComboBoxUsuario.setVisible(true);
    }//GEN-LAST:event_jRadioButtonPersonal2ActionPerformed

    private void hideFormularyTransaction(){
        jLabelMsi.setVisible(false);
        jComboBoxMsi.setVisible(false);
        jLabelNoTarjeta.setVisible(false);
        jComboBoxNoTarjeta.setVisible(false);
        jLabelConcepto.setVisible(false);
        jTextFieldConcepto.setVisible(false);
        jLabelMonto.setVisible(false);
        jTextFieldMonto.setVisible(false);
        jLabelPersonal.setVisible(false);
        jRadioButtonPersonal1.setVisible(false);
        jRadioButtonPersonal2.setVisible(false);
        jLabelUsuario.setVisible(false);
        jComboBoxUsuario.setVisible(false);
        jLabelComentarios.setVisible(false);
        jTextAreaComentarios.setVisible(false);
        jButton2.setVisible(false);
        
    }
       private void showFormularyTransactionMsi(){
        jLabelMsi.setVisible(true);
        jComboBoxMsi.setVisible(true);
        jLabelNoTarjeta.setVisible(true);
        jComboBoxNoTarjeta.setVisible(true);
        jLabelConcepto.setVisible(true);
        jTextFieldConcepto.setVisible(true);
        jLabelMonto.setVisible(true);
        jTextFieldMonto.setVisible(true);
        jLabelPersonal.setVisible(true);
        jRadioButtonPersonal1.setVisible(true);
        jRadioButtonPersonal2.setVisible(true);
        jLabelUsuario.setVisible(true);
        jComboBoxUsuario.setVisible(true);
        jLabelComentarios.setVisible(true);
        jTextAreaComentarios.setVisible(true);
        jButton2.setVisible(true);
    }
       
       private void showFormularyTransactionOneExibition(){
        jLabelNoTarjeta.setVisible(true);
        jComboBoxNoTarjeta.setVisible(true);
        jLabelConcepto.setVisible(true);
        jTextFieldConcepto.setVisible(true);
        jLabelMonto.setVisible(true);
        jTextFieldMonto.setVisible(true);
        jLabelPersonal.setVisible(true);
        jRadioButtonPersonal1.setVisible(true);
        jRadioButtonPersonal2.setVisible(true);
        jLabelUsuario.setVisible(true);
        jComboBoxUsuario.setVisible(true);
        jLabelComentarios.setVisible(true);
        jTextAreaComentarios.setVisible(true);
        jLabelMsi.setVisible(false);
        jComboBoxMsi.setVisible(false);
        jButton2.setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxMsi;
    private javax.swing.JComboBox<String> jComboBoxNoTarjeta;
    private javax.swing.JComboBox<String> jComboBoxUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelComentarios;
    private javax.swing.JLabel jLabelConcepto;
    private javax.swing.JLabel jLabelMonto;
    private javax.swing.JLabel jLabelMsi;
    private javax.swing.JLabel jLabelNoTarjeta;
    private javax.swing.JLabel jLabelPersonal;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonPersonal1;
    private javax.swing.JRadioButton jRadioButtonPersonal2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextAreaComentarios;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldConcepto;
    private javax.swing.JTextField jTextFieldMonto;
    // End of variables declaration//GEN-END:variables
}
