package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeIntervals {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> res = new ArrayList<>();
		if (intervals.size() == 0 && newInterval == null)
			return res;
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i++));
		}
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			Interval merged = new Interval(Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			newInterval = merged;
			i++;
		}
		res.add(newInterval);
		while (i < intervals.size()) {
			res.add(intervals.get(i));
		}
		return res;
	}

	public boolean isOverlap(Interval a, Interval b) {
		return (b.start >= a.start && b.start <= a.end) || (a.start >= b.start && a.start <= b.end);
	}

	public static void main(String[] args) {
		Interval a = new Interval(1, 2);
		Interval b = new Interval(3, 5);
		Interval c = new Interval(6, 7);
		Interval d = new Interval(8, 10);
		Interval e = new Interval(12, 16);
		List<Interval> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);

		MergeIntervals merge = new MergeIntervals();
		merge.insert(list, new Interval(4, 9));

	}

}
