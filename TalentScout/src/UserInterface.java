
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkelmoerch
 */
public class UserInterface extends javax.swing.JFrame {
    function function = new function();
    /**
     * Creates new form UserInterface
     */
    DefaultTableModel model;
    public UserInterface() {
        initComponents();
        model = (DefaultTableModel) plrTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        registerPlayer = new javax.swing.JButton();
        viewPlayer = new javax.swing.JButton();
        viewPlayerList = new javax.swing.JButton();
        parentPanel = new javax.swing.JPanel();
        registerPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        clubField = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        playerPanel = new javax.swing.JPanel();
        playerPanelBottom = new javax.swing.JPanel();
        playerPanelBottomBlank = new javax.swing.JPanel();
        playerPanelBottomShow = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        clubLabel = new javax.swing.JLabel();
        actualName = new javax.swing.JLabel();
        actualAge = new javax.swing.JLabel();
        actualClub = new javax.swing.JLabel();
        findPlayerLabel = new javax.swing.JLabel();
        findPlayerField = new javax.swing.JTextField();
        findPlayerBtn = new javax.swing.JButton();
        playerListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        plrTable = new javax.swing.JTable();
        searchFieldName = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        searchFieldClub = new javax.swing.JTextField();
        searchFieldAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        registerPlayer.setText("Register player");
        registerPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPlayerActionPerformed(evt);
            }
        });

        viewPlayer.setText("View player");
        viewPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPlayerActionPerformed(evt);
            }
        });

        viewPlayerList.setText("View player list");
        viewPlayerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPlayerListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(viewPlayer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerPlayer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(viewPlayerList, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {registerPlayer, viewPlayer, viewPlayerList});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(registerPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPlayerList)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        parentPanel.setLayout(new java.awt.CardLayout());

        registerPanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Name:");

        jLabel2.setText("Age:");

        jLabel3.setText("Club:");

        registerBtn.setText("Save");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registerBtn)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clubField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(ageField)
                            .addComponent(nameField))))
                .addGap(53, 53, 53))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clubField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(registerBtn)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        parentPanel.add(registerPanel, "card4");

        playerPanel.setBackground(new java.awt.Color(255, 255, 255));

        playerPanelBottom.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout playerPanelBottomBlankLayout = new javax.swing.GroupLayout(playerPanelBottomBlank);
        playerPanelBottomBlank.setLayout(playerPanelBottomBlankLayout);
        playerPanelBottomBlankLayout.setHorizontalGroup(
            playerPanelBottomBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        playerPanelBottomBlankLayout.setVerticalGroup(
            playerPanelBottomBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        playerPanelBottom.add(playerPanelBottomBlank, "card3");

        nameLabel.setText("Name:");

        ageLabel.setText("Age:");

        clubLabel.setText("Club:");

        actualName.setText("jLabel8");

        actualAge.setText("jLabel9");

        actualClub.setText("jLabel10");

        javax.swing.GroupLayout playerPanelBottomShowLayout = new javax.swing.GroupLayout(playerPanelBottomShow);
        playerPanelBottomShow.setLayout(playerPanelBottomShowLayout);
        playerPanelBottomShowLayout.setHorizontalGroup(
            playerPanelBottomShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelBottomShowLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(playerPanelBottomShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clubLabel)
                    .addComponent(ageLabel)
                    .addComponent(nameLabel))
                .addGap(62, 62, 62)
                .addGroup(playerPanelBottomShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actualName)
                    .addComponent(actualAge)
                    .addComponent(actualClub))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        playerPanelBottomShowLayout.setVerticalGroup(
            playerPanelBottomShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelBottomShowLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(playerPanelBottomShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(actualName))
                .addGap(18, 18, 18)
                .addGroup(playerPanelBottomShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(actualAge))
                .addGap(18, 18, 18)
                .addGroup(playerPanelBottomShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clubLabel)
                    .addComponent(actualClub))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        playerPanelBottom.add(playerPanelBottomShow, "card2");

        findPlayerLabel.setText("Player name:");

        findPlayerBtn.setText("Find player");
        findPlayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPlayerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(findPlayerBtn)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(findPlayerLabel)
                        .addGap(18, 18, 18)
                        .addComponent(findPlayerField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findPlayerLabel)
                    .addComponent(findPlayerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(findPlayerBtn)
                .addGap(41, 41, 41)
                .addComponent(playerPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(playerPanel, "card3");

        plrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Age", "Club"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        plrTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(plrTable);
        plrTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchFieldClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldClubActionPerformed(evt);
            }
        });

        jLabel4.setText("Name:");

        jLabel5.setText("Club:");

        jLabel6.setText("Age:");

        javax.swing.GroupLayout playerListPanelLayout = new javax.swing.GroupLayout(playerListPanel);
        playerListPanel.setLayout(playerListPanelLayout);
        playerListPanelLayout.setHorizontalGroup(
            playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(playerListPanelLayout.createSequentialGroup()
                        .addGroup(playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(53, 53, 53)
                        .addGroup(playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(searchFieldClub)
                            .addComponent(searchFieldAge))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        playerListPanelLayout.setVerticalGroup(
            playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerListPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFieldClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(playerListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parentPanel.add(playerListPanel, "card2");

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getFindPlayerFieldText(){
        return this.findPlayerField.getText();
    }
    
    public String getSearchFieldNameText(){
        return this.searchFieldName.getText();
    }
    
    public String getSearchFieldClubText(){
        return this.searchFieldClub.getText();
    }

    public String getSearchFieldAgeText(){
        return this.searchFieldAge.getText();
    }
    
    private void registerPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPlayerActionPerformed
        function.changeCard(parentPanel, registerPanel);
        
        nameField.setText("");
        ageField.setText("");
        clubField.setText("");
    }//GEN-LAST:event_registerPlayerActionPerformed

    private void viewPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPlayerActionPerformed
        function.changeCard(parentPanel, playerPanel);
        
        findPlayerField.setText("");
    }//GEN-LAST:event_viewPlayerActionPerformed

    private void viewPlayerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPlayerListActionPerformed
        viewPlayerList();
        
    }//GEN-LAST:event_viewPlayerListActionPerformed

    /**
     * displays players in a table 
     */
    public void viewPlayerList(){
        function.changeCard(parentPanel, playerListPanel);
        
        // Clear table from content 
        model.setRowCount(0);
        
        try{
            // create array of all files in the directory
            File[] list = function.getFiles();
                // Check if there are player files in the array
                if(list.length != 0) {                   
                    // iterate through all files
                    for(int i = 0; i < list.length; i++){
                        //open each player file
                        Player plrRestore = function.open(list[i].getName());
                        //convert the int age to a String
                        String age = Integer.toString(plrRestore.getAge());

                        // create array containing player attributes
                        String[] data = {plrRestore.getName(), age, plrRestore.getClub()};
                        
                        // insert the array into the table 
                        model.addRow(data);
                    }
                }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        String name = nameField.getText();
        String strAge = ageField.getText();
        int age = Integer.parseInt(strAge);
        String club = clubField.getText();
        
        // Saving the player object in a file
        Player plr = function.register(name, age, club);
        try {
            function.save(plr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        // Let the user view the player list
        viewPlayerList();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void findPlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPlayerBtnActionPerformed

        try {
            Player plrRestore = function.open(getFindPlayerFieldText());
            
            actualName.setText(plrRestore.getName());
            String age = Integer.toString(plrRestore.getAge());
            actualAge.setText(age);
            actualClub.setText(plrRestore.getClub());
            function.changeCard(playerPanelBottom, playerPanelBottomShow);
            
            function.buildString();
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_findPlayerBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        
        try{
            model.setRowCount(0);
            //function.InsertSearchResultToTable(getSearchFieldNameText(), getSearchFieldClubText(), getSearchFieldAgeText(), model);
            function.InsertSearchResultToTableName(getSearchFieldNameText(), model);
        } catch (Exception e){
            e.getCause();
            e.getClass();
            e.printStackTrace();   
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchFieldClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldClubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldClubActionPerformed
    
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
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualAge;
    private javax.swing.JLabel actualClub;
    private javax.swing.JLabel actualName;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField clubField;
    private javax.swing.JLabel clubLabel;
    private javax.swing.JButton findPlayerBtn;
    private javax.swing.JTextField findPlayerField;
    private javax.swing.JLabel findPlayerLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel playerListPanel;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JPanel playerPanelBottom;
    private javax.swing.JPanel playerPanelBottomBlank;
    private javax.swing.JPanel playerPanelBottomShow;
    private javax.swing.JTable plrTable;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton registerPlayer;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchFieldAge;
    private javax.swing.JTextField searchFieldClub;
    private javax.swing.JTextField searchFieldName;
    private javax.swing.JButton viewPlayer;
    private javax.swing.JButton viewPlayerList;
    // End of variables declaration//GEN-END:variables
}
