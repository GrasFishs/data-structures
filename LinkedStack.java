/**
 * Created by GrasFish on 2017/9/17.
 */
public class LinkedStack<T> {

    private class Node {
        T element;
        Node next;

        Node() {
            next = null;
        }

        Node(T e) {
            element = e;
            next = null;
        }
    }

    private Node head;
    private Node top;
    private int length = 0;

    public LinkedStack(){
        head = new Node();
        top = head;
    }

    boolean isEmpty(){
        return top == head;
    }

    Node getTop(){
        if(isEmpty())
            return null;
        else
            return top;
    }

    void printStack(){
        System.out.println();
        Node p = head.next;
        if (isEmpty()) {
            System.out.println("栈为空，无法输出");
        } else {
            for (; p != null; p = p.next) {
                if (p.next != null)
                    System.out.print(p.element + " <= ");
                else
                    System.out.print(p.element);
            }
            System.out.println();
        }
    }

    void push(T e){
        top.next = new Node(e);//尾部后加入新节点
        top = top.next;//尾部指向新节点
        length++;
    }

    T pop(){
        Node pre = head.next;
        for(;pre.next!=top;pre=pre.next){
            if(pre.next == top){
                pre = top;
                break;
            }
        }
        pre.next = null;
        top = pre;
        length--;
        return top.element;
    }

    int length(){
        return length;
    }

}
