package com.holmes.sorts;

/**
 * 归并排序
 * <p>
 * 复杂度为 O(n log n)
 * <p>
 * 稳定排序
 */
public class MergeSort extends AbstractSort {

    public static void main(String[] args) {

        int[] array = new int[]{15, 18, 13, 16, 2, 5, 8, 4, 6, 9, 12, 3, 5, 15, 16, 118, 1, 6};

        AbstractSort sort = new MergeSort();
        sort.sort(array);
        System.out.print("排序结果：");
        sort.display(array);
    }

    public void sort(int[] array) {

        int[] merge = new int[array.length];
        mergeSort(array, merge, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] merge, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (end + start) >> 1;
        // 通过递归将数组分割
        mergeSort(array, merge, start, middle);
        mergeSort(array, merge, middle + 1, end);

        // 合并数组
        merge(array, merge, start, end, middle);
    }

    private void merge(int[] array, int[] merge, int start, int end, int middle) {

        int i = start;
        int j = middle + 1;
        int pos = start;
        while (i <= middle && j <= end) {
            merge[pos++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= middle) {
            merge[pos++] = array[i++];
        }
        while (j <= end) {
            merge[pos++] = array[j++];
        }
        // 将归并结果复制到array数组中
        for (pos = start; pos <= end; pos++) {
            array[pos] = merge[pos];
        }
    }

}
