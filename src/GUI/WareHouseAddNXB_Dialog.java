/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import BUS.PublisherBUS;
import DTO.entities.Account;
import DTO.entities.Category;
import DTO.entities.Publisher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUANG DIEN
 */
public class WareHouseAddNXB_Dialog extends javax.swing.JDialog {
    static String nameFrame;
    static String action;
    static Account user;
    /**
     * Creates new form WareHouseAddReader_Dialog
     */
    public WareHouseAddNXB_Dialog(java.awt.Frame parent, String nameFrame,Account user,boolean modal) throws SQLException, IOException, ClassNotFoundException {
        super(parent, modal);
        WareHouseAddNXB_Dialog.nameFrame = nameFrame;        
        WareHouseAddNXB_Dialog.user = user;

        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()throws SQLException, IOException, ClassNotFoundException {

        panelBorder_Statistic_Blue1 = new MyDesign.PanelBorder_Statistic_Blue();
        panelBorder_Basic1 = new MyDesign.PanelBorder_Basic();
        jLabel8 = new javax.swing.JLabel();
        txtNhaXuatBan = new MyDesign.MyTextField_Basic();
        btnThemNhaXuatBan = new MyDesign.MyButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setText("Nhà xuất bản");

        txtNhaXuatBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));

        btnThemNhaXuatBan.setBackground(new java.awt.Color(22, 113, 221));
        btnThemNhaXuatBan.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNhaXuatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/action-add-white.png"))); // NOI18N
        btnThemNhaXuatBan.setText("Thêm nhà xuất bản");
        btnThemNhaXuatBan.setBorderColor(new java.awt.Color(22, 113, 221));
        btnThemNhaXuatBan.setColor(new java.awt.Color(22, 113, 221));
        btnThemNhaXuatBan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        
        btnThemNhaXuatBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNhaXuatBan.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Vui lòng điền đầy đủ thông tin.", "Cảnh Báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                    	Publisher p = new Publisher();
                        p.setName(txtNhaXuatBan.getText());
                        if (nameFrame == "more_gui"){
                            More_GUI gui;
                            try {
                                gui = new More_GUI(user);
                                if(pub.getByNamePub(p.getName())!=null)
                                {
                                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Tên NXB đã tồn tại!","Thông báo",JOptionPane.WARNING_MESSAGE);
                                }
                                else {
                                    pub.saveInfo(p);
                                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Thêm Thành Công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);                                
                                    List<Publisher> publishers = pub.getAllName();
                                    gui.publishersModel.setRowCount(0);
                                    int stt = 1;
                                    for(Publisher item : publishers)
                                    {
                                        if(item.isStatus() == 1)
                                            gui.publishersModel.addRow(new Object[]{stt++,item.getName()});
                                    }
                                    hide();
                                    gui.setVisible(true);
                                    
                                }
                            } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            } catch (IOException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }catch (ClassNotFoundException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        } else{
                            WareHouseImport_Dialog whid;
                            try {
                                whid = new WareHouseImport_Dialog(null, rootPaneCheckingEnabled);
                                if(pub.getByNamePub(p.getName())!=null)
                                {
                                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Tên NXB đã tồn tại!","Thông báo",JOptionPane.WARNING_MESSAGE);
                                    
                                }
                                else {
                                    pub.saveInfo(p);
                                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Thêm Thành Công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                                    List<Publisher> publisherList = pub.getAllName();
                                    whid.cbNXB.removeAllItems();
                                    for(Publisher item : publisherList)
                                    {
                                        whid.cbNXB.addItem(item.getName());
                                    }
                                    hide();
                                    whid.setVisible(true);
                                }
                            } catch (ClassNotFoundException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            } catch (IOException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                        
                    } catch (HeadlessException e1) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Lỗi Thêm NXB.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.out.println(e1);
                    }
                }
            }
        });

        
        javax.swing.GroupLayout panelBorder_Basic1Layout = new javax.swing.GroupLayout(panelBorder_Basic1);
        panelBorder_Basic1.setLayout(panelBorder_Basic1Layout);
        panelBorder_Basic1Layout.setHorizontalGroup(
            panelBorder_Basic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder_Basic1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelBorder_Basic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder_Basic1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelBorder_Basic1Layout.setVerticalGroup(
            panelBorder_Basic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder_Basic1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBorder_Basic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThemNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nav-reader.png"))); // NOI18N
        jLabel4.setText("Nhà xuất bản");

        javax.swing.GroupLayout panelBorder_Statistic_Blue1Layout = new javax.swing.GroupLayout(panelBorder_Statistic_Blue1);
        panelBorder_Statistic_Blue1.setLayout(panelBorder_Statistic_Blue1Layout);
        panelBorder_Statistic_Blue1Layout.setHorizontalGroup(
            panelBorder_Statistic_Blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder_Statistic_Blue1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder_Statistic_Blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder_Basic1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder_Statistic_Blue1Layout.setVerticalGroup(
            panelBorder_Statistic_Blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder_Statistic_Blue1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder_Basic1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder_Statistic_Blue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder_Statistic_Blue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyDesign.MyButton btnThemNhaXuatBan;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private MyDesign.PanelBorder_Basic panelBorder_Basic1;
    private MyDesign.PanelBorder_Statistic_Blue panelBorder_Statistic_Blue1;
    private MyDesign.MyTextField_Basic txtNhaXuatBan;
    private PublisherBUS pub = new PublisherBUS();
    // End of variables declaration//GEN-END:variables
}
