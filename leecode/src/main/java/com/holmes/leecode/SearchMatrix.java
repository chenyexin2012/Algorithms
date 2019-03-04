package com.holmes.leecode;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class SearchMatrix {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new SearchMatrix().searchMatrix(matrix, 20));
        System.out.println(new SearchMatrix().searchMatrix(matrix, 5));
        System.out.println(new SearchMatrix().searchMatrix(matrix, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length >= 1 && matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                if (Arrays.binarySearch(matrix[i], target) >= 0) {
                    return true;
                } else if (matrix[i][0] > target) {
                    break;
                }
            }
        }
        return false;
    }
}
