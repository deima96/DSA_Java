package SingleLL;

//public class SingleLinkedList {
//    public Node head;
//    public Node tail;
//    public int size;
//
//    public Node createLinkedNode(int nodeValue) {
//        head = new Node();
//        Node node = new Node();
//
//        node.value = nodeValue;
//        node.next = null;
//
//        head = node;
//        tail = node;
//        size = 1;
//
//        return head;
//    }
//    public void insertLinkedNode(int nodeValue, int location){
//        Node node = new Node();
//        node.value = nodeValue;
//        if(head==null){
//            createLinkedNode(nodeValue);
//            return;
//        }else if(location==0){
//            node.next = head;
//            head = node;
//        }else if(location>=size){
//            node.next=null;
//            tail.next = node;
//            tail = node;
//        }else{
//            Node temp_node = head;
//            int index=0;
//            while(index<location-1){
//                temp_node = temp_node.next;
//                index++;
//            }
//            Node new_node = temp_node.next;
//            temp_node.next = node;
//            node.next = new_node;
//        }
//        size++;
//    }
//    public void traverseLinkedList(){
//        if(head==null){
//            System.out.println("Linked list is empty!");
//        }else{
//            Node tempNode = head;
//            while(tempNode!=null){
//                System.out.print(tempNode.value + " ");
//                tempNode=tempNode.next;
//            }
//        }
//        System.out.println();
//    }
//    public void searchLinkedNode(int nodeValue){
//        if(head==null){
//            System.out.println("LinkedL list is empty");
//        }
//        else {
//            Node tempNode = head;
//            int index=0;
//            while (tempNode != null) {
//                if(tempNode.value==nodeValue){
//                    System.out.println(nodeValue + " is found at location: " + (index));
//                    return;
//                }
//                tempNode=tempNode.next;
//                index++;
//            }
//            System.out.println(nodeValue +" does not exist");
//        }
//
//    }
//    public void deleteLinkedNode(int location){
//        if(head==null){
//            System.out.println("The Linked Node doesn't exist");
//            return;
//        }
//        else if(location == 0){
//            head = head.next;
//            size--;
//            if(size==0){
//                tail=null;
//            }
//        }
//        else if(location >= size){
//            Node temp = head;
//            System.out.println(size);
//
//            for(int i=0;i<size-2;i++){
//                temp = temp.next;
//            }
//            if(temp==head){
//                tail = head = null;
//                size--;
//                return;
//            }
//            temp.next=null;
//            tail=temp;
//            size--;
//        }
//        else{
//            Node temp=head;
//            for(int i=0;i<location-1;i++){
//                temp=temp.next;
//            }
//            //Node del = temp.next;
//            temp.next=temp.next.next;
//            size--;
//        }
//
//    }
//
//    //delete entire singlelinkedlist
//    public void deleteLinkedList(){
//        head=null;
//        tail=null;
//        size=0;
//        System.out.println("SingleLinkedList is deleted successfully.");
//    }
//
//}

//Another theory

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createLinkedNode(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert Method SinglyLinkedList
    public void insertLinkedNode(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createLinkedNode(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // SinglyLinkedList Traversal
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist!");
        } else {
            Node tempNode = head;
            while(tempNode!=null){
                System.out.print(tempNode.value + " ");
                tempNode=tempNode.next;
            }
        }
        System.out.println("\n");
    }

    // Search for a node

    boolean searchLinkedNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i=0; i<size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.print("Found the node at location: " +i+"\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("Node not found! ");
        return false;
    }

    //Deleting a node from SinglyLinkedList
    public void deleteLinkedNode(int location) {
        if (head == null) {
            System.out.println("The SLL does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i <location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    //  Delete Entire SinglyLinkedList
    public void deleteSLL() {
        head = null;
        tail = null;
        System.out.println("The SLL deleted successfully");

    }

}

