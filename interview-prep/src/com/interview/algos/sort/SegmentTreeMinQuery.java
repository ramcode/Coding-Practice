package com.interview.algos.sort;

public class SegmentTreeMinQuery implements SegmentTreeType {

	@Override
	public int queryType(int leftChild, int rightChild) {
		// TODO Auto-generated method stub
		return Math.min(leftChild, rightChild);
	}

}
