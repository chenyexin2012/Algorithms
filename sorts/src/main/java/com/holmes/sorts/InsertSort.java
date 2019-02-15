package com.holmes.sorts;

/**
 * 插入排序
 * <p>
 * 复杂度为 O(n^2)
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

        // 循环次数为 array.length - 1 次
        for (int i = 1; i < array.length; i++) {
            // 每次循环都将一个数字插入到一个有序数组中
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (temp < array[j]) {
                        array[j + 1] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + 1] = temp;
            }
        }

    }
}
