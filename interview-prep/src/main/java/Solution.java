import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public String reverse(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		return reverse(input.substring(1)) + input.charAt(0);
	}

	public List<String> dict = null;
	public int[] primes = null;

	public Solution() throws Exception {
		List<String> list = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(new File("words.txt")));
		reader.lines().forEach(x -> {
			if (checkLetter(x)) {
				list.add(x);
			}
		});
		this.dict = list;
		int count = 0;
		int[] primes = new int[26];
		int prime = 3;
		while (count < 26) {
			if (checkPrime(prime)) {
				primes[count] = prime;
				count++;
			}
			prime = prime + 2;

		}
		this.primes = primes;
	}

	public boolean checkLetter(String s) {
		Pattern p = Pattern.compile("[a-z]*");
		Matcher m = p.matcher(s);
		return m.matches();
	}

	public Set<String> findAnagrams(String input) throws Exception {

		Set<String> set = new HashSet<String>();
		for (String str : dict) {
			Long hash = hashString(str, primes);
			Long anaHash = hashString(input, primes);
			if (hash.equals(anaHash)) {
				set.add(str);
			}

		}
		return set;

	}

	public boolean checkPrime(int prime) {
		for (int i = 2; i <= Math.sqrt(prime); i++) {
			if (prime % i == 0)
				return false;
		}
		return true;
	}

	public long hashString(String str, int[] map) {
		long b = 1;
		//System.out.println(str);
		for (char c : str.toCharArray()) {
			b = b*map[c-'a']%1000000000;
		}
		return b;
	}

	public static void main(String[] args) throws Exception {
		Solution sl = new Solution();
		long start = System.currentTimeMillis();
		System.out.println(sl.findAnagrams("information"));
		System.out.println(sl.findAnagrams("emits"));
		System.out.println(sl.findAnagrams("recanted"));
		System.out.println(sl.findAnagrams("discounter"));
		System.out.println(sl.findAnagrams("pool"));
		long end = System.currentTimeMillis();
		System.out.println("Took: " + String.valueOf((end - start)) + " milli seconds");

	}

}
