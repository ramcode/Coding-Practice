package com.interview.system.design;

import java.nio.file.DirectoryIteratorException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
 */
public class PhoneDirectoryDesign {

	private Map<String, Boolean> directory = new HashMap<>();

	public static String[] nums = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public String generateRandomTenDigitPhNo() {
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		while (sb.length() != 10) {
			int nextDigit = rand.nextInt(10);
			sb.append(nextDigit);
		}
		String phoneNum = sb.toString();
		if (!directory.containsKey(phoneNum)) {
			directory.put(phoneNum, true);
			return phoneNum;
		} else if (directory.containsKey(phoneNum) && !directory.get(phoneNum)) {
			return phoneNum;
		}
		return generateRandomTenDigitPhNo();
	}
	
	public boolean isPhoneNoActive(String phNo){
		return directory.containsKey(phNo) && directory.get(phNo);
	}
	
	public boolean deactivatePhNO(String phNo){
		if(directory.containsKey(phNo)){
			directory.put(phNo, false);
			return true;
		}
		return false;
	}
	
	public boolean reactivatePhNo(String phNo){
		if(directory.containsKey(phNo) && !directory.get(phNo)){
			directory.put(phNo, true);
			return true;
		}
		return false;
	}
	
	public boolean checkPhNoexits(String phString){
		return directory.containsKey(phString);
	}
	
	public static void main(String[] args){
		PhoneDirectoryDesign pd = new PhoneDirectoryDesign();
		for(int i=0;i<100; i++){
			pd.generateRandomTenDigitPhNo();
		}
		pd.directory.entrySet().stream().forEach(System.out::println);
	}
	
	

}
