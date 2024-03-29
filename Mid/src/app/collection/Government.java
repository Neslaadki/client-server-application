package app.collection;

import exceptions.InvalidInputException;

import java.io.Serializable;

public enum Government implements Comparable<Government> , Serializable {
    KRITARCHY("Критархия", 1),
    OLIGARCHY("Олигархия", 2),
    TIMOCRACY("Тимократия", 3),
    TOTALITARIANISM("Тоталитаризм", 4);


    private String russianName;
    private int number;

    Government(String russianName, int number) {
        this.russianName = russianName;
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    public String getRussianName() {
        return russianName;
    }

    public static void printAllGovernent() {
        System.out.println(KRITARCHY.number + " - " + KRITARCHY.getRussianName() + System.lineSeparator()
                + OLIGARCHY.getNumber() + " - " + OLIGARCHY.getRussianName() + System.lineSeparator()
                + TIMOCRACY.getNumber() + " - " + TIMOCRACY.getRussianName() + System.lineSeparator()
                + TOTALITARIANISM.getNumber() + " - " + TOTALITARIANISM.getRussianName() + System.lineSeparator());
    }
}
