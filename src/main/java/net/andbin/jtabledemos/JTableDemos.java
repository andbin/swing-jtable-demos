/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos;

import net.andbin.jtabledemos.demo.persons01.Persons01Demo;

public class JTableDemos {
    public static final String APP_NAME = "Swing JTable Demos";
    public static final String APP_VERSION = "0.1.0";
    public static final String APP_VERSION_DESC = "version " + APP_VERSION;
    public static final String APP_CREATED_BY = "created by Andrea Binello (“andbin”)";

    private JTableDemos() {}   // Prevents instantiation

    public static JTableDemoListItem[] getDemoListItems() {
        return new JTableDemoListItem[] {
                new JTableDemoListItem("Persons01Demo", Persons01Demo::main,
                        "A simple read-only table of persons")
        };
    }
}
