package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrix {

	public static List<Integer> printSpiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if(matrix.length==0) return list;
		int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
		while (true) {
			if (!checkBoundary(top, bottom, left, right))
				break;
			// print top
			for (int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			top++;
			if (!checkBoundary(top, bottom, left, right))
				break;
			// print right
			for (int i = top; i <= bottom; i++) {
				list.add(matrix[i][right]);
			}
			right--;
			if (!checkBoundary(top, bottom, left, right))
				break;
			// print bottom
			for (int i = right; i >= left; i--) {
				list.add(matrix[bottom][i]);
			}
			bottom--;
			if (!checkBoundary(top, bottom, left, right))
				break;
			// print left
			for (int i = bottom; i >= top; i--) {
				list.add(matrix[i][left]);
			}
			left++;
		}
		return list;
	}

	private static boolean checkBoundary(int top, int bottom, int left, int right) {
		return top <= bottom && left <= right;
	}
	
	public static int[][] generateSpiralMatrix(int n) {
        if(n<1) return new int[][]{};
        int[][] matrix = new int[n][n];
        int num = 1;
        int top=0, bottom = matrix.length-1, left=0, right=matrix[0].length-1;
        while(top<=bottom && left<=right){
            //single element
            if(top==bottom && left==right){
                matrix[top][left] =num;
                break;
            } 
            //fill top
            for(int i=left; i<right; i++){
                matrix[top][i] = num++;
            }
            //fill right
            for(int i=top; i<bottom; i++){
                matrix[i][right] = num++;
            }
            //fill bottom
            for(int i= right;i>left; i--){
                matrix[bottom][i] = num++;
            }
            //fill left
            for(int i= bottom; i>top; i--){
                matrix[i][left] = num++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return matrix;
    }
	public static void main(String[] args) {

		//System.out.println(printSpiralOrder(new int[][]{{6,9,7}}));
		Arrays.stream(generateSpiralMatrix(2)).forEach(x->System.out.println(Arrays.toString(x)));

	}
}
