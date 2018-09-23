/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.db.memory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import net.andbin.jtabledemos.common.db.PersonDAO;
import net.andbin.jtabledemos.common.entity.EntityUtils;
import net.andbin.jtabledemos.common.entity.Person;

public class MemoryPersonDAO implements PersonDAO {
    private Map<Long,Person> personsMap = new HashMap<>();
    private AtomicLong personIdSequence = new AtomicLong(1);

    public List<Person> selectAllPersons() {
        List<Person> persons = EntityUtils.clonePersonsToList(personsMap.values());
        Collections.sort(persons);
        return persons;
    }

    @Override
    public void insertPerson(Person person) {
        Long personId = personIdSequence.getAndIncrement();
        person.setId(personId);
        personsMap.put(personId, person.clone());
    }

    @Override
    public void deleteAllPersons() {
        personsMap = new HashMap<>();
    }
}
