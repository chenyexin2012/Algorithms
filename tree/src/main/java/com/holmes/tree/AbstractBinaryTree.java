package com.holmes.tree;

public abstract class AbstractBinaryTree<T> {

    /**
     * 插入根节点
     *
     * @param value
     */
    public abstract void insertRoot(T value);

    /**
     * 插入孩子节点
     *
     * @param node
     * @param value
     * @param isLeftChild 是否为左孩子
     * @return
     */
    public abstract BinaryTreeNode<T> insertChild(BinaryTreeNode<T> node, T value, boolean isLeftChild);

    /**
     * @param node
     * @param isLeftChild 是否为左孩子
     */
    public abstract void removeChild(BinaryTreeNode<T> node, boolean isLeftChild);

    /**
     * 清空二叉树
     */
    public abstract void destroy();

    /**
     * 判断二叉树是否为空
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * 返回节点个数
     *
     * @return
     */
    public abstract int count();

    /**
     * 返回数的高度
     *
     * @return
     */
    public abstract int height();


    /**
     * 查找节点值为key的节点
     *
     * @param key
     * @return
     */
    public abstract BinaryTreeNode<T> search(T key);

    /**
     * 返回节点的父母节点
     *
     * @param node
     * @return
     */
    public abstract BinaryTreeNode<T> getParent(BinaryTreeNode<T> node);


    /**
     * 先序遍历
     */
    public abstract void preOrderTraverse();

    /**
     * 中序遍历
     */
    public abstract void inOrderTraverse();

    /**
     * 后序遍历
     */
    public abstract void postOrderTraverse();

    /**
     * 按层遍历
     */
    public abstract void levelOrderTraverse();
}
