package com.holmes.leecode;

import java.util.Arrays;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author Administrator
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 150};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] indexArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexArray[0] = i;
                    indexArray[1] = j;
                }
            }
        }
        return indexArray;
    }
}
