/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sfwlibre.formulary.principal;

import com.sfwlibre.formulary.domain.PaymentDomain;
import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.CommentDTO;
import com.sfwlibre.formulary.dto.PaymentDTO;
import com.sfwlibre.formulary.dto.TransactionDTO;
import com.sfwlibre.formulary.dto.UserDTO;
import com.sfwlibre.formulary.service.CatalogServiceImpl;
import com.sfwlibre.formulary.service.ComentaryServiceImpl;
import com.sfwlibre.formulary.service.TransactionServiceImpl;
import com.sfwlibre.formulary.service.UsuarioServiceImpl;
import com.sfwlibre.formulary.util.UtilMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

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
    public PaymentDTO paymentDTO;
    public TransactionDTO transactionDTO;
     final JPopupMenu popupMenu = new JPopupMenu();
     final JPopupMenu popupMenuPagos = new JPopupMenu();
     JMenuItem showStatusPayments = new JMenuItem("Mostrar pagos realizados");
     JMenuItem agregarAbono = new JMenuItem("Agregar Abono");
     JMenuItem pagoCompletado = new JMenuItem("Completar Pago");
     JMenuItem showCommments = new JMenuItem("Mostrar comentarios");
     
     JMenuItem markPaymentLikePayed = new JMenuItem("Marcar como pagado.");
     
    public menu(UserDTO user) {
        initComponents();
        this.setLocationRelativeTo(null); 
        jPanel1.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        UtilMenu util = new UtilMenu();
        UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
        util.loadTableUser(usuarioService.listUser(), jTable1);
        this.user = user;
        group.add(jRadioButtonPersonal1);
        group.add(jRadioButtonPersonal2);
        
        showStatusPayments.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(null, "Right-click performed on table and choose DELETE");
                 
                   String selectedCellValue = (String) jTable2.getValueAt(jTable2.getSelectedRow() , jTable2.getSelectedColumn());
                   System.out.println(selectedCellValue);
                   
            }
        });
        
        agregarAbono.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(null, "Right-click performed on table and choose DELETE");
                   String selectedCellValue = (String) jTable2.getValueAt(jTable2.getSelectedRow() , jTable2.getSelectedColumn());
                   paymentDTO = new PaymentDTO();
                   paymentDTO.setId(Integer.valueOf(selectedCellValue) );
                   UtilMenu util = new UtilMenu();
                   TransactionServiceImpl transactionService = new TransactionServiceImpl();
                   List<PaymentDTO> listPayments = transactionService.getListTransactionPayment(paymentDTO.getId());
                   
                   if( listPayments.isEmpty() ) {
                       JOptionPane.showMessageDialog(null, "No existen pagos asociados a al registro");
                       int result = JOptionPane.showConfirmDialog(null,"Desea realizar el registro de un pago?");
                       
                       if(result == 0){
                           jPanel6.setVisible(true);
                         
                       }else{
                         
                           jPanel6.setVisible(false);
                       }
                       
                   }else{
                      
                       util.loadTablePayments(listPayments, jTable3); 
                       jPanel6.setVisible(true);
                   }
                    jPanel5.setVisible(false);
                 
                   
            }
        });
        
        pagoCompletado.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   JOptionPane.showMessageDialog(null, "Right-click performed on table and choose DELETE");
                 
                   String selectedCellValue = (String) jTable2.getValueAt(jTable2.getSelectedRow() , jTable2.getSelectedColumn());
                   System.out.println(selectedCellValue);
                   
            }
        });
        
        showCommments.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   String selectedCellValue = (String) jTable2.getValueAt(jTable2.getSelectedRow() , jTable2.getSelectedColumn());
                   System.out.println(selectedCellValue);
                   transactionDTO = new TransactionDTO();
                   transactionDTO.setId(Integer.parseInt(selectedCellValue));
                   ComentaryServiceImpl commentaryService = new ComentaryServiceImpl();
                   UtilMenu util = new UtilMenu();
                   List<CommentDTO> listComments = commentaryService.getListComments(Integer.parseInt(selectedCellValue));
                   jPanel6.setVisible(false);
                   if( listComments.isEmpty() ){
                        JOptionPane.showMessageDialog(null,"La operación no tiene relacionado ningún comentario");
                        int result = JOptionPane.showConfirmDialog(null, "Deseas agregar un comentario a esta transaccion?");
                        if(result == 0){
                         util.loadTableComments(listComments, jTable4); 
                         jPanel5.setVisible(true);   
                         
                        }else{
                            jPanel5.setVisible(false);
                          
                        }
                        
                         
                   }else{
                         util.loadTableComments(listComments, jTable4);    
                         jPanel5.setVisible(true);
                         
                   }
                   
                   
                   
            }
        });
         popupMenu.add(showStatusPayments);
         popupMenu.add(agregarAbono);
         popupMenu.add(pagoCompletado);
         popupMenu.add(showCommments);
        jTable2.setComponentPopupMenu(popupMenu);
        
        
        markPaymentLikePayed.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   String selectedCellValue = (String) jTable3.getValueAt(jTable3.getSelectedRow() , jTable3.getSelectedColumn());
                   System.out.println(selectedCellValue);
                   TransactionServiceImpl transaccionService = new TransactionServiceImpl();
                   PaymentDomain paymentDomain = new PaymentDomain();
                   
                   paymentDomain.setBreakDownId(Integer.parseInt(selectedCellValue));
                   paymentDomain.setIsPayed(true);
                   transaccionService.updateTransactionPaymentToPayed(paymentDomain);
                   
                   JOptionPane.showMessageDialog(null, "El pago se ha actualizado");
                   UtilMenu util = new UtilMenu();
                  
                   List<PaymentDTO> listPayments = transaccionService.getListTransactionPayment(paymentDTO.getId());
                   util.loadTablePayments(listPayments, jTable3);
                   
                   
                   
            }
        });
        
        popupMenuPagos.add(markPaymentLikePayed);
        jTable3.setComponentPopupMenu( popupMenuPagos);
        
     
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanelTransactions = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaComentarios = new javax.swing.JTextArea();
        jLabelComentarios = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jComboBoxUsuario = new javax.swing.JComboBox<>();
        jLabelPersonal = new javax.swing.JLabel();
        jRadioButtonPersonal1 = new javax.swing.JRadioButton();
        jRadioButtonPersonal2 = new javax.swing.JRadioButton();
        jTextFieldMonto = new javax.swing.JTextField();
        jLabelMonto = new javax.swing.JLabel();
        jTextFieldConcepto = new javax.swing.JTextField();
        jLabelConcepto = new javax.swing.JLabel();
        jComboBoxNoTarjeta = new javax.swing.JComboBox<>();
        jLabelNoTarjeta = new javax.swing.JLabel();
        jLabelMsi = new javax.swing.JLabel();
        jComboBoxMsi = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 1000));

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        jLabel4.setText("Registrar Transacciones");

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

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextAreaComentarios.setColumns(20);
        jTextAreaComentarios.setRows(5);
        jScrollPane2.setViewportView(jTextAreaComentarios);

        jLabelComentarios.setText("Comentarios:");

        jLabelUsuario.setText("Usuario:");

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

        jLabelMonto.setText("Monto:");

        jLabelConcepto.setText("Concepto:");

        jLabelNoTarjeta.setText("No Tarjeta:");

        jLabelMsi.setText("Msi:");

        javax.swing.GroupLayout jPanelTransactionsLayout = new javax.swing.GroupLayout(jPanelTransactions);
        jPanelTransactions.setLayout(jPanelTransactionsLayout);
        jPanelTransactionsLayout.setHorizontalGroup(
            jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTransactionsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                        .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                        .addComponent(jLabelPersonal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonPersonal1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonPersonal2))
                                    .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                        .addComponent(jLabelComentarios)
                                        .addGap(534, 534, 534))))
                            .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                        .addComponent(jLabelMsi)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxMsi, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                            .addComponent(jLabelNoTarjeta)
                                            .addGap(18, 18, 18)
                                            .addComponent(jComboBoxNoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                            .addGap(528, 528, 528)
                                            .addComponent(jLabelMonto)
                                            .addGap(31, 31, 31)
                                            .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                            .addComponent(jLabelConcepto)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabelUsuario)
                                .addGap(29, 29, 29)
                                .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelTransactionsLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTransactionsLayout.setVerticalGroup(
            jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTransactionsLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMsi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNoTarjeta)
                    .addComponent(jComboBoxNoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConcepto)
                    .addComponent(jLabelMonto)
                    .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPersonal)
                    .addComponent(jRadioButtonPersonal1)
                    .addComponent(jRadioButtonPersonal2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelComentarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(0, 1094, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTable4);

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel10.setText("AGREGAR COMENTARIOS");

        jLabel11.setText("Comentario:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane7.setViewportView(jTextArea2);

        jButton4.setText("Registrar Comentario");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel11)
                                .addGap(0, 944, Short.MAX_VALUE))
                            .addComponent(jScrollPane6)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(425, 425, 425)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel5.setText("AGREGAR PAGO");

        jLabel8.setText("Monto:");

        jButton3.setText("Registrar Pago");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jMenu3.setText("Registrar transacciones");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });

        jMenuItem1.setText("Listado de transacciones");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Registrar Pago recurrente");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        jPanel1.setVisible(false);
        
        jPanel3.setVisible(true);
        jPanel4.setVisible(true);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
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
        
        CatalogServiceImpl catalogService = new CatalogServiceImpl();
        UtilMenu util = new UtilMenu();
        final String CREDICT_CARD = "credit";
        final String DEBIT_CARD = "debit";
        switch (jComboBox1.getSelectedIndex()) {
            case 0:
                   jPanelTransactions.setVisible(false);
                   
                break;
            case 1:
                util.loadCombo(catalogService.listCatalogCards(DEBIT_CARD), jComboBoxNoTarjeta);
                jPanelTransactions.setVisible(true);
                showFormularyTransactionOneExibition();
                
                break;    
            case 2:
                util.loadCombo(catalogService.listCatalogCards(CREDICT_CARD), jComboBoxNoTarjeta);
                jPanelTransactions.setVisible(true);
                showFormularyTransactionMsi();
                break;
            default:
                hideFormularyTransaction();
        }
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          int comboTypeTransacction =  jComboBox1.getSelectedIndex();
          UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
          CatalogServiceImpl catalogService = new CatalogServiceImpl();
          TransactionServiceImpl transactionService = new TransactionServiceImpl();
          ComentaryServiceImpl comentaryService = new ComentaryServiceImpl();
          TransactionDomain transaction = null;
          int transaction_id = 0;
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
                transaction_id = transactionService.insertTransactionPaymentCash(transaction);
                
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
                transaction_id = transactionService.insertTransactionMsi(transaction);
          }
   
        String message = jTextAreaComentarios.getText();
        
        comentaryService.createComentary(message, transaction_id);
        UtilMenu util = new UtilMenu();
        util.loadTableTransactionCashPayment(transactionService.getListTransaction(), jTable2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButtonPersonal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPersonal2ActionPerformed
          jLabelUsuario.setVisible(true);
          jComboBoxUsuario.setVisible(true);
    }//GEN-LAST:event_jRadioButtonPersonal2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           String monto = jTextField4.getText();
           
           TransactionServiceImpl transactionService = new TransactionServiceImpl();
           PaymentDomain payment = new PaymentDomain();
           payment.setAmount( Double.parseDouble(monto));
           payment.setTransactionId( this.paymentDTO.getId() );
           transactionService.inserTransactionPayment(payment);
           
           JOptionPane.showMessageDialog(null, "El pago se ha registrado correctamente");
                   
           UtilMenu util = new UtilMenu();
                  
                   List<PaymentDTO> listPayments = transactionService.getListTransactionPayment(this.paymentDTO.getId());
                   util.loadTablePayments(listPayments, jTable3);
                   jTextField4.setText("");
                       
                    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       String message = jTextArea2.getText();
        ComentaryServiceImpl comentaryService = new ComentaryServiceImpl();
        comentaryService.createComentary(message, transactionDTO.getId());
        
        UtilMenu util = new UtilMenu();
                 
                   util.loadTableComments(comentaryService.getListComments(transactionDTO.getId()), jTable4);
                   
                   jTextArea2.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

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
        jTextAreaComentarios.hide();
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxMsi;
    private javax.swing.JComboBox<String> jComboBoxNoTarjeta;
    private javax.swing.JComboBox<String> jComboBoxUsuario;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTransactions;
    private javax.swing.JRadioButton jRadioButtonPersonal1;
    private javax.swing.JRadioButton jRadioButtonPersonal2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaComentarios;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldConcepto;
    private javax.swing.JTextField jTextFieldMonto;
    // End of variables declaration//GEN-END:variables
}
