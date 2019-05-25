package com.holmes.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 平衡二叉树
 *
 * @param <T>
 */
public class AvlTree<T extends Comparable> {

    public static void main(String[] args) {

        Random random = new Random();
        AvlTree<Integer> avlTree = new AvlTree<>();
        for (int i = 0; i < 10; i++) {
            Integer num = random.nextInt(1000);
            avlTree.insert(num);
        }

        avlTree.inOrderTraverse();
    }

    /**
     * 头节点
     */
    private AvlTreeNode<T> head = null;

    public AvlTreeNode<T> getHead() {
        return head;
    }

    public void setHead(AvlTreeNode<T> head) {
        this.head = head;
    }

    public void insert(T value) {
        this.head = insert(head, value);
    }

    /**
     * 递归插入数据
     *
     * @param node
     * @param value
     * @return
     */
    private AvlTreeNode<T> insert(AvlTreeNode<T> node, T value) {

        if (node == null) {
            node = new AvlTreeNode<>(value);
        } else if (node.data.compareTo(value) <= 0) {

            AvlTreeNode<T> p = insert(node.right, value);
            node.right = p;
            p.parent = node;

            // 判断节点是否失衡
            if (height(node.right) - height(node.left) == 2) {

                if (node.right.data.compareTo(value) <= 0) {
                    node = rotateLeft(node);
                } else {
                    node = rotateRightThenLeft(node);
                }
            }
        } else {
            AvlTreeNode<T> p = insert(node.left, value);
            node.left = p;
            p.parent = node;

            // 判断节点是否失衡
            if (height(node.left) - height(node.right) == 2) {

                if (node.left.data.compareTo(value) <= 0) {
                    node = rotateLeftThenRight(node);
                } else {
                    node = rotateRight(node);
                }
            }
        }
        return node;
    }

    public AvlTreeNode<T> search(T key) {
        return null;
    }

    public void visit(AvlTreeNode<T> node) {
        System.out.println(node.data + "\t");
    }

    /**
     * 新的节点加在左子树的左子树上 ==> 顺时针旋转
     *
     * @param node
     * @return
     */
    private AvlTreeNode<T> rotateRight(AvlTreeNode<T> node) {

        // 1. 将node的左节点left作为新的头节点
        // 2. 将left的右节点作为node的左节点
        AvlTreeNode<T> left = node.left;
        AvlTreeNode<T> leftRight = left.right;

        left.right = node;
        node.parent = left;
        node.left = leftRight;

        if (leftRight != null) {
            leftRight.parent = node;
        }
        return left;
    }

    /**
     * 新的节点加在右子树的右子树上 ==> 逆时针旋转
     *
     * @param node
     * @return
     */
    private AvlTreeNode<T> rotateLeft(AvlTreeNode<T> node) {

        // 1. 将node的左节点left作为新的头节点
        // 2. 将left的右节点作为node的左节点
        AvlTreeNode<T> right = node.right;
        AvlTreeNode<T> rightLeft = right.left;

        right.left = node;
        node.parent = right;
        node.right = rightLeft;

        if (rightLeft != null) {
            rightLeft.parent = node;
        }
        return right;
    }

    /**
     * 新的节点加在右子树的左子树上
     *
     * @param node
     * @return
     */
    private AvlTreeNode<T> rotateLeftThenRight(AvlTreeNode<T> node) {

        // 对右子树进行左旋
        AvlTreeNode<T> p = rotateLeft(node.left);
        node.left = p;
        p.parent = node;
        // 右旋
        return rotateRight(node);
    }

    /**
     * 新的节点加在右子树的左子树上
     *
     * @param node
     * @return
     */
    private AvlTreeNode<T> rotateRightThenLeft(AvlTreeNode<T> node) {

        // 对左子树进行右旋
        AvlTreeNode<T> p = rotateRight(node.right);
        node.right = p;
        p.parent = node;
        // 左旋
        return rotateLeft(node);
    }

    /**
     * 返回节点个数
     *
     * @return
     */
    public int count(AvlTreeNode<T> node) {
        if (node == null) return 0;
        return count(node.left) + count(node.right) + 1;
    }

    /**
     * 返回树的高度
     *
     * @return
     */
    public int height(AvlTreeNode<T> node) {
        if (node == null) return 0;
        int heightOfLeft = height(node.left);
        int heightOfRight = height(node.right);
        return heightOfLeft > heightOfRight ? heightOfLeft + 1 : heightOfRight + 1;
    }

    public void preOrderTraverse() {
        preOrderTraverse(this.head);
    }

    public void inOrderTraverse() {
        inOrderTraverse(this.head);
    }

    public void postOrderTraverse() {
        postOrderTraverse(this.head);
    }

    /**
     * 先序遍历
     */
    private void preOrderTraverse(AvlTreeNode<T> node) {
        if (node == null) return;
        visit(node);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     */
    private void inOrderTraverse(AvlTreeNode<T> node) {
        if (node == null) return;
        inOrderTraverse(node.left);
        visit(node);
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     */
    private void postOrderTraverse(AvlTreeNode<T> node) {
        if (node == null) return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        visit(node);
    }

    /**
     * 按层遍历
     */
    public void levelOrderTraverse() {

        Queue<AvlTreeNode<T>> queue = new LinkedList<>();
        queue.add(this.head);
        while (!queue.isEmpty()) {
            AvlTreeNode<T> p = queue.remove();
            if (null != p) {
                visit(p);
                if (null != p.left) {
                    queue.add(p.left);
                }
                if (null != p.right) {
                    queue.add(p.right);
                }
            }
        }
    }
}
