package com.holmes.tree;

public class TreeNode<T> {

    public T data;
    public TreeNode<T> child, sibling;

    public TreeNode(T data, TreeNode<T> child, TreeNode<T> sibling) {
        super();
        this.data = data;
        this.child = child;
        this.sibling = sibling;
    }

    public TreeNode(T data) {
        this(data, null, null);
    }

    public TreeNode() {
        this(null);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}