/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.demo.persons01;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;
import net.andbin.jtabledemos.common.entity.Person;
import net.andbin.jtabledemos.common.entity.Sex;

public class Persons01DemoTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    public static final int FIRST_NAME_COLUMN = 0;
    public static final int LAST_NAME_COLUMN = 1;
    public static final int SEX_COLUMN = 2;
    public static final int BIRTH_YEAR_COLUMN = 3;

    private static final String[] columnNames = {
        "First Name", "Last Name", "Sex", "Birth Year"
    };

    private List<Person> persons;

    public Persons01DemoTableModel() {
        this(Collections.emptyList());
    }

    public Persons01DemoTableModel(List<Person> persons) {
        this.persons = Objects.requireNonNull(persons, "persons cannot be null");
    }

    public int getRowCount() {
        return persons.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case FIRST_NAME_COLUMN: return String.class;
        case LAST_NAME_COLUMN: return String.class;
        case SEX_COLUMN: return Sex.class;
        case BIRTH_YEAR_COLUMN: return Integer.class;
        }

        return Object.class;   // Extra case (should not happen)
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;   // All cells are NOT editable
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);

        switch (columnIndex) {
        case FIRST_NAME_COLUMN: return person.getFirstName();
        case LAST_NAME_COLUMN: return person.getLastName();
        case SEX_COLUMN: return person.getSex();
        case BIRTH_YEAR_COLUMN: return person.getBirthYear();
        }

        return null;   // Extra case (should not happen)
    }
}
