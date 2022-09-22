package hw2;

public class Main2 {
    public static void main(String[] args) {

        Array array = new Array();

        array.add("Hello");
        array.add("World");
        System.out.println(array.get(1));
        array.remove(1);


        Linked<Object> linked = new Linked<>();

        System.out.println(linked.isEmpty());
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked.contains("b"));
        linked.remove("c");

    }
}
