package com.holmes.sorts;

/**
 * 快速排序
 *
 * 在平均状况下，排序n个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n^2)次比较，但这种状况并不常见。
 */
public class QuickSort extends AbstractSort {

    private int index = 1;

    public static void main(String[] args) {

        int[] array = new int[]{15, 18, 13, 16, 2, 5, 8, 4, 6, 9, 12, 3, 5, 15, 16, 118, 1, 6};

        AbstractSort quickSort = new QuickSort();
        quickSort.sort(array);
        System.out.print("排序结果：");
        quickSort.display(array);
    }

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            // 将整体进行划分
            int result = partition(array, start, end);
            // 对左边部分进行划分
            quickSort(array, start, result - 1);
            // 对右边部分进行划分
            quickSort(array, result + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {

        // 选取第一个数字作为分割值，将所有数字按照与分割值的大小比较结果分成两个部分，完成一次排序过程
        int pivot = array[start];
        while (start < end) {

            // 从右往左查找，直到发现值比分割值小的数字，进行替换
            while (start < end && array[end] >= pivot) {
                end--;
            }
            array[start] = array[end];
            // 从左往右查找，直到发现值比分割值大的数字，进行替换
            while (start < end && array[start] <= pivot) {
                start++;
            }
            array[end] = array[start];
        }
        // 将分割值填充进入数组中
        array[start] = pivot;

//        System.out.print("第" + index++ + "趟排序，关键字为" + pivot + "，排序结果：");
//        display(array);

        return start;
    }
}
