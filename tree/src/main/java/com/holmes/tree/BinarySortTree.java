package com.holmes.tree;

/**
 * 二叉查找树
 *
 * @param <T>
 */
public class BinarySortTree<T extends Comparable> extends BinaryTree<T> implements IBinarySortTree<T> {

    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };

    @Override
    public void insert(T value) {
        if (null == root) {
            this.root = new BinaryTreeNode<>(value);
            return;
        }
        insert(this.root, value);
    }

    private void insert(BinaryTreeNode<T> node, T value) {

        if (node.data.compareTo(value) > 0) {
            // 添加至左子树
            if (node.left == null) {
                node.left = new BinaryTreeNode<>(value);
            } else {
                insert(node.left, value);
            }
        } else {
            // 添加至右子树
            if (node.right == null) {
                node.right = new BinaryTreeNode<>(value);
            } else {
                insert(node.right, value);
            }
        }

    }

    @Override
    public BinaryTreeNode<T> search(T value) {
        count.set(0);
        BinaryTreeNode result = search(this.root, value);

        System.out.println("当前比较次数:" + this.count.get());
        return result;
    }

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T value) {

        this.count.set(this.count.get() + 1);

        if (null == node) {
            return null;
        }
        if (node.data.compareTo(value) == 0) {
            return node;
        }
        if (node.data.compareTo(value) > 0) {
            return search(node.left, value);
        }
        return search(node.right, value);
    }

    /**
     * 返回节点个数
     *
     * @return
     */
    public int count(BinaryTreeNode<T> node) {
        if (node == null) return 0;
        return count(node.left) + count(node.right) + 1;
    }

    /**
     * 返回树的高度
     *
     * @return
     */
    public int height(BinaryTreeNode<T> node) {
        if (node == null) return 0;
        int heightOfLeft = height(node.left);
        int heightOfRight = height(node.right);
        return heightOfLeft > heightOfRight ? heightOfLeft + 1 : heightOfRight + 1;
    }
}
