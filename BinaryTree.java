import java.time.temporal.ValueRange;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by GrasFish on 2017/9/17.
 */
public class BinaryTree {

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

    public BinaryTree() {
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
        }
        else {
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
