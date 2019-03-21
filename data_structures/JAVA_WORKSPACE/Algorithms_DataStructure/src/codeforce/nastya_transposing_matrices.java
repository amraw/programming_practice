package codeforce;

import java.util.Scanner;

public class nastya_transposing_matrices {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n != m) {
            System.out.println("NO");
            return;
        }
        int[][] A = new int[n][n];
        int[][] B = new int[m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                B[i][j] = in.nextInt();
            }
        }
    }

}
