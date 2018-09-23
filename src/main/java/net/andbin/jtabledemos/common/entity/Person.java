/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.entity;

import java.util.Objects;

public class Person implements Cloneable, Comparable<Person> {
    private Long id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private Sex sex;

    public Person(String firstName, String lastName, int birthYear, Sex sex) {
        this.firstName = Objects.requireNonNull(firstName, "firstName cannot be null");
        this.lastName = Objects.requireNonNull(lastName, "lastName cannot be null");
        this.birthYear = birthYear;
        this.sex = Objects.requireNonNull(sex, "sex cannot be null");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);   // Should never happen!
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "["
                + "id=" + getId() + ", "
                + "firstName=" + getFirstName() + ", "
                + "lastName=" + getLastName() + ", "
                + "birthYear=" + getBirthYear() + ", "
                + "sex=" + getSex()
                + "]";
    }

    @Override
    public int compareTo(Person otherPerson) {
        int r = getLastName().compareTo(otherPerson.getLastName());

        if (r == 0) {
            r = getFirstName().compareTo(otherPerson.getFirstName());

            if (r == 0) {
                r = Integer.compare(getBirthYear(), otherPerson.getBirthYear());
            }
        }

        return r;
    }
}
