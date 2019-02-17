package com.holmes.tree;

public interface IBinarySortTree<T extends Comparable> {

    public void insert(T value);

    public BinaryTreeNode<T> search(T value);
}
