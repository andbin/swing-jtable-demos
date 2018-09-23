/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import net.andbin.jtabledemos.common.resource.Resources;

public class JTableDemosAbout {
    private static final String ABOUT_TITLE = "About " + JTableDemos.APP_NAME;

    public void showDialog(Component parentComponent) {
        String message = "<html>"
                + "<center style='padding-left:20px;padding-right:20px;padding-bottom:30px;'>"
                + "<span style='font-size:200%;font-weight:bold;'>"
                + JTableDemos.APP_NAME
                + "</span><br>"
                + "<br>"
                + "<span style='font-size:155%;font-weight:normal;color:red;'>"
                + JTableDemos.APP_VERSION_DESC
                + "</span><br>"
                + "<br>"
                + "<span style='font-size:130%;font-weight:normal;color:blue;'>"
                + JTableDemos.APP_CREATED_BY
                + "</span>"
                + "</center>";

        Icon icon = Resources.loadLargeIcon();

        JOptionPane.showMessageDialog(parentComponent, message,
                ABOUT_TITLE, JOptionPane.PLAIN_MESSAGE, icon);
    }
}
