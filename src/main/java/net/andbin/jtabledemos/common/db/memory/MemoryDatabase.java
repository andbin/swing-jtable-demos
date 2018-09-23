/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.db.memory;

import net.andbin.jtabledemos.common.db.Database;
import net.andbin.jtabledemos.common.db.DatabaseDemoInitializer;
import net.andbin.jtabledemos.common.db.PersonDAO;

public class MemoryDatabase implements Database {
    private MemoryPersonDAO memoryPersonDAO;

    public MemoryDatabase() {
        memoryPersonDAO = new MemoryPersonDAO();

        DatabaseDemoInitializer.initialize(this);
    }

    @Override
    public String getName() {
        return "Memory Database";
    }

    @Override
    public void clear() {
        memoryPersonDAO.deleteAllPersons();
    }

    @Override
    public PersonDAO getPersonDAO() {
        return memoryPersonDAO;
    }
}
