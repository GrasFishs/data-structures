import java.time.temporal.ValueRange;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by GrasFish on 2017/9/17.
 */
public class BinarySearchTree {

    private class TreeNode {
        TreeNode left;
        int element;
        TreeNode right;
        int depth;

        TreeNode() {
            element = 0;
            depth = 1;
            left = null;
            right = null;
        }

        TreeNode(int e) {
            element = e;
            depth = 1;
            left = null;
            right = null;
        }
    }

    private TreeNode root;
    private int count;

    public BinarySearchTree() {
        count = 0;
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    boolean isEmpty() {
        return root == null;
    }

    boolean contains(int value) {
        return find(value) != null;
    }

    TreeNode find(int value) {
        return find(value, root);
    }

    int findMin() {
        return findMin(root).element;
    }

    int findMax() {
        return findMax(root).element;
    }

    private TreeNode find(int value, TreeNode node) {
        if (node == null)
            return null;
        if (value > node.element)
            return find(value, node.right);
        else if (value < node.element)
            return find(value, node.left);
        else
            return node;
    }

    private TreeNode findMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }

    }

    private TreeNode findMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findMax(node.right);
        } else {
            return node;
        }
    }

    void insert(int value) {
        count++;
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
        } else {
            TreeNode p = root;
            TreeNode parent;
            while (true) {
                node.depth++;
                parent = p;
                if (node.element > p.element) {
                    p = p.right;
                    if (p == null) {
                        parent.right = node;
                        break;
                    }
                } else {
                    p = p.left;
                    if (p == null) {
                        parent.left = node;
                        break;
                    }
                }
            }
        }
    }

    int size() {
        return count;
    }

    void preOrderWithStack() {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                for (int i = 1; i < p.depth; i++) {
                    System.out.print("-");
                }
                System.out.print(p.element);
                System.out.println();
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    void deleteBST(int value){
        deleteBST(root,value);
    }

    private void deleteBST(TreeNode T, int value) {
        if (T == null) return;
        else {
            System.out.println("得到:"+T.element);
            if (value == T.element)
                delete(T);
            else if (value < T.element)
                deleteBST(T.left, value);
            else
                deleteBST(T.right, value);
        }
    }

    private void delete(TreeNode p){
        TreeNode q = new TreeNode();
        TreeNode s = new TreeNode();

        /**
         * 设p节点的父节点为 f , f.left = p 或 f.right = p
         * 如果不存在右子树，只用连接他的左子树
         * 将q节点指向 p, p指向 p 的左子树
         * 此时的 父节点 f 指向的就是原先的p 的左子树 。因为 f的左子树或右子树始终指向p，p向下移动,f也(看起来)跟着向下移动。
         * 也就是原先的 p节点(现在的 q 节点)没有父亲了，成为游离的对象，需要设为Null
         *
         */

        if(p.right == null){
            q = p;
            p = p.left;
            q = null;
        }

        /**
         * * 如果不存在左子树，只用连接他的右子树
         */
        else if(p.left == null){
            q = p;
            p = p.right;
            q = null;
        }

        /**
         *设 所删节点 为 p ，其 父节点 为 f,f.left = p 或 f.right = p
         * 分为两种情况
         * 一、p的左子树没有右子树，即 p.left.right == null
         *    ---操作：设置p的左子树为 s ，把 p 的值替换为 s的值，再把 p 的左子树替换为 s 的左子树，
         *    相当于 p 被它的左子树替换了，p的左子树也被它的子树替换了
         *
         * 二、p的左子树有右子树， 即 p.left.right != null
         *    ---操作：设置p的左子树为 s，遍历 s 的右子树直到遇到叶子， 设置 q 为 s 的父节点，
         *    再把 p 的 值替换为 s 的值（因为 s 是 p 的左子树的所有节点里最大的值，
         *    这样保证了原先 p 的右子树的所有值也能比现在的 p 的值大，且 原先的 p 的左子树 所有值也比 现在的 p 小），
         *    最后将 s 的父节点 q 的右子树（原先的 s ）设置为 s 的左子树。
         *
         */

        else {
            q = p;
            s = p.left;
            while (s.right != null){
                q = s;
                s = s.right;
            }
            p.element = s.element;
            if( q != p){
                q.right = s.left;
            }else {
                q.left = s. left;
            }
            s = null;
        }
    }

    void preOrder() {
        System.out.println("前序遍历：");
        preOrder(root);
        System.out.println();
    }

    void inOrder() {
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();
    }

    void postOrder() {
        System.out.println("后序遍历：");
        postOrder(root);
        System.out.println();
    }

    void levelOrder() {
        /**
         * 使用队列，循环地将节点入队列
         * 每次输出出队的节点后，再将其左右节点入队
         */
        if (isEmpty()) return;
        TreeNode treeNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            for (int i = 1; i < treeNode.depth; i++) {
                System.out.print("-");
            }
            System.out.print(treeNode.element);
            System.out.println();
            if (treeNode.left != null)
                queue.add(treeNode.left);
            if (treeNode.right != null)
                queue.add(treeNode.right);
        }
    }

    private void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            for (int i = 1; i < treeNode.depth; i++) {
                System.out.print("-");
            }
            System.out.print(treeNode.element);
            System.out.println();
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    private void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            for (int i = 1; i < treeNode.depth; i++) {
                System.out.print("-");
            }
            System.out.print(treeNode.element);
            System.out.println();
            inOrder(treeNode.right);
        }
    }

    private void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            inOrder(treeNode.right);
            for (int i = 1; i < treeNode.depth; i++) {
                System.out.print("-");
            }
            System.out.print(treeNode.element);
            System.out.println();
        }
    }
}
