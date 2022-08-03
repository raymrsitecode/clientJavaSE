/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.util;

import com.sfwlibre.formulary.dto.CatalogDTO;
import com.sfwlibre.formulary.dto.UserDTO;
import java.util.List;
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
    
    public void loadTable(List<UserDTO> list, JTable jtable){
        String columns[] = { "ID", "Name", "Age" };
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
    
    public void clearFields(JTextField jt){
        jt.setText("");
    }
    
     public void loadCombo(List<CatalogDTO> list, JComboBox jCombo){
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            jCombo.setModel( dcm );
        for (CatalogDTO catalog : list) {
            jCombo.addItem(catalog.getDescription());
            
        }
    }
     
     
     
}
