/**
 * Created by GrasFish on 2017/9/17.
 */
public class LinkedQueue<T> {

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

    private Node front,rear;

    public LinkedQueue(){
        front = new Node();
        rear = front;
    }

    boolean isEmpty(){
        return front == rear;
    }


    void enqueue(T e){
        rear.next = new Node(e);
        rear = rear.next;
    }

    T peak(){
        return front.element;
    }

    T dequeue(){
        Node p = front.next;
        T ele = p.element;
        front.next = p.next;
        p = null;
        return ele;
    }

    void printQueue(){
        System.out.println();
        Node p = front.next;
        if (isEmpty()) {
            System.out.println("队列为空，无法输出");
        } else {
            for (; p != null; p = p.next) {
                if (p.next != null)
                    System.out.print(p.element + " == ");
                else
                    System.out.print(p.element);
            }
            System.out.println();
        }
    }
}
