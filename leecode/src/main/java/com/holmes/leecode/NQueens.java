package com.holmes.leecode;

import java.util.Scanner;

/**
 * N皇后
 *
 * @author Administrator
 */
public class NQueens {

    private static int N = 8;

    private static int count = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("N = ");
        N = in.nextInt();

        int[][] chess = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = 0;
            }
        }
        new NQueens().putQueen(chess, 0);
    }


    public void putQueen(int[][] chess, int row) {
        if (row == N) {
            System.out.println("第" + ++count + "种结果");
            display(chess);
            return;
        }
        for (int i = 0; i < N; i++) {
            // 将当前列重新置为0
            for (int j = 0; j < N; j++) {
                chess[row][j] = 0;
            }
            chess[row][i] = 1;
            if (isSafe(chess, row, i)) {
                putQueen(chess, row + 1);
            }
        }
    }

    private boolean isSafe(int[][] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] == 1 && (col == j || Math.abs(row - i) == Math.abs(col - j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void display(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                System.out.print(chess[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
