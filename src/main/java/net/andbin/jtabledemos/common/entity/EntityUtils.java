/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EntityUtils {
    private EntityUtils() {}   // Prevents instantiation

    public static List<Person> clonePersonsToList(Collection<Person> persons) {
        return persons.stream().map(Person::clone).collect(Collectors.toCollection(ArrayList::new));
    }
}
