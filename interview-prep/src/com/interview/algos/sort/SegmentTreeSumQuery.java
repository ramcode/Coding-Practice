package com.interview.algos.sort;

public class SegmentTreeSumQuery implements SegmentTreeType {
	@Override
	public int queryType(int leftChild, int rightChild){
		return leftChild+rightChild;
	}

}
