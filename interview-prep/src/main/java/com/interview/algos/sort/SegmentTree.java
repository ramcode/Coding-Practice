package com.interview.algos.sort;

/*
 * @Author: tvramesh
 * @Date: 06/17/2016
 * @DataStructure: Segment Tree
 * ----------------------------------------------------------------------------------------------------
 * A Segment tree is a Full Binary Tree where each node stores the value of a range query. 
 * Leaf nodes contain the original array values and all the internal nodes store the range values.
 * Each child stores half the range value. i.e if a node stores the range value [i,j]
 * Left node-> Range Value [i,mid] (calculated from parent index as 2i+1)
 * Right node -> Range Value [mid+1, j] ((calculated from parent index as 2i+2)
 * Root Stores entire range [0,len-1]
 * -----------------------------------------------------------------------------------------------------
 * Time and Space Complexities
 * 1. Space Complexity for building Segment tree - O(n)
 * 2. 
 */
public class SegmentTree {

	public int[] constructSegmentTree(int[] array, SegmentTreeType treeType) {
		int length = array.length;
		int height = (int) Math.ceil(Math.log(length) / Math.log(2));
		int segmentTreeSize = 2 * length - 1;
		int[] segmentTree = new int[segmentTreeSize];
		constructSegmentTree(0, 0, length - 1, segmentTree, array, treeType);
		return segmentTree;
	}

	public void constructSegmentTree(int segmentTreeIndex, int startIndex, int endIndex, int[] segmentTree, int[] array,
			SegmentTreeType treeType) {
		if (startIndex == endIndex) {
			segmentTree[segmentTreeIndex] = array[startIndex];
			return;
		}
		int mid = (int) Math.floor((startIndex + endIndex) / 2);
		int leftChildIndex = 2 * segmentTreeIndex + 1;
		int rightChildIndex = 2 * segmentTreeIndex + 2;
		constructSegmentTree(leftChildIndex, startIndex, mid, segmentTree, array, treeType);
		constructSegmentTree(rightChildIndex, mid + 1, endIndex, segmentTree, array, treeType);
		segmentTree[segmentTreeIndex] = treeType.queryType(segmentTree[leftChildIndex], segmentTree[rightChildIndex]);
	}

	public int rangeQuery(int lowIndex, int highIndex, int[] array, SegmentTreeType treeType) {
		if (lowIndex < highIndex && lowIndex > -1 && highIndex < array.length) {
			int[] segmentTree = constructSegmentTree(array, treeType);
			return rangeQuery(lowIndex, highIndex, 0, array.length - 1, segmentTree, 0, treeType);
		} else {
			throw new IllegalArgumentException("Given Indices are Invalid!");
		}
	}

	public int rangeQuery(int lowIndex, int highIndex, int startIndex, int endIndex, int[] segmentTree,
			int segmentTreeIndex, SegmentTreeType treeType) {
		if (startIndex >= lowIndex && endIndex <= highIndex) {
			return segmentTree[segmentTreeIndex];
		}
		if (lowIndex > endIndex || highIndex < startIndex) {
			if (treeType instanceof SegmentTreeMinQuery)
				return Integer.MAX_VALUE;
			else if (treeType instanceof SegmentTreeMaxQuery)
				return Integer.MIN_VALUE;
			else
				return 0;
		}
		int mid = (startIndex + endIndex) / 2;
		int leftChildIndex = 2 * segmentTreeIndex + 1;
		int rightChildIndex = 2 * segmentTreeIndex + 2;
		int leftChildValue = rangeQuery(lowIndex, highIndex, startIndex, mid, segmentTree, leftChildIndex, treeType);
		int rightChildValue = rangeQuery(lowIndex, highIndex, mid + 1, endIndex, segmentTree, rightChildIndex,
				treeType);
		return treeType.queryType(leftChildValue, rightChildValue);
	}

	public static void main(String arg[]) {
		SegmentTree sgTree = new SegmentTree();
		SegmentTreeType sumQuery = new SegmentTreeSumQuery();
		SegmentTreeType minQuery = new SegmentTreeMinQuery();
		SegmentTreeType maxQuery = new SegmentTreeMaxQuery();
		int[] array = new int[] { 2, 8, 1, 5, -4, 11, 0 };
		// constructing range sum segment tree type
		for (int a : sgTree.constructSegmentTree(array, sumQuery)) {
			System.out.println(a);
		}
		System.out.println("Range Sum: " + sgTree.rangeQuery(1, 6, array, sumQuery));
		// constructing range minimum segment tree type
		for (int a : sgTree.constructSegmentTree(array, minQuery)) {
			System.out.println(a);
		}
		System.out.println("Range Minimum: " + sgTree.rangeQuery(1, 6, array, minQuery));
		// constructing range maximum segment tree type
		for (int a : sgTree.constructSegmentTree(array, maxQuery)) {
			System.out.println(a);
		}
		System.out.println("Range Maximum: " + sgTree.rangeQuery(1, 6, array, maxQuery));
	}
}
