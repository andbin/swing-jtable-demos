/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.gui;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionsPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public ActionsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    public JButton addButton(String text, ActionListener actionListener) {
        gap();
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        add(button);
        return button;
    }

    private void gap() {
        if (getComponentCount() > 0) {
            add(Box.createHorizontalStrut(5));
        }
    }
}
