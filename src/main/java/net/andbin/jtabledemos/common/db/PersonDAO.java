/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.db;

import java.util.List;
import net.andbin.jtabledemos.common.entity.Person;

public interface PersonDAO {
    List<Person> selectAllPersons();
    void insertPerson(Person person);
    void deleteAllPersons();
}
