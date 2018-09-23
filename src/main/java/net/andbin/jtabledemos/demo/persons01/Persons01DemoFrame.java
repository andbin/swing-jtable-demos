/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.demo.persons01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.andbin.jtabledemos.common.db.Database;
import net.andbin.jtabledemos.common.db.PersonDAO;
import net.andbin.jtabledemos.common.gui.ActionsPanel;
import net.andbin.jtabledemos.common.resource.Resources;

public class Persons01DemoFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private Database database;
    private Persons01DemoTableModel tableModel;
    private JTable table;
    private JScrollPane scrollPane;
    private ActionsPanel actionsPanel;

    public Persons01DemoFrame(Database database) {
        this.database = database;

        createGui();

        setTitle("Persons 01 Demo [" + database.getName() + "]");
        setIconImages(Resources.loadWindowIcons());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void createGui() {
        tableModel = new Persons01DemoTableModel();
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        actionsPanel = new ActionsPanel();
        actionsPanel.addButton("RELOAD", this::reload);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(scrollPane);

        add(mainPanel, BorderLayout.CENTER);
        add(actionsPanel, BorderLayout.PAGE_END);
    }

    private void reload(ActionEvent e) {
        PersonDAO personDao = database.getPersonDAO();
        tableModel = new Persons01DemoTableModel(personDao.selectAllPersons());
        table.setModel(tableModel);
    }
}
