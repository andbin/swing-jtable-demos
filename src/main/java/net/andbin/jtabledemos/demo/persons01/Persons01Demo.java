/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.demo.persons01;

import javax.swing.SwingUtilities;
import net.andbin.jtabledemos.common.db.Database;
import net.andbin.jtabledemos.common.db.DatabaseManager;

public class Persons01Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Database database = DatabaseManager.getInstance().getCurrentDatabase();
                Persons01DemoFrame frame = new Persons01DemoFrame(database);
                frame.setVisible(true);
            }
        });
    }
}
