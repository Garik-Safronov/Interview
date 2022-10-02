package hw1.task2;

public class Task2 {

    interface Moveable {
        void move();
    }
    interface Stopable {
        void stop();
    }
    interface Openable {
        void open();
    }
    abstract class Car {
        private Engine engine; // создать класс Engine, а поле сделать private, для работы с ним есть геттер и сеттер
        private String color;
        private String name;
        protected void start() {
            System.out.println("Car starting");
        }
//        abstract void open();  // метод можно вынести в отдельный интерфейс

        public Engine getEngine() {
            return engine;
        }
        public void setEngine(Engine engine) {
            this.engine = engine;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    abstract class Engine {
    }
    class LightWeightCar extends Car implements Moveable, Openable{  // добавить интерфейс Openable
        @Override
        public void open() {
            System.out.println("Car is open");
        }
        @Override
        public void move() {
            System.out.println("Car is moving");
        }
    }
    class Lorry extends Car implements Moveable, Stopable { // т.к. наследоваться можно только от одного класса, добавляем слово implements для интерфейсов
        public void move(){
            System.out.println("Car is moving");
        }
        public void stop(){
            System.out.println("Car is stop");
        }
    }

}
