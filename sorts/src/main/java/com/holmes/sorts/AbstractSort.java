package com.holmes.sorts;

public abstract class AbstractSort {

    protected void display(int[] array) {
        for (int num : array) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public abstract void sort(int[] array);
}
