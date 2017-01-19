package com.interview.algos.bitmanipulation;

public class BitManipulation {

	public static boolean isPowerOfTwo(int input){
		return input!=0 && ((input & (input-1))==0);
	}
	//get next higher int with same no of 1 bits
	public static int getNextInt(int n){
		int c = n;
		int i0 = 0;
		int i1 = 0;
		while((c&1)==0 && c!=0){
			i0++;
			c>>=1;
		}
		while((c&1)==1){
			i1++;
			c>>=1;
		}
		int i=i0+i1;
		if(i==31 || i==0){
			throw new IllegalArgumentException("No higher number can't be found");
		}
		n = n|1<<i;
		n= n&(~((1<<i) -1));
		n = ((1<<(i1-1))-1)|n;
		return n;
	}
	
	public static int getIndexOfSetBit(int input){
		int i=0;
		while((input & 1) == 0 && input!=0){
			i++;
			input >>= 1;
		}
		return i;
	}
	
	public static int getIndexOfOffBit(int input){
		int i=-1;
		while((input&1) == 1){
			i++;
			input >>=1;
		}
		if(i!=-1)
			return i+1;
		return i;
	}
	
	public static int calculateIntFromBits(String bitSequence){
		int bitLength = bitSequence.length();
		int sum = 0;
		for(int i=bitLength-1; i>=0; i--){
			int index = (bitLength-1) - i;
			sum = sum+(Integer.parseInt(String.valueOf(bitSequence.charAt(i)))*((int)Math.pow((double)2, (double)index)));
		}
		return sum;
	}
	
	public static int updateBit(int i, int index, int value){
		//System.out.println("i->"+i);
		int mask = 1 << index;
		//System.out.println("mask->"+Integer.toBinaryString(mask));
		//System.out.println("~mask->"+Integer.toBinaryString(~mask));
		int j = i & ~(mask);
		//System.out.println("j->"+Integer.toBinaryString(j));
		return j | (value << index);
	}
	
	public static int insertBitString(int m, int n, int i, int j){
		if(m>n || i>j || Integer.toBinaryString(m).length()!=(j-i+1)){
			throw new IllegalArgumentException("Invalid Input");
		}
		String bitString = Integer.toBinaryString(m);
		int index = bitString.length()-1;
		int updatedValue = n;
		while(i<=j){
			updatedValue = updateBit(updatedValue, i, Character.getNumericValue((bitString.charAt(index))));
			index--;
			i++;
		}
		return updatedValue;
		
	}
	
	public static String convertDoubleToBits(double d){
		StringBuffer sb  = new StringBuffer();
		sb.append("0.");
		while(d>0){
			if(2*d>=1){
				sb.append("1");
				d = 2*d-1;
			}
			else {
				sb.append("0");
				d = 2*d;
			}
		}
		return sb.toString();
	}
	
	public static int insertBitStringOneLine(int m, int n, int i, int j){
		return (n & ((~0 << j+1) | (1 << i-1))) | (m << i);
	}
	public static void main(String args[]){
		//System.out.println(Integer.toBinaryString(Integer.MAX_VALUE);
		//System.out.println(calculateIntFromBits("1111111111111111111111111111111"));
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);
		//System.out.println("10000000000"+" bit at " + 2+ " updated to 1 ->"+Integer.toBinaryString(updateBit(calculateIntFromBits("10000000000"), 2, 1)));
		//System.out.println("N:10000000000"+" M:10011"+" i:2"+" j:6"+" updated value:"+Integer.toBinaryString(insertBitString(calculateIntFromBits("10011"), calculateIntFromBits("10000000000"), 2, 6)));
		//System.out.println(Integer.toBinaryString(insertBitStringOneLine(calculateIntFromBits("10011"), calculateIntFromBits("10000000000"), 2, 6)));
		//System.out.println(convertDoubleToBits(0.00001));
		System.out.println(Integer.toBinaryString(getNextInt(100)));
		
	}
}
