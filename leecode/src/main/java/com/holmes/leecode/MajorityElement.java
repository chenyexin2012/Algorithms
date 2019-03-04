package com.holmes.leecode;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new MajorityElement().majorityElement(new int[]{1}));
    }

    public int majorityElement(int[] nums) {

        int middle = nums.length / 2 + 1;
        Arrays.sort(nums);
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
                if (count >= middle) {
                    return nums[i];
                }
            } else {
                count = 1;
                temp = nums[i];
            }
        }
        return temp;
    }
}
