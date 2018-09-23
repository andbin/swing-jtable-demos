/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.entity;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private final String string;

    Sex(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
