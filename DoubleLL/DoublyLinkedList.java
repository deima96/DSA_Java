package DoubleLL;

public class DoublyLinkedList {
    Node head, tail;
    int length;

    DoublyLinkedList(int nodeValue){
        this.head=new Node(nodeValue);
        this.tail=head;
        this.length=1;
    }

    public void insert(int nodeValue, int location){
        Node newNode = new Node(nodeValue);
        if(head==null){
            head = newNode;
        }
        else if(location==0){
            newNode.next = head;
            head.prev = newNode;
            head=newNode;
        }
        else if(location>=length){
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        else{
            Node temp = head;
            Node temp1 = head.next;
            for(int i=0;i<location-1;i++){
                temp=temp.next;
                temp1=temp1.next;
            }
            newNode.next = temp.next;
            newNode.prev=temp;
            temp.next=newNode;
            temp1.prev=newNode;

        }
        length++;
    }

    public void traverse(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void traverse1(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp=temp.prev;
        }
        System.out.println();
    }
    public void search(int nodeValue){
        Node temp = head;
        int index=0;
        while(temp!=null){
            if(temp.value==nodeValue){
                System.out.println(nodeValue + " is at location " + index);
                return;
            }
            temp=temp.next;
            index++;
        }
        System.out.println(nodeValue + " does not exist.");
    }
    public void delete(int location){
        if(head==null){
            System.out.println("The Doubly Linked Node doesn't exist.");
            return;
        }
        else if(location==0){
            if(length==1){
                head=null;
                tail=null;
                length--;
                System.out.println("Doubly Linked Node Deleted Successfully.");
                return;
            }
            head=head.next;
            head.prev=null;
            length--;
        }
        else if(location>=length-1){
            Node temp = tail.prev;
            temp.next=null;
            tail.prev=null;
            tail=temp;
            length--;
        }
        else{
            Node temp =head;
            Node temp1 = head.next;
            for(int i=0;i<location-1;i++){
                temp=temp.next;
                temp1=temp1.next;
            }
            temp.next = temp1.next;
            temp1.prev=null;
            temp1.next=null;
            if(temp.next!=null) temp.next.prev = temp;
            else tail= temp;
            length--;
        }
        System.out.println("Doubly Linked Node Deleted Successfully.");
    }

    public void deleteDoublyLinkedList(){
        head=null;
        tail=null;
        length=0;
        System.out.println("Doubly Linked List deleted successfully");
    }

    public void deleteDups(){
        Node temp = head;
        Node temp1 = temp.next;
        Node temp2=temp1;

        while(temp != null){
            while(temp1 != null){
                if(temp.value==temp1.value){
                    temp1=temp1.prev;
                    temp2.prev=null;
                    if(temp2.next != null) temp2=temp2.next;
                    else {
                        temp2=null;
                        tail=temp1;
                    }
                    temp1.next=temp2;
                    if(temp2!=null) temp2.prev=temp1;
                    length--;
                }
                temp1=temp1.next;
                temp2=temp1;
            }
            temp=temp.next;
            if(temp!=null) temp1=temp.next;
            temp2=temp1;
        }
    }

}
