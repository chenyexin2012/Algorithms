package com.holmes.tree;

import org.junit.Test;

public class BinarySortTreeTest {

    @Test
    public void binarySortTree() {

        BinarySortTree<Integer> tree = new BinarySortTree<>();

        tree.insert(10);
        tree.insert(15);
        tree.insert(31);
        tree.insert(3);
        tree.insert(7);
        tree.insert(9);
        tree.insert(50);
        tree.insert(30);
        tree.insert(36);
        tree.insert(30);
        tree.insert(29);
        tree.insert(18);
        tree.insert(50);
        tree.insert(11);
        tree.insert(13);

        System.out.println();
        tree.inOrderTraverse();
        System.out.println();


        System.out.println(tree.search(120));
        System.out.println(tree.search(30));
        System.out.println(tree.search(31));
        System.out.println(tree.search(11));
        System.out.println(tree.search(18));
    }
}
