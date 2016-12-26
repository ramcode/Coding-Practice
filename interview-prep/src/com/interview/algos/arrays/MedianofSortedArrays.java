package com.interview.algos.arrays;

import java.util.Arrays;

public class MedianofSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0)
			return 0;
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n2 > n1)
			return findMedianSortedArrays(nums2, nums1);
		if (n2 == 0)
			return nums1[(n1 - 1) / 2] + nums1[n1 / 2] / 2.0;
		int low = 0;
		int high = 2 * n2;
		while (low <= high) {
			int mid2 = (low + high) / 2;
			int mid1 = n1 + n2 - mid2;
			double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
			double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			double r1 = mid1 == 2 * n1 ? Integer.MAX_VALUE : nums1[mid1 / 2];
			double r2 = mid2 == 2 * n2 ? Integer.MAX_VALUE : nums2[mid2 / 2];
			if (l1 > r2)
				low = mid2 + 1;
			else if (l2 > r1)
				high = mid2 - 1;
			else
				return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
		}
		return -1;

	}
	
	public static void main(String[] args){
		int[] nums1 = new int[] {1,2};
		int[] nums2 = new int[] {3};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianArray(int[] nums) {
		if (nums.length % 2 == 0) {
			return nums[nums.length / 2 - 1] + nums[nums.length / 2] / 2.0;
		} else {
			return nums[nums.length / 2];
		}
	}

	public double findMedianArrays(int[] nums1, int[] nums2, int m, int n) {

		if (m == 1 && n % 2 != 0) {
			int medn = nums2[n / 2];
			int medn1 = nums2[n / 2 - 1];
			int medn2 = nums2[n / 2 + 1];
			return med3(nums1[0], medn1, medn2) + medn / 2.0;
		} else if (m == 1 && n % 2 == 0) {
			int medn = nums2[n / 2];
			int medn1 = nums2[n / 2 - 1];
			return med3(nums1[0], medn, medn1);
		} else if (m == 2 && n % 2 != 0) {
			int medn = nums2[n / 2];
			int medn1 = nums2[n / 2 - 1];
			int medn2 = nums2[n / 2 + 1];
			return med3(medn, Math.max(nums1[0], medn1), Math.min(nums1[1], medn2));
		} else if (m == 2 && n % 2 == 0) {
			int medn = nums2[n / 2];
			int medn1 = nums2[n / 2 - 1];
			int medn2 = nums2[n / 2 + 1];
			return med4(medn, medn1, Math.max(nums1[0], nums2[n / 2 - 2]), Math.min(nums1[1], medn2));
		} else if (m == 2 && n == 2)
			return med4(nums1[0], nums1[1], nums2[0], nums2[1]);
		else{
			int idx1 = m-1/2;
			int idx2 = n-1/2;
			if(nums1[idx1]<=nums2[idx2]){
				//findMedianArrays(nums1, nums2, )
			}
		}
		return -1;
	}

	public int med3(int a, int b, int c) {
		int maxab = Math.max(a, b);
		if (c > maxab) {
			return maxab;
		} else {
			return Math.max(Math.max(a, c), Math.max(b, c));
		}
	}

	public double med4(int a, int b, int c, int d) {
		int[] arr = new int[] { a, b, c, d };
		Arrays.sort(arr);
		return arr[1] + arr[2] / 2.0;
	}
}