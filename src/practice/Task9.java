package practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте программу, которая создает массив объектов, сериализует их
 * и сохраняет в файл. Затем считывает объекты из файла и выводит
 * содержимое каждого объекта на экран.
 */
public class Task9 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(22, "Ivan", "Ivanov"));
        persons.add(new Person(34, "Stepan", "Kuznetsov"));
        persons.add(new Person(36, "Nikolai", "Sidorov"));
        persons.add(new Person(28, "Sergei", "Shved"));

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
            for (Person person : persons) {
                outputStream.writeObject(person);
            }
            System.out.println("Objects serialized!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("file.txt"))) {
            while (true) {
                try {
                    Person person = (Person) inputStream.readObject();
                    System.out.println(person.getAge() + " " + person.getName());
                } catch (EOFException e) {
                    System.out.println("Objects deserialized!");
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
