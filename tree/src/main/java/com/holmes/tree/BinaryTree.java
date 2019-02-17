package com.holmes.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> extends AbstractBinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void insertRoot(T value) {
        this.root = new BinaryTreeNode<>(value);
    }

    @Override
    public BinaryTreeNode<T> insertChild(BinaryTreeNode<T> node, T value, boolean isLeftChild) {
        if (null == node) {
            return null;
        }
        BinaryTreeNode<T> child = new BinaryTreeNode<>(value);
        if (isLeftChild) {
            node.left = child;
        } else {
            node.right = child;
        }
        return child;
    }

    @Override
    public void removeChild(BinaryTreeNode<T> node, boolean isLeftChild) {
        if (null == node) {
            return;
        }
        if (isLeftChild) {
            node.left = null;
        } else {
            node.right = null;
        }
    }

    @Override
    public void destroy() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int count() {
        return count(root);
    }

    private int count(BinaryTreeNode<T> node) {
        if (null != node) {
            return 1 + count(node.left) + count(node.right);
        }
        return 0;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode<T> node) {
        if (null != node) {
            int left = height(node.left);
            int right = height(node.right);
            return left > right ? left : right;
        }
        return 0;
    }

    @Override
    public BinaryTreeNode<T> search(T key) {
        return search(root, key);
    }

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T key) {

        if (key.equals(node.data)) {
            return node;
        } else {
            BinaryTreeNode<T> left = search(node.left, key);
            BinaryTreeNode<T> right = search(node.right, key);
            if (null != left) {
                return left;
            } else if (null != right) {
                return right;
            }
        }
        return null;
    }

    @Override
    public BinaryTreeNode<T> getParent(BinaryTreeNode<T> node) {
        return null;
    }

    @Override
    public void preOrderTraverse() {
        preOrderTraverse(this.root);
    }

    private void preOrderTraverse(BinaryTreeNode<T> node) {
        if (null != node) {
            visit(node);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    @Override
    public void inOrderTraverse() {
        inOrderTraverse(this.root);
    }

    private void inOrderTraverse(BinaryTreeNode<T> node) {
        if (null != node) {
            inOrderTraverse(node.left);
            visit(node);
            inOrderTraverse(node.right);
        }
    }


    @Override
    public void postOrderTraverse() {
        postOrderTraverse(this.root);
    }

    private void postOrderTraverse(BinaryTreeNode<T> node) {
        if (null != node) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            visit(node);
        }
    }

    @Override
    public void levelOrderTraverse() {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> p = queue.remove();
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

    private void visit(BinaryTreeNode<T> node) {
        System.out.print(node.data + "\t");
    }
}
