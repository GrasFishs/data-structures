/**
 * Created by GrasFish on 2017/9/16.
 */
public class ListTest {
    public static void main(String[] args) {
        /*
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial p3;
        String s1 = "10x^8+5x^-8+-9x^8+0x^5+10x^-2+-1311.2x^-6+5x^8";
        String s2 = "165x^8";
        String s3 = "0x^5";
        p1.createList(s1);
        p2.createList(s3);
        p1.printPolyList();
        p2.printPolyList();
        p3 = p1.plus(p2);
        p3.printPolyList();
        */

        /*
        ScienceCompute sc = new ScienceCompute("8*(9+6/2-4)+9");
        System.out.println(sc.getInfix()+" = "+sc.compute());

        */

        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for(int i =0;i<10;i++){
            queue.enqueue(i);
        }
        System.out.println(queue.dequeue());
        queue.printQueue();
        /*
        LinkedList linkedList = new LinkedList();
        for(int i =0;i<10;i++){
            Random r = new Random();
            int num = r.nextInt(10);
            linkedList.appendToTail(num);
        }
        linkedList.printList();
        linkedList.sortPoly();
        linkedList.printList();

        */
    }
}
