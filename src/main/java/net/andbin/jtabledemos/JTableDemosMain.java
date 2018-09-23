/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos;

import javax.swing.SwingUtilities;

public class JTableDemosMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JTableDemoListItem[] demoListItems = JTableDemos.getDemoListItems();
                JTableDemosMainFrame frame = new JTableDemosMainFrame(demoListItems);
                frame.setVisible(true);
            }
        });
    }
}
