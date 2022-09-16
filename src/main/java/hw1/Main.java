package hw1;

import hw1.task1.Person;
import hw1.task3.Shape;

public class Main {

    public static void main(String[] args) {

/// Task1:
        Person.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .middleName("---")
                .country("Russia")
                .address("Moscow")
                .phone("+7123456789")
                .age(30)
                .gender("male")
                .build();


/// Task3
        Shape circle = new Shape();
        circle.drawShape();
        Shape rectangle = new Shape();
        rectangle.drawShape();
        Shape triangle= new Shape();
        triangle.drawShape();
    }
}
