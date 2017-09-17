/**
 * Created by GrasFish on 2017/9/16.
 */

import java.util.regex.*;

public class OtherTest {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        for (int i = 0; i < 10; i++) {
            linkedStack.push(i);
        }
        linkedStack.pop();
        linkedStack.printStack();

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for(int i = 0;i<10;i++){
            linkedQueue.enqueue(i);
        }
        linkedQueue.dequeue();
        linkedQueue.printQueue();
    }
}
