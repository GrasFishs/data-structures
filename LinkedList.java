/**
 * Created by GrasFish on 2017/9/16.
 */
class LinkedList {

    protected class Node {
        int e;
        Node next;

        Node() {
            this.next = null;
        }

        Node(int element) {
            this.e = element;
            this.next = null;
        }
    }

    protected Node head;

    public LinkedList() {
        head = new Node();
    }

    void printList() {
        System.out.println();
        Node p = head.next;
        if (isEmpty()) {
            System.out.println("链表为空，无法输出");
        } else {
            for (; p != null; p = p.next) {
                if (p.next != null)
                    System.out.print(p.e + " -> ");
                else
                    System.out.print(p.e);
            }
            System.out.println();
        }
    }

    Node getTail(){
        Node p = head;
        for(;p.next !=null;p = p.next);
        return p;
    }

    void sortPoly(){
        Node p,q;
        int temp;
        for(p=head;p!=null;p = p.next){
            for(q = p.next;q!=null;q =q.next){
                if(p.e > q.e){
                    temp = q.e;
                    q.e = p.e;
                    p.e = temp;
                }
            }
        }
    }
    boolean isEmpty() {
        return head.next == null;
    }

    boolean isLast(Node pos) {
        return pos.next == null;
    }

    Node find(int ele) {
        Node p = head.next;
        while (p != null && p.e != ele) {
            p = p.next;
        }
        return p;
    }

    Node findPrevious(int ele) {
        Node p = head.next;
        while (p != null && p.next.e != ele) {
            p = p.next;
        }
        return p;
    }

    void delete(int ele) {
        Node preNode = findPrevious(ele);
        Node delNode;
        if (!isLast(preNode)) {
            delNode = preNode.next;
            preNode.next = delNode.next;
            delNode = null;
        } else {
            preNode.next = null;
        }
    }

    void appendToTail(int ele) {
        Node p = head;
        Node last = new Node(ele);
        while(p.next!=null){
            p = p.next;
        }
        p.next = last;
    }

    void appendToHead(int ele) {
        Node first = new Node(ele);
        Node afterHead = head.next;
        first.next = afterHead;
        head.next = first;
    }

    void insertAfter(int insertEle, int ele) {
        Node p = find(ele);
        Node insert = new Node(insertEle);
        if (isLast(p)) {
            p.next = insert;
        } else {
            insert.next = p.next;
            p.next = insert;
        }
    }

    int length() {
        int count = 0;
        Node p = head;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    @Override
    public String toString() {
        return getClass().getName() + "有 " + length() + " 个元素";
    }

}
