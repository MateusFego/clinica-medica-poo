/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.imepac.administrativo.telas;

import br.edu.imepac.administrativo.servicos.GerenciamentoConvenio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class ListaConvenios extends javax.swing.JFrame {

    private String origem;
    private DefaultTableModel tableModel;

    public ListaConvenios(String origem) {
        this.origem = origem;
        System.out.println("Origem recebida: " + this.origem);
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableModel = new DefaultTableModel();
        tabelaConvenios = new javax.swing.JTable();
        tabelaConvenios = new JTable(tableModel);
        jScrollPane1.setViewportView(tabelaConvenios);
        carregarTabela();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnVOltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Convênios");

        btnSave.setBackground(new java.awt.Color(51, 153, 0));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(204, 102, 0));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Excluir");

        btnVOltar.setText("Voltar");
        btnVOltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVOltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(348, 348, 348)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                                .addComponent(btnVOltar)
                                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(btnVOltar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSave)
                                        .addComponent(btnEdit)
                                        .addComponent(btnDelete))
                                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarTabela(){
        List<br.edu.imepac.administrativo.entidades.Convenio> convenios = GerenciamentoConvenio.listarConvenio();
        tableModel.addColumn("id");
        tableModel.addColumn("nome");
        tableModel.addColumn("descriçao");

        for (br.edu.imepac.administrativo.entidades.Convenio convenio : convenios) {
            tableModel.addRow(new Object[] {convenio.getIdConvenio(), convenio.getNomeConvenio(), convenio.getDescricaoConvenio()});
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnVOltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOltarActionPerformed
        System.out.println("Origem ao clicar em voltar: " + origem);
        this.dispose();

        if (origem == null) {
            JOptionPane.showMessageDialog(this, "Erro: Origem é nula.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (origem.toLowerCase()) {
            case "atendente":
                Atendente telaAtendente = new Atendente();
                telaAtendente.setVisible(true);
                break;
            case "administrador":
                AdministradorHome telaAdm = new AdministradorHome();
                telaAdm.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Origem desconhecida: " + origem, "Erro", JOptionPane.ERROR_MESSAGE);
        }//GEN-LAST:event_btnVOltarActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Convenio("atendente").setVisible(true);
                new Convenio("administrador").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVOltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaConvenios;
    // End of variables declaration//GEN-END:variables
}