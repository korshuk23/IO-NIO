package practice;

import java.io.*;

/**
 * Создайте класс, который будет сериализоваться. Заполните его полями и сохраните объект в файл,
 * а затем считайте объект из файла и выведите его содержимое на экран.
 */
public class Task8 {
    public static void main(String[] args) throws IOException {
        Person person = new Person(12, "Ivan", "Ivanov");

        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("file3.txt"))) {
            write.writeObject(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("file3.txt"))) {
            Person person1 = (Person) objectIn.readObject();
            System.out.println(person1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
