import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.interview.ds.trees.TreeNode;

public class Snippet {
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public static void backtrack(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		System.out.println(generateTrees(4));
	}

	public static int getNum(List<Integer> list) {
		int pow = list.size() - 1;
		int num = 0;
		for (int digit : list) {
			num += digit * Math.pow(10, pow);
			pow = pow - 1;
		}
		return num;
	}

	public static List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}

		return helper(1, n);
	}

	public static List<TreeNode> helper(int m, int n) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (m > n) {
			result.add(null);
			return result;
		}

		for (int i = m; i <= n; i++) {
			List<TreeNode> ls = helper(m, i - 1);
			List<TreeNode> rs = helper(i + 1, n);
			for (TreeNode l : ls) {
				for (TreeNode r : rs) {
					TreeNode curr = new TreeNode(i);
					curr.left = l;
					curr.right = r;
					result.add(curr);
				}
			}
		}

		return result;
	}
	
}