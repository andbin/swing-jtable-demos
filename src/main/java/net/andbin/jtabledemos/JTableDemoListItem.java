/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos;

public class JTableDemoListItem {
    private final String name;
    private final ArgsRunnable runnable;
    private final String description;

    public JTableDemoListItem(String name, ArgsRunnable runnable, String description) {
        this.name = name;
        this.runnable = runnable;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public ArgsRunnable getRunnable() {
        return runnable;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " \u2014 " + description;
    }


    @FunctionalInterface
    public static interface ArgsRunnable {
        void run(String[] args);
    }
}
