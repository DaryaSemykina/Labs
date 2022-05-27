package com.company;

public class MatrixCalculator {
    public static int[][] doMat(int a, int b) {
        int[][] mat = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                mat[i][j] = (int) (Math.random() * 10000);
            }
        }
        return mat;
    }

    public static int[][] calcSumMat(int[][] a, int[][] b) {
        int[][] calcmat = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                calcmat[i][j] = a[i][j] + b[i][j];
            }
        }
        return calcmat;
    }

    public static void showMat(int[][] a) {
        String matrix = "";
        for (int i = 0; i < a.length; i++) {
            matrix += "{";
            for (int j = 0; j < a[0].length; j++) {
                if (j == (a[0].length - 1))
                    matrix += a[i][j];
                else
                    matrix += a[i][j]+ ", ";
            }
            matrix += "}\n";
        }
        System.out.print(matrix);
    }
}
