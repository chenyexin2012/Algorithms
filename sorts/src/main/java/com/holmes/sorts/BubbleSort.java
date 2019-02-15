package com.holmes.sorts;

/**
 * 冒泡排序
 *
 * 复杂度为 O(n^2)
 */
public class BubbleSort extends AbstractSort{

    public static void main(String[] args) {

        int[] array = new int[]{15, 18, 13, 16, 2, 5, 8, 4, 6, 9, 12, 3, 5, 15, 16, 118, 1, 6};

        AbstractSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        bubbleSort.display(array);
    }

    @Override
    public void sort(int[] array) {

        // 遍历总次数为 array.length - 1 次
        for (int i = 0; i < array.length - 1; i++) {
            // 每次遍历都将一个最大的元素往上冒
            for (int j = 1; j < array.length - i; j++) {
                // 每次比较相邻两个数字
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
