package com.hccs.skunkworks.forms;

import com.hccs.skunkworks.forms.tablemodels.RegistrationTableModel;
import com.hccs.util.activator.ActivatorUtility;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DCSalenga
 */
public class MainFrame extends javax.swing.JFrame {

    private TableRowSorter<AbstractTableModel> sorter;

    public MainFrame() {
        initComponents();
    }

    public void addTableSelectionListener(ListSelectionListener l) {
        tblResults.getSelectionModel().addListSelectionListener(l);
    }

    public void miAboutAddActionListener(ActionListener a) {
        miAbout.addActionListener(a);
    }

    public void miExitAddActionListener(ActionListener a) {
        miExit.addActionListener(a);
    }

    public void btnFetchAllActionListener(ActionListener a) {
        btnFetchAll.addActionListener(a);
    }

    public void setFullName(String val) {
        txtFullName.setText(val);
    }

    public void setProductInfo(String val) {
        txtProductInfo.setText(val);
    }

    public void setPhoneInfo(String val) {
        txtPhone.setText(val);
    }

    public void setEmailAddInfo(String val) {
        txtEmailAdd.setText(val);
    }

    public void setIPAddInfo(String val) {
        txtIPAdd.setText(val);
        btnChecker1.setEnabled(!val.isEmpty());
        btnChecker2.setEnabled(!val.isEmpty());

    }

    public void setOSInfo(String val) {
        txtOS.setText(val);
    }

    public void setJavaInfo(String val) {
        txtJava.setText(val);
    }

    public void setComputerInfo(String val) {
        txtComputer.setText(val);
    }

    public void setProfileInfo(String val) {
        txtProfile.setText(val);
    }

    public void setHDInfo(String val) {
        txtHD.setText(val);
    }

    public void setMotherBoradInfo(String val) {
        txtMobo.setText(val);
    }

    public void setExpirationDate(String val) {
        txtExpiration.setText(val);
    }

    public void setLastLoginDate(String val) {
        txtLastLogin.setText(val);
    }

    public Date getExpirationDate() {
        return dpExpiration.getDate();
    }

    public void setExpirationDate(Date date) {
        dpExpiration.setDate(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toggleButtonGroup = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnFetchAll = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResults = new org.jdesktop.swingx.JXTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        detailsSplitPane = new javax.swing.JSplitPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMobo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmailAdd = new javax.swing.JTextField();
        txtJava = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtOS = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIPAdd = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProfile = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtComputer = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        btnChecker1 = new javax.swing.JButton();
        btnChecker2 = new javax.swing.JButton();
        pnlPlugins = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtProductInfo = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtLastLogin = new javax.swing.JTextField();
        pnlExpiration = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtExpiration = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        dpExpiration = new com.hccs.forms.components.ZDatePicker("MM-dd-yyyy","##-##-####",'_');
        jPanel10 = new javax.swing.JPanel();
        chkEmailNoti = new javax.swing.JCheckBox();
        listSelectorPanel1 = new com.hccs.forms.components.ListSelectorPanel();
        pnlStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        mnuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miAbout = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        pnlMain.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        toggleButtonGroup.add(btnFetchAll);
        btnFetchAll.setText("Fetch All");
        btnFetchAll.setFocusable(false);
        btnFetchAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFetchAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnFetchAll);

        toggleButtonGroup.add(jToggleButton2);
        jToggleButton2.setText("New Account");
        jToggleButton2.setFocusable(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jToggleButton2);

        toggleButtonGroup.add(jToggleButton3);
        jToggleButton3.setText("Expiring Account");
        jToggleButton3.setFocusable(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jToggleButton3);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Search");
        jPanel5.add(jLabel1, java.awt.BorderLayout.WEST);

        txtFilter.setMinimumSize(new java.awt.Dimension(160, 28));
        jPanel5.add(txtFilter, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        tblResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResults);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setText("Row Count: ");
        jPanel7.add(jLabel2);

        jPanel3.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jSplitPane2.setLeftComponent(jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("HardDisk SN:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel5, gridBagConstraints);

        txtHD.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtHD, gridBagConstraints);

        jLabel6.setText("MotherBoard SN:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel6, gridBagConstraints);

        txtMobo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtMobo, gridBagConstraints);

        jLabel7.setText("Full Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel7, gridBagConstraints);

        txtFullName.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtFullName, gridBagConstraints);

        jLabel8.setText("Phone Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel8, gridBagConstraints);

        txtPhone.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtPhone, gridBagConstraints);

        jLabel9.setText("Email Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel9, gridBagConstraints);

        txtEmailAdd.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtEmailAdd, gridBagConstraints);

        txtJava.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtJava, gridBagConstraints);

        jLabel10.setText("Java Version:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel10, gridBagConstraints);

        txtOS.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtOS, gridBagConstraints);

        jLabel11.setText("Operating System:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel11, gridBagConstraints);

        txtIPAdd.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtIPAdd, gridBagConstraints);

        jLabel12.setText("Public IP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel12, gridBagConstraints);

        txtProfile.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtProfile, gridBagConstraints);

        jLabel13.setText("Profile Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel13, gridBagConstraints);

        txtComputer.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtComputer, gridBagConstraints);

        jLabel14.setText("Computer Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel14, gridBagConstraints);

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        btnChecker1.setText("IP Checker 1");
        btnChecker1.setEnabled(false);
        btnChecker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChecker1ActionPerformed(evt);
            }
        });
        jPanel21.add(btnChecker1);

        btnChecker2.setText("IP Checker 2");
        btnChecker2.setEnabled(false);
        btnChecker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChecker2ActionPerformed(evt);
            }
        });
        jPanel21.add(btnChecker2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel12.add(jPanel21, gridBagConstraints);

        jPanel19.add(jPanel12, java.awt.BorderLayout.NORTH);

        detailsSplitPane.setLeftComponent(jPanel19);

        pnlPlugins.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlPlugins.setLayout(new java.awt.BorderLayout(5, 10));

        jPanel18.setLayout(new java.awt.BorderLayout(5, 5));

        jPanel9.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jPanel20.setLayout(new java.awt.GridLayout(0, 1));

        jLabel16.setText("Product Info");
        jPanel20.add(jLabel16);

        txtProductInfo.setEditable(false);
        jPanel20.add(txtProductInfo);

        jPanel9.add(jPanel20);

        jPanel24.setLayout(new java.awt.GridLayout(0, 1));

        jLabel18.setText("Last Login");
        jPanel24.add(jLabel18);

        txtLastLogin.setEditable(false);
        jPanel24.add(txtLastLogin);

        jPanel9.add(jPanel24);

        jPanel18.add(jPanel9, java.awt.BorderLayout.NORTH);

        pnlExpiration.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jPanel22.setLayout(new java.awt.GridLayout(0, 1));

        jLabel17.setText("Expiration Date");
        jPanel22.add(jLabel17);

        txtExpiration.setEditable(false);
        jPanel22.add(txtExpiration);

        pnlExpiration.add(jPanel22);

        jPanel23.setLayout(new java.awt.GridLayout(0, 1));

        jLabel19.setText("New Expiration Date");
        jPanel23.add(jLabel19);
        jPanel23.add(dpExpiration);

        pnlExpiration.add(jPanel23);

        jPanel18.add(pnlExpiration, java.awt.BorderLayout.CENTER);

        pnlPlugins.add(jPanel18, java.awt.BorderLayout.NORTH);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        chkEmailNoti.setText("Send Email Notification");
        jPanel10.add(chkEmailNoti);

        pnlPlugins.add(jPanel10, java.awt.BorderLayout.SOUTH);
        pnlPlugins.add(listSelectorPanel1, java.awt.BorderLayout.CENTER);

        detailsSplitPane.setRightComponent(pnlPlugins);

        jPanel17.add(detailsSplitPane, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel17, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel4);

        jPanel2.add(jSplitPane2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel2);

        pnlMain.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pnlStatus.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblStatus.setText("...");
        pnlStatus.add(lblStatus);

        getContentPane().add(pnlStatus, java.awt.BorderLayout.SOUTH);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jToolBar2.setRollover(true);

        jToggleButton4.setText("Fetch All");
        jToggleButton4.setFocusable(false);
        jToggleButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton4);

        jToggleButton5.setText("Deny");
        jToggleButton5.setFocusable(false);
        jToggleButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton5);

        jToggleButton6.setText("Delete");
        jToggleButton6.setFocusable(false);
        jToggleButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jToggleButton6);

        jPanel8.add(jToolBar2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel8, java.awt.BorderLayout.NORTH);

        jMenu1.setText("File");

        miExit.setText("Exit");
        jMenu1.add(miExit);

        mnuBar.add(jMenu1);

        jMenu2.setText("Edit");
        mnuBar.add(jMenu2);

        miAbout.setText("Help");

        jMenuItem1.setText("About");
        miAbout.add(jMenuItem1);

        mnuBar.add(miAbout);

        setJMenuBar(mnuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChecker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChecker1ActionPerformed
        ActivatorUtility.openLink("http://geoiplookup.net/ip/" + txtIPAdd.getText());
    }//GEN-LAST:event_btnChecker1ActionPerformed

    private void btnChecker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChecker2ActionPerformed
        ActivatorUtility.openLink("http://www.ip-tracker.org/locator/ip-lookup.php?ip=" + txtIPAdd.getText());
    }//GEN-LAST:event_btnChecker2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChecker1;
    private javax.swing.JButton btnChecker2;
    private javax.swing.JToggleButton btnFetchAll;
    private javax.swing.JCheckBox chkEmailNoti;
    private javax.swing.JSplitPane detailsSplitPane;
    private com.hccs.forms.components.ZDatePicker dpExpiration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblStatus;
    private com.hccs.forms.components.ListSelectorPanel listSelectorPanel1;
    private javax.swing.JMenu miAbout;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JPanel pnlExpiration;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPlugins;
    private javax.swing.JPanel pnlStatus;
    private org.jdesktop.swingx.JXTable tblResults;
    private javax.swing.ButtonGroup toggleButtonGroup;
    private javax.swing.JTextField txtComputer;
    private javax.swing.JTextField txtEmailAdd;
    private javax.swing.JTextField txtExpiration;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtHD;
    private javax.swing.JTextField txtIPAdd;
    private javax.swing.JTextField txtJava;
    private javax.swing.JTextField txtLastLogin;
    private javax.swing.JTextField txtMobo;
    private javax.swing.JTextField txtOS;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtProductInfo;
    private javax.swing.JTextField txtProfile;
    // End of variables declaration//GEN-END:variables

    public void setRowCountLabel() {
        lblStatus.setText("SettingCountLabel...");
    }

    public void toggleForm(boolean b) {

    }

    public void setlabelStatus(String status) {
        lblStatus.setText(status);
    }

    public String getSearchString() {
        return txtFilter.getText().trim();
    }

    public void clearSearchBox() {
        txtFilter.setText("");
    }

    public void setSearchPanelFocus() {
        txtFilter.requestFocus();
    }

    public void showConnectionError() {
        JOptionPane.showMessageDialog(
                this, "Connection Error Occured", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void initActivatorTable(RegistrationTableModel model, TableRowSorter tblSorter) {
        tblResults.setModel(model);
        tblResults.setRowSorter(sorter = tblSorter);
    }

    public void toggleButtons(boolean b) {

    }

    public List<Integer> getSelectedRowsModel() {
        List<Integer> rows = new ArrayList<>();
        int[] xy = tblResults.getSelectedRows();
        if (xy.length > 0) {
            for (int i = 0; i < xy.length; i++) {
                rows.add(tblResults.convertRowIndexToModel(xy[i]));
            }
        }
        return rows;
    }

}
