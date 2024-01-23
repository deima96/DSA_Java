package SingleLL;

public class Main {

    public static void main(String[] args) {

        SingleLinkedList sll = new SingleLinkedList();

        sll.createLinkedNode(5);
        System.out.println(sll.head.value);
        sll.insertLinkedNode(1,0);
        sll.insertLinkedNode(3,1);
        sll.insertLinkedNode(6,3);
        sll.insertLinkedNode(2,1);

        sll.searchLinkedNode(2);
        sll.traverseLinkedList();
        System.out.println(sll.size);

        sll.deleteLinkedNode(5);


        sll.traverseLinkedList();
    }

}
