package com.holmes.sorts;

/**
 * 插入排序
 */
public class InsertSort extends AbstractSort {

    public static void main(String[] args) {

        int[] array = new int[]{15, 18, 13, 16, 2, 5, 8, 4, 6, 9, 12, 3, 5, 15, 16, 118, 1, 6};

        AbstractSort sort = new InsertSort();
        sort.sort(array);
        System.out.print("排序结果：");
        sort.display(array);
    }

    public void sort(int[] array) {



    }
}
