package com.holmes.leecode;

/**
 * @author Administrator
 */
public class SingleNumber {

    public static void main(String[] args) {

        System.out.println(new SingleNumber().singleNumber(new int[]{1,2,1,2,3}));;
    }

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
