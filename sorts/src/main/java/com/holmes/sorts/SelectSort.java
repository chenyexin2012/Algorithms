package com.holmes.sorts;

/**
 * 选择排序
 * <p>
 * 复杂度为 O(n^2)
 */
public class SelectSort extends AbstractSort {

    public static void main(String[] args) {

        int[] array = new int[]{15, 18, 13, 16, 2, 5, 8, 4, 6, 9, 12, 3, 5, 15, 16, 118, 1, 6};

        AbstractSort bubbleSort = new SelectSort();
        bubbleSort.sort(array);
        bubbleSort.display(array);
    }

    public void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i];
            int index = i;
            // 每次选择剩余数字中最小的，与下标为 i 的数字交换
            for (int j = i + 1; j < array.length; j++) {
                if(temp > array[j]) {
                    temp = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
