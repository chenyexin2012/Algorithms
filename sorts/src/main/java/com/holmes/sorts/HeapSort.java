package com.holmes.sorts;

/**
 * 堆排序
 * <p>
 * 复杂度为 O(n log n)
 */
public class HeapSort extends AbstractSort {

    public static void main(String[] args) {

        int[] array = new int[]{15, 18, 13, 16, 2, 5, 8, 4, 6, 9, 12, 3, 5, 15, 16, 118, 1, 6};

        AbstractSort sort = new HeapSort();
        sort.sort(array);
        System.out.print("排序结果：");
        sort.display(array);
    }

    public void sort(int[] array) {

        // 生成大顶堆
        for (int i = array.length >> 1; i >= 0; i--) {
            adjustArray(array, i, array.length - 1);
        }

        for(int i = array.length - 1; i >= 0; i--) {
            // 将堆顶的数字与下标为 i 的数字交换，即将当前最大的数字移至当前堆的最后
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 调整大顶堆
            adjustArray(array, 0, i - 1);
        }

    }

    /**
     * 将堆调整成为大顶堆
     *
     * @param array
     * @param start
     * @param end
     */
    private void adjustArray(int[] array, int start, int end) {

        int temp = array[start];
        // 左右孩子下表分别为 start * 2 + 1， start * 2 + 2
        for (int i = start * 2 + 1; i <= end; i = i * 2 + 1) {

            // 比较左右孩子大小，取最大
            if (i < end && array[i] < array[i + 1]) {
                i++;
            }
            // 已经是大顶堆
            if (temp >= array[i]) {
                break;
            }
            array[start] = array[i];
            start = i;
        }
        array[start] = temp;
    }
}
