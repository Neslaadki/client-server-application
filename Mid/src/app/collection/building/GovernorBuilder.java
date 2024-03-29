package app.collection.building;

import app.collection.Human;
import io.ConsoleReader;
import exceptions.InvalidInputException;
import exceptions.MessageErrors;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 * Класс, который занимается создание объекта Губернатор.
 */

public class GovernorBuilder implements IHumanBuilder, MessageErrors {

    private ConsoleReader input;
    private String position;
    private Integer age;
    private LocalDateTime dateOfBirthday;

    public GovernorBuilder() throws IOException {
        input = new ConsoleReader();
    }

    /**
     * Этот метод занимается инициализацией возрата Губенатор
     */
    @Override
    public void setAge() throws InvalidInputException {
        System.out.println("Введите возраст " + position + "a" + " в формате 'Integer' [" + 0 + ";" + Integer.MAX_VALUE + "]" + System.lineSeparator());
        input.getDefaultConsoleSymbol();
        String line = input.getScanner().nextLine().trim();
        try {
            if (Integer.parseInt(line) <= Integer.MAX_VALUE) {
                age = Integer.parseInt(line);
            } else {
                System.out.println(messageOfInputValueError + System.lineSeparator());
                setAge();
            }
        } catch (Exception e) {
            System.out.println(messageOfInputFormatError + System.lineSeparator());
            setAge();
        }
    }


    @Override
    public void setPosition() {
        this.position = "Губернатор";
    }

    public void setInputPath(Scanner inputPath) {
        input.setInput(inputPath);
    }

    /**
     * Этот метод инициализирует дату рождения губернатора
     */
    @Override
    public void setBirthday() {
        System.out.println(System.lineSeparator() + "Введите дату рождения " + position + " в формате 'год-месяц-день час:минуты'"
                + System.lineSeparator() + "Пример: 2020-01-01 00:00 " + System.lineSeparator());
        input.getDefaultConsoleSymbol();
        try {
            String line = input.getScanner().nextLine().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            dateOfBirthday = LocalDateTime.parse(line, formatter);
            System.out.println("Дата рождения успешно установлена " + dateOfBirthday + System.lineSeparator());
        } catch (Exception e) {
            System.out.println(messageOfInputFormatError + System.lineSeparator());
            setBirthday();
        }
    }

    /**
     * Метод занимается созданием объекта Губернатора, используя методы
     *
     * @return возвращается новый объект класса Human, если у города есть губернатор; иначе - возвращает null
     * @see GovernorBuilder#setAge()
     * @see GovernorBuilder#setBirthday()
     */
    @Override
    public Human create() {
        setPosition();
        System.out.println(System.lineSeparator() + "В вашем городе есть " + position + System.lineSeparator() + ": Да или Нет ?" + System.lineSeparator());
        input.getDefaultConsoleSymbol();
        String line = input.getScanner().nextLine().trim().toLowerCase();
        if (line.equals("да")) {
            System.out.println("Переходим к созданию " + position + "a");
            setAge();
            setBirthday();
            return new Human(age, dateOfBirthday);
        } else if (line.equals("нет")) {
            System.out.println("Ок, ввод " + position + "a" + " пропущен.");
            return null;
        } else {
            System.out.println("Выбери вариант, да или нет? ");
            create();
            return null;
        }
    }


}
