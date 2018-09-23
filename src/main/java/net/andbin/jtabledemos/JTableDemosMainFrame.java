/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import net.andbin.jtabledemos.common.resource.Resources;

public class JTableDemosMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu databaseMenu;
    private JRadioButtonMenuItem selectMemoryDatabaseMenuItem;
    private JMenu helpMenu;
    private JMenuItem aboutMenuItem;
    private JList<JTableDemoListItem> demosList;
    private JScrollPane demosListScrollPane;
    private JButton runButton;

    public JTableDemosMainFrame(JTableDemoListItem[] demoListItems) {
        createMenuBar();
        createGui(demoListItems);

        setTitle(JTableDemos.APP_NAME);
        setIconImages(Resources.loadWindowIcons());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        databaseMenu = new JMenu("Database");
        selectMemoryDatabaseMenuItem = new JRadioButtonMenuItem("Select \"Memory\" databasee", true);
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About " + JTableDemos.APP_NAME);
        aboutMenuItem.addActionListener(this::showAbout);

        menuBar.add(databaseMenu);
        menuBar.add(helpMenu);
        databaseMenu.add(selectMemoryDatabaseMenuItem);
        helpMenu.add(aboutMenuItem);

        setJMenuBar(menuBar);
    }

    private void createGui(JTableDemoListItem[] demoListItems) {
        demosList = new JList<>(demoListItems);
        demosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        demosList.setSelectedIndex(0);
        demosListScrollPane = new JScrollPane(demosList);

        runButton = new JButton("RUN DEMO");
        runButton.addActionListener(this::runDemo);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(demosListScrollPane, BorderLayout.CENTER);
        mainPanel.add(runButton, BorderLayout.PAGE_END);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void runDemo(ActionEvent e) {
        JTableDemoListItem demoListItem = demosList.getSelectedValue();

        if (demoListItem != null) {
            demoListItem.getRunnable().run(new String[0]);
        }
    }

    private void showAbout(ActionEvent e) {
        JTableDemosAbout about = new JTableDemosAbout();
        about.showDialog(this);
    }
}
