package Stack;

import java.util.ArrayList;

public class Stack {
    Object[] stack;
    int top;

    Stack(int size){
        this.stack = new Object[size];
        this.top=-1;
    }

    public boolean isEmpty(){
        if(top==-1) return true;
        else return false;
    }

    public boolean isFull(){
        if(top==stack.length-1) return true;
        else return false;
    }

    public void push(Object obj){
        if(!isFull()){
            stack[top+1] = obj;
            top++;
            return;
        }
        System.out.println("The stack is full.");
    }

    public Object pop(){
        if(!isEmpty()){
            Object obj = stack[top];
            top--;
            return obj;
        }
        System.out.println("The stack is empty.");
        return null;
    }

    public Object peek(){
        if(!isEmpty()){
            return stack[top];
        }
        System.out.println("The stack is empty");
        return null;
    }
     public void delete(Object obj){
        if(!isEmpty()){
            int i=0;
            while(i<stack.length){
                if(obj==stack[i]){
                    Object obj1 = stack[i];
                    top--;
                    break;
                }
                i++;
            }
            while(i<stack.length-1){
                stack[i] = stack[i+1];
                i++;
            }

        }
     }

     public void deleteStack(){
        stack = null;
        System.out.println("The stack is deleted successfully");
     }



}
