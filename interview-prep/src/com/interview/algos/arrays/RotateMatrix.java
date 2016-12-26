package com.interview.algos.arrays;

public class RotateMatrix {

	public static int[][] rotateMatrixAntiClockWise(int[][] arr) {
		int[][] narr = new int[arr.length][arr[0].length];
		int col = 0;
		for (int i = 0; i < arr.length; i++) {
			int row = 0;
			for (int j = arr[0].length-1; j > -1; j--) {
				narr[row][col] = arr[i][j];
				row++;
			}
			col++;
		}
		return narr;
	}
	public static int[][] rotateMatrixClockWise(int[][] arr) {
		int[][] narr = new int[arr.length][arr[0].length];
		int col = arr[0].length-1;
		for (int i = 0; i < arr.length; i++) {
			int row = 0;
			for (int j = 0; j<arr[0].length; j++) {
				narr[row][col] = arr[i][j];
				row++;
			}
			col--;
		}
		return narr;
	}
	
	public static void rotateMatrixWithoutMemory(int[][] arr){
		int n =arr.length;
		for(int i=0; i<arr.length/2; i++){
			int last = arr.length-1-i;
			for(int j=i;j<last;j++){
				int temp = arr[i][j];
				arr[i][j] = arr[j][n-1-i];
				arr[j][n-1-i] = arr[n-1-i][n-1-j];
				arr[n-1-i][n-1-j] = arr[n-1-j][i];
				arr[n-1-j][i] = temp;
			}	
		}
	}

	public static void main(String[] args) {
		//int[][] arr = new int[][] { { 1, 2, 3, 4 }, {  5, 6, 7,8 }, { 9, 10, 11,12 }, {13,14,15,16} };
		int[][] arr = new int[][]{{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
		rotateMatrixWithoutMemory(arr);
		for (int[] a : arr) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

}
