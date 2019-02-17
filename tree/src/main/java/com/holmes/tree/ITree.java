package com.holmes.tree;

import java.util.List;

public interface ITree<T> {

    /**
     * 是否为空数
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 获取node节点的孩子集合
     *
     * @param node
     * @return
     */
    public List<TreeNode<T>> getChildren(TreeNode<T> node);

    /**
     * 获取node节点的第i个孩子
     *
     * @param node
     * @param i
     * @return
     */
    public TreeNode<T> getChild(TreeNode<T> node, int i);

    /**
     * 获取p节点的最后一个孩子
     *
     * @param node
     * @return
     */
    public TreeNode<T> getLastChild(TreeNode<T> node);

    /**
     * 获取p节点最后一个兄弟节点
     *
     * @param node
     * @return
     */
    public TreeNode<T> getLastSibling(TreeNode<T> node);

    /**
     * 获取node的父母节点
     *
     * @param node
     * @return
     */
    public TreeNode<T> getParent(TreeNode<T> node);

    /**
     * 获取树的节点个数
     *
     * @return
     */
    public int count();

    /**
     * 获取节点p的孩子节点个数
     *
     * @param node
     * @return
     */
    public int childCount(TreeNode<T> node);

    /**
     * 获取树的高度
     *
     * @return
     */
    public int height();

    /**
     * 查找内容为T的节点并返回
     *
     * @param x
     * @return
     */
    public TreeNode<T> search(T x);

    /**
     * 先根遍历
     */
    public void preOrder();

    /**
     * 后根遍历
     */
    public void postOrder();

    /**
     * 按层遍历
     */
    public void levelOrder();
}
