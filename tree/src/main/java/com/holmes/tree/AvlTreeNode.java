package com.holmes.tree;

/**
 * 平衡二叉树结点定义
 *
 * @param <T>
 */
public class AvlTreeNode<T extends Comparable> {

    public T data;

    public int height;

    public AvlTreeNode<T> left, right, parent;

    public AvlTreeNode(T data) {
        this(data, null, null, null);
    }

    public AvlTreeNode(T data, AvlTreeNode<T> left, AvlTreeNode<T> right, AvlTreeNode<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
