package esperanca;

public class App {
    public static void main(String[] args) {
        LinkedList<Node> linkedList = new LinkedList<>();

        linkedList.addLast(new Node("Banana"));
        linkedList.addLast(new Node("Melancia"));
        linkedList.addLast(new Node("Laranja"));
        linkedList.addLast(new Node("Morango"));
        linkedList.addLast(new Node("Manga"));
        linkedList.addLast(new Node("Banana"));

       // linkedList.print();

        System.out.println(linkedList.getSize());

       // linkedList.print();
    }
}
