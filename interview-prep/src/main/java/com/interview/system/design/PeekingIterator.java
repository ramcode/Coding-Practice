package com.interview.system.design;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    public Integer[] list = null;
    public Integer cursor = -1;
    public int size = 0;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.list = new Integer[100];
	    for(int i=1; i<=100; i++){
	        list[i-1] = i;
	    }
	    this.size = list.length;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    
	    if(hasNext()){
	        return list[cursor+1];
	    }
	    else{
	        return -1;
	    }
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasNext()){
	        cursor++;
	        return list[cursor];
	    }
	    else{
	        return -1;
	    }
	}

	@Override
	public boolean hasNext() {
	    return cursor<(size-1);
	}
}