package DoubleLL;

public class Main {

    public static void main(String[] args){

        DoublyLinkedList dll = new DoublyLinkedList(5);


        dll.insert(1,0);
        dll.insert(2,1);
        dll.insert(6,3);
        dll.insert(5,5);
        dll.insert(5,6);
        dll.traverse();
        dll.traverse1();

        dll.deleteDups();



        dll.traverse();
        dll.traverse1();


    }
}
