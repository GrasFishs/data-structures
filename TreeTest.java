import java.util.Random;

/**
 * Created by GrasFish on 2017/9/18.
 */
public class TreeTest {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        int [] nums = {7,4,2,1,3,6,5,9,8,10};
        int [] nums2 = {1,5,4,3,2,6};
        for(int i =0;i<20;i++){
            Random  random = new Random();
            int r = random.nextInt(50);
            binaryTree.insert(r);
            System.out.print(r+" ");
        }
        System.out.println();
        System.out.println("节点数:"+binaryTree.size());
        System.out.println("最小"+binaryTree.findMin());
        System.out.println("最大"+binaryTree.findMax());
        binaryTree.preOrder();
        //binaryTree.inOrder();
        //binaryTree.postOrder();
    }
}
