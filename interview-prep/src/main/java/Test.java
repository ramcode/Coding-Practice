import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import com.interview.ds.linkedlist.Node;

public class Test {

	public static void main(String[] args){/*
	
	int a = 0
	
		Node l1 = new Node(1);
		Node l2 = new Node(1);
		
		  List<List<Integer>> list = new ArrayList<>();
		  
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while(l1!=null || l2!=null){
            if(l1 !=null) stack1.push(l1.val);
            if(l2!=null) stack2.push(l2.val);
            l1 != null ? l1 = l1.next : l1;
            l21=null ? l2 = l2.next : l2;
            
        }
		//System.out.println(""+2);
		String[] s = new String[]{"zen", "car", "apple", "banna", "dog","cat"};
		Arrays.sort(s);
		System.out.println();
		Random rand = new Random();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.re
		map.getOrDefault(1, null).
		map.values().toArray(new Integer[map.size()]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		pq.re
		Deque<String> stack = new ArrayDeque<>();
		StringBuffer sb = new StringBuffer();
		sb+"("
		System.currentTimeMillis();
		pq.stream().limit(10).collect(Collectors.toList());
		Long l = new Long(11111);
		Set<Integer> set = new HashSet<Integer>();
		
		set.stream().limit(10).map(x->x.intValue()).collect(Collectors.toList());
		Character c = ' ';
		System.out.println(Character.toLowerCase('A'));
		System.out.println(Character.isLetterOrDigit(c));
		int[][] test = new int[0][0];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<Integer>(Arrays.asList(test[0][0])));
		//new ArrayList<Collections.>
		
	
	*/
		
		Float a = new Float(1.0);
		double b = a.doubleValue();
		byte c = a.byteValue();
		int d = a.intValue();
		
		System.out.println(d+c+b);
		class newTest{
			 newTest(){
				System.out.println("inner");
			}
		}
		
		/*System.out.println(Math.abs("Venkata".hashCode())%5);
		System.out.println(Math.abs("ramesh".hashCode())%5);
		List<List<Integer>> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		Map<String, String> map = null;
		String s = "";
		//char c = 'A';
		//Character.getNumericValue(c);
		Random rand = new Random();
		//String a= "";
		//String b = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
		System.out.println(Arrays.binarySearch(new int[]{0,0,0,0}, 0, 0, 3));
		char[] arr = b.toCharArray();
        for(int i=0; i<arr.length; i++){
            for(char z = 'a'; c<='z';c++){
                
            }
        }
        int test = true?5:7;
		for(String str: b.split(":")){
		System.out.println(str);
		}*/
	}

	

    public String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i=0; i<numRows;i++){
            sb[i] = new StringBuffer();
        }
        int len = s.length(); 
        int i = 0;
       while(i<len){
           for(int j=0; j<numRows && i<len; j++){
               sb[j].append(s.charAt(i++));
           }
           for(int k=numRows-2; k>=1 && i<len; k++){
               sb[k].append(s.charAt(i++));
           }
       }
       for(i=1;i<numRows; i++){
           sb[0].append(sb[i]);
       }
       return sb[0].toString();   
       
       
    }
    
    

	
	
	
}
