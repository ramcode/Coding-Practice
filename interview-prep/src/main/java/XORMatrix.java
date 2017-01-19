import java.io.*;
import java.util.*;

public class XORMatrix {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] mat = new int[m][n];
		for(int i=0; i<n; i++) {
			mat[0][i] = in.nextInt();
		}
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == n - 1) {
					mat[i][j] = mat[i - 1][j] ^ mat[i - 1][0];
					
				} else {
					mat[i][j] = mat[i - 1][j] ^ mat[i - 1][j + 1];
				}
			}
			printArray(mat[i]);
		}
		printArray(mat[m - 1]);
	}
	
	public static void printArray(int[] n){
		for(int num:n){
			System.out.print(num+" ");
		}
		System.out.println();
	}
}