package com.holmes.leecode;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        new Merge().merge(new int[]{1, 2, 6, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int length = m;
        int index = 0;
        for (int i = 0; i < n; ) {
            if (index < length && nums1[index] > nums2[i]) {
                int j = length;
                for (; j > index; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[j] = nums2[i++];
                length++;
            } else if (index >= length) {
                nums1[index] = nums2[i++];
            }
            index++;
        }
    }
}
