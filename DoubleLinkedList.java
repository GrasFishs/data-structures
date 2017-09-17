/**
 * Created by GrasFish on 2017/9/16.
 */
class DoubleLinkedList<T> {

    private class Node {
        Node pre;   //指向前一个节点
        T element;
        Node next;  //指向后一个节点

        Node() {
            pre = null;
            next = null;
        }

        Node(T ele) {
            pre = null;
            element = ele;
            next = null;
        }
    }

    private Node head;

    public DoubleLinkedList() {
        head = new Node();
    }

    boolean isEmpty() {
        return head.next == null;
    }

    boolean isLast(Node p) {
        return p.next == null;
    }

    Node find(T e) {
        Node p = head.next;
        while (p != null && p.element != e) {
            p = p.next;
        }
        return p;
    }

    void delete(T e) {
        Node p = find(e), beforeP = p.pre, afterP = p.next;
        beforeP.next = afterP;
        afterP.pre = beforeP;
        p = null;
    }

    void insertAfter(T insert, T e) {
        Node p = find(e), afterP = p.next;
        Node in = new Node(insert);
        in.pre = p;
        in.next = afterP;
        afterP.pre = in;
        p.next = in;
    }

    void insertBefore(T insert, T e) {
        Node p = find(e), beforeP = p.pre;
        Node in = new Node(insert);
        in.pre = beforeP;
        in.next = p;
        beforeP.next = in;
        p.pre = in;
    }

    void appendToHead(T e) {
        Node insert = new Node(e);
        insert.pre = head;
        if (isEmpty()) {
            head.next = insert;
            insert.pre = head;
        } else {
            insert.next = head.next;//插入节点后继指向先前头节点的后一项
            head.next.pre = insert;//先前头结点的后一项的前驱指向插入节点
            head.next = insert;
        }
    }

    void appendToTail(T e) {
        Node p = getLast();
        Node insert = new Node(e);
        p.next = insert;
        insert.pre = p;
    }


    Node getLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    int length() {
        int count = 0;
        Node p = head.next;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    void printList() {
        System.out.println();
        Node p = head.next;
        if (isEmpty()) {
            System.out.println("双向链表为空，无法输出");
        } else {
            for (; p != null; p = p.next) {
                if (p.next != null)
                    System.out.print(p.element + " <=> ");
                else
                    System.out.print(p.element);
            }
            System.out.println();
        }
    }
}
