
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

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
    function function;
    Agenda agenda;
    PlayerDB plrDB;
    DateManager datemanager;
    
    /**
     * Creates new form UserInterface
     */
    DefaultTableModel model;
    public UserInterface() {
        initComponents();
        model = (DefaultTableModel) plrTable.getModel();
        this.function = new function(plrDB, agenda);
    	this.agenda = new Agenda();
        this.datemanager = new DateManager();
        this.plrDB = new PlayerDB();
        plrDB.loadPlayerDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        saveAllBtn = new javax.swing.JButton();
        registerPlayer = new javax.swing.JButton();
        viewAgenda = new javax.swing.JButton();
        viewPlayerList = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        registerPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        clubField = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        agendaPanel = new javax.swing.JPanel();
        playerPanelBottom = new javax.swing.JPanel();
        playerPanelBottomBlank = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        upcomingTable = new javax.swing.JTable();
        upcomingLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        sessionAddBtn = new javax.swing.JButton();
        sessionPlaceField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sessionDateField = new javax.swing.JFormattedTextField();
        sessionAddPlayerBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        sessionPlayersTF = new javax.swing.JTextArea();
        sessionPlayerBox = new javax.swing.JComboBox<>();
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

        menuPanel.setBackground(new java.awt.Color(204, 204, 204));

        saveAllBtn.setText("Save");
        saveAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAllBtnActionPerformed(evt);
            }
        });

        registerPlayer.setText("Register player");
        registerPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPlayerActionPerformed(evt);
            }
        });

        viewAgenda.setText("Agenda");
        viewAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAgendaActionPerformed(evt);
            }
        });

        viewPlayerList.setText("View player list");
        viewPlayerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPlayerListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(viewAgenda)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerPlayer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(viewPlayerList, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(saveAllBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        menuPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {registerPlayer, saveAllBtn, viewAgenda, viewPlayerList});

        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(registerPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewAgenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPlayerList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveAllBtn)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        getContentPane().add(menuPanel, java.awt.BorderLayout.LINE_START);

        contentPanel.setLayout(new java.awt.CardLayout());

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
                .addContainerGap(197, Short.MAX_VALUE)
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
                .addContainerGap(362, Short.MAX_VALUE))
        );

        contentPanel.add(registerPanel, "card4");

        agendaPanel.setBackground(new java.awt.Color(255, 255, 255));

        playerPanelBottomBlank.setPreferredSize(new java.awt.Dimension(418, 418));

        upcomingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Place", "Players"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        upcomingTable.setMaximumSize(new java.awt.Dimension(300, 64));
        jScrollPane2.setViewportView(upcomingTable);
        if (upcomingTable.getColumnModel().getColumnCount() > 0) {
            upcomingTable.getColumnModel().getColumn(0).setResizable(false);
            upcomingTable.getColumnModel().getColumn(1).setResizable(false);
            upcomingTable.getColumnModel().getColumn(2).setResizable(false);
        }

        upcomingLabel.setText("Upcoming events");

        jButton2.setText("Clear all");

        javax.swing.GroupLayout playerPanelBottomBlankLayout = new javax.swing.GroupLayout(playerPanelBottomBlank);
        playerPanelBottomBlank.setLayout(playerPanelBottomBlankLayout);
        playerPanelBottomBlankLayout.setHorizontalGroup(
            playerPanelBottomBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelBottomBlankLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(playerPanelBottomBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(upcomingLabel))
                .addGap(21, 21, 21))
        );
        playerPanelBottomBlankLayout.setVerticalGroup(
            playerPanelBottomBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelBottomBlankLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upcomingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(playerPanelBottomBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(playerPanelBottomBlankLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addComponent(jButton2))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout playerPanelBottomLayout = new javax.swing.GroupLayout(playerPanelBottom);
        playerPanelBottom.setLayout(playerPanelBottomLayout);
        playerPanelBottomLayout.setHorizontalGroup(
            playerPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerPanelBottomBlank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        playerPanelBottomLayout.setVerticalGroup(
            playerPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelBottomLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(playerPanelBottomBlank, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sessionAddBtn.setText("Add event");
        sessionAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionAddBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Date");

        jLabel8.setText("Location");

        jLabel9.setText("Player");

        sessionAddPlayerBtn.setText("Add");
        sessionAddPlayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionAddPlayerBtnActionPerformed(evt);
            }
        });

        sessionPlayersTF.setEditable(false);
        sessionPlayersTF.setColumns(20);
        sessionPlayersTF.setRows(5);
        sessionPlayersTF.setToolTipText("");
        jScrollPane4.setViewportView(sessionPlayersTF);

        sessionPlayerBox.setModel(getComboBoxModel());

        javax.swing.GroupLayout agendaPanelLayout = new javax.swing.GroupLayout(agendaPanel);
        agendaPanel.setLayout(agendaPanelLayout);
        agendaPanelLayout.setHorizontalGroup(
            agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(agendaPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(agendaPanelLayout.createSequentialGroup()
                        .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32)
                        .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(agendaPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sessionAddBtn))
                            .addGroup(agendaPanelLayout.createSequentialGroup()
                                .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sessionDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(sessionPlaceField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addGroup(agendaPanelLayout.createSequentialGroup()
                                        .addComponent(sessionPlayerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(sessionAddPlayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        agendaPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {sessionDateField, sessionPlaceField, sessionPlayerBox});

        agendaPanelLayout.setVerticalGroup(
            agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agendaPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sessionDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionPlaceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agendaPanelLayout.createSequentialGroup()
                        .addGroup(agendaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(sessionPlayerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(sessionAddBtn)
                        .addGap(24, 24, 24)
                        .addComponent(playerPanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(agendaPanelLayout.createSequentialGroup()
                        .addComponent(sessionAddPlayerBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        agendaPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {sessionDateField, sessionPlaceField, sessionPlayerBox});

        contentPanel.add(agendaPanel, "card3");

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
                .addContainerGap(101, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(searchBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        contentPanel.add(playerListPanel, "card2");

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    public String getSearchFieldNameText(){
        return this.searchFieldName.getText();
    }
    
    public String getSearchFieldClubText(){
        return this.searchFieldClub.getText();
    }

    public String getSearchFieldAgeText(){
        return this.searchFieldAge.getText();
    }
    
    public String getSessionDateField(){
        return this.sessionDateField.getText();
    }
    
    public String getSessionPlaceField(){
        return this.sessionPlaceField.getText();
    }
    
    /*public String getSessionPlayerField(){
        //return this.sessionPlayerBox.getText();
    }
    */
    private ComboBoxModel getComboBoxModel(){
        // current Player Objects in database
        ArrayList<Player> players = plrDB.getArrayListPlayer();
        // new ArrayList to hold all Player names
        ArrayList<String> playerNames = new ArrayList<String>();
        // number of Player Objects in database
        int length = players.size();
        // String array which DefaultComboBoxModel will take as an argument
        String[] strArray = new String[length];
        
        // Loop through Player Objects and add their names to the new ArrayList
        for(int i = 0; i < players.size(); i++){
            playerNames.add(plrDB.getPlayerByIndex(i).getName());
        }
        // Add the player names to the new String array
        strArray = (String[]) playerNames.toArray();
        
        // return a new instance of the DefaultComboBoxModel which takes the
        // String array of player names as argument. 
        return new DefaultComboBoxModel(strArray);
    }
    
    
    private void registerPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPlayerActionPerformed
        function.changeCard(contentPanel, registerPanel);
        
        nameField.setText("");
        ageField.setText("");
        clubField.setText("");
    }//GEN-LAST:event_registerPlayerActionPerformed

    private void viewAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAgendaActionPerformed
        function.changeCard(contentPanel, agendaPanel);

    }//GEN-LAST:event_viewAgendaActionPerformed

    private void viewPlayerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPlayerListActionPerformed
        viewPlayerList();
        
    }//GEN-LAST:event_viewPlayerListActionPerformed

    /**
     * displays players in a table 
     */
    public void viewPlayerList(){
        function.changeCard(contentPanel, playerListPanel);
        
        // Clear table from content 
        model.setRowCount(0);
        
        try{
            // Get current ArrayList of all Player Objects
            ArrayList<Player> list = plrDB.getArrayListPlayer();
                // Check if there are Player Objects in the array
                if(list.size() != 0) {                   
                    // iterate through all Player Objects
                    for(int i = 0; i < list.size(); i++){
                        //open each player file
                        //Player plrRestore = function.open(list[i].getName());
                    	Player plrRestore = list.get(i);
                    	// print the list to the console as a test
                    	System.out.println(list.get(i).getName());
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
        plrDB.register(name, age, club);
        
        // Let the user view the player list
        viewPlayerList();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void saveAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAllBtnActionPerformed
    	// Erstattet med savePlayerDB, som skriver alle Player Objects i ArrayListen
    	// til filen. 
    	
    	plrDB.savePlayerDB();
    	
    }//GEN-LAST:event_saveAllBtnActionPerformed

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

    private void sessionAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionAddBtnActionPerformed
        String strDate = getSessionDateField();
        Date date = datemanager.fromStringToDate(strDate);
        String place = getSessionPlaceField();
        
        ScoutingSession ss = agenda.planSession(place, date);
        
        /**
         * Søgefunktion skal implementeres her
         */
        
        //ss.addPlayer();
    }//GEN-LAST:event_sessionAddBtnActionPerformed

    private void sessionAddPlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionAddPlayerBtnActionPerformed
        /*String inputPlayer = getSessionPlayerField();
        if(!inputPlayer.isEmpty()){
            sessionPlayersTF.append(inputPlayer + "\n");
        } else {
            
        }
        //sessionPlayerField.setText("");*/
    }//GEN-LAST:event_sessionAddPlayerBtnActionPerformed
    
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
    private javax.swing.JTextField ageField;
    private javax.swing.JPanel agendaPanel;
    private javax.swing.JTextField clubField;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel playerListPanel;
    private javax.swing.JPanel playerPanelBottom;
    private javax.swing.JPanel playerPanelBottomBlank;
    private javax.swing.JTable plrTable;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton registerPlayer;
    private javax.swing.JButton saveAllBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchFieldAge;
    private javax.swing.JTextField searchFieldClub;
    private javax.swing.JTextField searchFieldName;
    private javax.swing.JButton sessionAddBtn;
    private javax.swing.JButton sessionAddPlayerBtn;
    private javax.swing.JFormattedTextField sessionDateField;
    private javax.swing.JTextField sessionPlaceField;
    private javax.swing.JComboBox<String> sessionPlayerBox;
    private javax.swing.JTextArea sessionPlayersTF;
    private javax.swing.JLabel upcomingLabel;
    private javax.swing.JTable upcomingTable;
    private javax.swing.JButton viewAgenda;
    private javax.swing.JButton viewPlayerList;
    // End of variables declaration//GEN-END:variables
}
