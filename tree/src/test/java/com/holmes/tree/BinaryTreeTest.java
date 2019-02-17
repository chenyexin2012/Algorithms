package com.holmes.tree;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void createBinary() {

        BinaryTree<String> tree = new BinaryTree<String>();
        BinaryTreeNode root = new BinaryTreeNode<String>("A");
        tree.setRoot(root);

        BinaryTreeNode left = tree.insertChild(root, "B", true);
        BinaryTreeNode right = tree.insertChild(root, "C", false);

        BinaryTreeNode p = left;
        BinaryTreeNode q = right;
        left = tree.insertChild(p, "D", true);
        tree.insertChild(p, "E", false);

        p = left;

        tree.insertChild(q, "F", false);

        tree.insertChild(p, "G", true);


        tree.preOrderTraverse();

        System.out.println();

        tree.inOrderTraverse();

        System.out.println();

        tree.postOrderTraverse();

        System.out.println();

        tree.levelOrderTraverse();

        System.out.println();

        System.out.println();

        tree.removeChild(q, false);
        tree.removeChild(p, true);

        tree.preOrderTraverse();

        System.out.println();

        tree.inOrderTraverse();

        System.out.println();

        tree.postOrderTraverse();

        System.out.println();

        tree.levelOrderTraverse();

        System.out.println();
    }
}
