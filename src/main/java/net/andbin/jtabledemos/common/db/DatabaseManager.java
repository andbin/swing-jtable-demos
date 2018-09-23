/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.db;

import net.andbin.jtabledemos.common.db.memory.MemoryDatabase;

public class DatabaseManager {
    private static final DatabaseManager instance = new DatabaseManager();

    private Database currentDatabase;
    private MemoryDatabase memoryDatabase;

    public DatabaseManager() {
        useMemoryDatabase();
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    public synchronized Database getCurrentDatabase() {
        return currentDatabase;
    }

    public synchronized void useMemoryDatabase() {
        if (memoryDatabase == null) {
            memoryDatabase = new MemoryDatabase();
        }

        currentDatabase = memoryDatabase;
    }
}
