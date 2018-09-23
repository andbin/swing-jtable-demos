/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.db;

import java.util.Random;
import net.andbin.jtabledemos.common.entity.Person;
import net.andbin.jtabledemos.common.entity.Sex;

public class DatabaseDemoInitializer {
    public static void initialize(Database database) {
        createRandomPersons(database);
    }

    private static void createRandomPersons(Database database) {
        String[] maleNames = {
                "Aaron", "Adam", "Alan", "Arthur", "Brian", "Christopher",
                "Craig", "Dennis", "Earl", "Edward", "Ernest", "Harry",
                "Henry", "James", "Jerry", "Jimmy", "Joe", "John", "Jose",
                "Joshua", "Keith", "Kevin", "Larry", "Lawrence", "Martin",
                "Michael", "Nicholas", "Patrick", "Paul", "Richard", "Roger",
                "Roy", "Russell", "Scott", "Sean", "Shawn", "Terry", "Victor",
                "Walter", "William"
        };

        String[] femaleNames = {
                "Alice", "Amanda", "Anna", "Annie", "Ashley", "Betty",
                "Brenda", "Catherine", "Christina", "Cynthia", "Debra",
                "Denise", "Doris", "Emily", "Gloria", "Heather", "Jennifer",
                "Judith", "Judy", "Julia", "Julie", "Katherine", "Kathryn",
                "Kimberly", "Laura", "Lillian", "Marie", "Marilyn", "Michelle",
                "Nancy", "Pamela", "Paula", "Rachel", "Rebecca", "Rose",
                "Sandra", "Shirley", "Stephanie", "Theresa", "Virginia"
        };

        String[] lastNames = {
                "Adams", "Alexander", "Allen", "Anderson", "Bailey", "Baker",
                "Barnes", "Bell", "Bennett", "Brooks", "Brown", "Bryant",
                "Butler", "Campbell", "Carter", "Clark", "Coleman", "Collins",
                "Cook", "Cooper", "Cox", "Davis", "Diaz", "Edwards", "Evans",
                "Flores", "Foster", "Garcia", "Gibbs", "Gonzales", "Gonzalez",
                "Gray", "Green", "Griffin", "Hall", "Harris", "Henderson",
                "Hernandez", "Hill", "Howard", "Hughes", "Jackson", "James",
                "Jenkins", "Johnson", "Jones", "Kelly", "King", "Lee", "Lewis",
                "Long", "Lopez", "Martin", "Martinez", "Miller", "Mitchell",
                "Moore", "Morgan", "Morris", "Murphy", "Nelson", "Parker",
                "Patterson", "Perez", "Perry", "Peterson", "Phillips",
                "Powell", "Price", "Ramirez", "Reed", "Richardson", "Rivera",
                "Roberts", "Robinson", "Rodriguez", "Rogers", "Ross", "Russell",
                "Sanchez", "Sanders", "Scott", "Simmons", "Smith", "Stewart",
                "Taylor", "Thomas", "Thompson", "Torres", "Turner", "Walker",
                "Ward", "Washington", "Watson", "White", "Williams", "Wilson",
                "Wood", "Wright", "Young"
        };

        Sex[] sexes = { Sex.MALE, Sex.FEMALE };

        PersonDAO personDao = database.getPersonDAO();
        personDao.deleteAllPersons();

        Random random = new Random(1234);

        for (int i = 0; i < 100; i++) {
            Sex sex = sexes[random.nextInt(sexes.length)];
            String firstName = null;

            switch (sex) {
            case MALE:
                firstName = maleNames[random.nextInt(maleNames.length)];
                break;
            case FEMALE:
                firstName = femaleNames[random.nextInt(femaleNames.length)];
                break;
            }

            String lastName = lastNames[random.nextInt(lastNames.length)];
            int birthYear = 1940 + random.nextInt(70);

            Person person = new Person(firstName, lastName, birthYear, sex);
            personDao.insertPerson(person);
        }
    }
}
