package com.interview.algos.sort;

public class SegmentTreeMaxQuery implements SegmentTreeType {

	@Override
	public int queryType(int leftChild, int rightChild) {
		// TODO Auto-generated method stub
		return Math.max(leftChild, rightChild);
	}

}
