package com.holmes.tree;

import java.util.LinkedList;
import java.util.List;

public class Tree<T> implements ITree<T> {

    /**
     * 树的根节点
     */
    private TreeNode<T> root;

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * 为p节点新增孩子节点node
     *
     * @param p
     * @param node
     */
    public void insertChild(TreeNode<T> p, TreeNode<T> node) {

        if (null == p || null == node) {
            return;
        }
        if (p.child == null) {
            p.child = node;
        } else {
            insertSibling(p.child, node);
        }
    }

    /**
     * 为p节点新增兄弟节点
     *
     * @param p
     * @param node
     */
    public void insertSibling(TreeNode<T> p, TreeNode<T> node) {
        if (null == p || null == node) {
            return;
        }
        while (null != p.sibling) {
            p = p.sibling;
        }
        p.sibling = node;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public List<TreeNode<T>> getChildren(TreeNode<T> node) {
        if (null == node || null == node.child) {
            return null;
        }
        TreeNode<T> p = node.child;
        List<TreeNode<T>> list = new LinkedList<>();
        list.add(node.child);
        while (null != p.sibling) {
            p = p.sibling;
            list.add(p);
        }
        return list;
    }

    @Override
    public TreeNode<T> getChild(TreeNode<T> node, int i) {

        if (null == node || null == node.child) {
            return null;
        }
        TreeNode<T> p = node.child;
        while (i-- > 0 && null != p) {
            p = p.sibling;
        }
        return p;
    }

    @Override
    public TreeNode<T> getLastChild(TreeNode<T> node) {

        if (null == node || null == node.child) {
            return null;
        }
        TreeNode<T> p = node.child;
        while (null != p.sibling) {
            p = p.sibling;
        }
        return p;
    }

    @Override
    public TreeNode<T> getLastSibling(TreeNode<T> node) {

        if (null == node || null == node.sibling) {
            return null;
        }
        TreeNode<T> p = node.sibling;
        while (null != p.sibling) {
            p = p.sibling;
        }
        return p;
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {


        return null;
    }

    @Override
    public int count() {
        return count(root);
    }

    private int count(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        // 递归求子节点与兄弟节点个数
        return 1 + count(node.child) + count(node.sibling);
    }

    @Override
    public int childCount(TreeNode<T> node) {

        if (null != node || null == node.child) {
            return 0;
        }
        int count = 1;
        TreeNode<T> p = node.child;
        while (null != p.sibling) {
            count++;
            p = p.sibling;
        }
        return count;
    }

    @Override
    public int height() {
        return 0;
    }


    @Override
    public TreeNode<T> search(T x) {
        return null;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void levelOrder() {

    }
}
