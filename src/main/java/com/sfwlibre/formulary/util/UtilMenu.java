/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.util;

import com.sfwlibre.formulary.dto.CatalogDTO;
import com.sfwlibre.formulary.dto.CommentDTO;
import com.sfwlibre.formulary.dto.PaymentDTO;
import com.sfwlibre.formulary.dto.TransactionDTO;
import com.sfwlibre.formulary.dto.UserDTO;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raymrsitecode
 */
public class UtilMenu {
    
    public void loadTableUser(List<UserDTO> list, JTable jtable){
        String columns[] = { "Nombre", "Apellido", "Usuario" };
        String data[][] = new String[8][3];
        int  i = 0;
        
        for (UserDTO userDTO : list) {
            data[i][0] = userDTO.getName();
            data[i][1] = userDTO.getLastName();
            data[i][2] = userDTO.getUser();
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columns);
        jtable.setModel(model);
        
    }
    
     public void loadTableTransactionCashPayment(List<TransactionDTO> list, JTable jtable){
        String columns[] = { "ID","No Tarjeta", "Concepto", "plazo","Usuario","Monto" };
                System.out.println(list.size());

        String data[][] = new String[list.size()][6];
        int  i = 0;
        
        for (TransactionDTO transactionDTO : list) {
            data[i][0] = String.valueOf(transactionDTO.getId());
            data[i][1] = transactionDTO.getCard() != null ? transactionDTO.getCard() : "";
            data[i][2] = transactionDTO.getDescription();
            data[i][3] = transactionDTO.getMsi();
            data[i][4] = transactionDTO.getUser();
            data[i][5] = String.valueOf(transactionDTO.getAmount());
            
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columns);
        jtable.setModel(model);
        
    }
     
     
     public void loadTableComments(List<CommentDTO> list, JTable jtable){
        String columns[] = { "ID","Comentario", "Fecha" };
                System.out.println(list.size());

        String data[][] = new String[list.size()][3];
        int  i = 0;
        if(!list.isEmpty()){
        for (CommentDTO commentDTO : list) {
            data[i][0] = String.valueOf(commentDTO.getId());
            data[i][1] = commentDTO.getDescription();
            data[i][2] = commentDTO.getDate_register().toString();
            
            i++;
        }    
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        jtable.setModel(model);
        
    }
     
      public void loadTablePayments(List<PaymentDTO> list, JTable jtable){
        String columns[] = { "ID","MONTO", "PAGADO","FECHA DEL PAGO ", "FECHA DE REGISTRO" };
                System.out.println(list.size());

        String data[][] = new String[list.size()][5];
        int  i = 0;
        if(!list.isEmpty()){
        for (PaymentDTO paymentDTO : list) {
            data[i][0] = String.valueOf(paymentDTO.getId());
            data[i][1] = String.valueOf(paymentDTO.getAmount());
            data[i][2] = paymentDTO.isIsPayed() ? "SI": "NO";
            data[i][3] = paymentDTO.getDatePayout().toString();
            data[i][4] = paymentDTO.getDateRegister().toString();
            
            i++;
        }    
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        jtable.setModel(model);
        
    }
    
    public void clearFields(JTextField jt){
        jt.setText("");
    }
    
     public void loadCombo(List<CatalogDTO> list, JComboBox jCombo){
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            jCombo.setModel( dcm );
            jCombo.addItem("Seleccione...");
        for (CatalogDTO catalog : list) {
            jCombo.addItem(catalog.getDescription());
            
        }
    }
     
     public void loadCombo(String[] list, JComboBox jCombo){
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            jCombo.setModel( dcm );
            jCombo.addItem("Seleccione...");
        for (String catalog : list) {
            jCombo.addItem(catalog);
            
        }
    }
     

     
       public static String getSelectedButtonText(ButtonGroup buttonGroup) { 
          for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); 
                          buttons.hasMoreElements();) 
                  { 
              AbstractButton button = buttons.nextElement(); 
              if (button.isSelected()) { 
                      return button.getText(); 
               } 
              } 
                return null; 
           }
}
