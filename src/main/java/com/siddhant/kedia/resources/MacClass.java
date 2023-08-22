package com.siddhant.kedia.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Pattern;

public class MacClass {

	public static int canBeTypedWords(String text, String brokenLetters) {
		String[] strarr = text.split(" ");
		char[] bw = brokenLetters.toCharArray();
		int count = strarr.length;
		for(String arr : strarr) {
			char[] crr = arr.toCharArray();
			boolean flag = false;
			for(Character c : crr) {
				for(Character z : bw) {
					if(c == z) {
						flag = true;
					}
				}
			}
			if(flag)
				count--;

		}
		return count < 0 ? 0 : count;
	}

	public static List<String> summaryRanges(int[] nums) {

		List<String> ans = new ArrayList<>();

		for(int i = 0; i < nums.length; i++) {
			int beg = nums[i];
			while(i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
				++i;
			}
			if(beg != nums[i]) {
				ans.add(beg + "->" + nums[i]);
			} else {
				ans.add(beg+"");
			}

		}
		return ans;

	}

	public static int findClosestNumber(int[] nums) {
		int ans = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			map.put(Math.abs(nums[i] - 0), map.getOrDefault(Math.abs(nums[i] - 0), Integer.MIN_VALUE) > nums[i] ? map.getOrDefault(Math.abs(nums[i] - 0), Integer.MIN_VALUE) : nums[i]);
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(ans > entry.getKey()) {
				ans = entry.getKey();
			}
		}

		return map.get(ans);

	}

	public static int findMinDifference(List<String> t) {
		t = new ArrayList<>();

		t.add("05:31");
		t.add("00:35");
		t.add("22:08");
		int min = Integer.MAX_VALUE;

		List<Integer> ll = new ArrayList<>();
		for(int i = 0; i < t.size(); i++) {
			String[] arr = t.get(i).split(":");
			int currSum = (Integer.parseInt(arr[1]) + (Integer.parseInt(arr[0]) * 60));
			ll.add(currSum);
		}
		Collections.sort(ll);

		for(int i = 0; i < ll.size(); i++) {
			for(int j = i + 1; j < ll.size(); j++) {
				min = Math.min(min,Math.abs(ll.get(i) + 1440 - ll.get(j)));
				min = Math.min(min,Math.abs(ll.get(j) - ll.get(i)));
			}
		}
		return min;
	}


	public static int alternateDigitSum(int n) {
		boolean flag = true;
		int ans = 0;
		int[] arr = new int[Integer.toString(n).length()];
		int i = 0;
		while(n > 0) {
			int z = n % 10;
			arr[i++] = z;
			n /= 10;
		}

		for(int j = arr.length - 1; j >= 0; j--) {
			if(flag) {
				ans += arr[j];
				flag = false;
			} else {
				ans -= arr[j];
				flag = true;
			}
		}
		return ans;
	}

	public static int[] separateDigits(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for(Integer n : nums) {
			sb.append(new StringBuilder().append(Integer.toString(n)).reverse());
		}
		int[] ans = new int[sb.length()];
		for(int i = 0; i < sb.length(); i++) {
			ans[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
		}
		return ans;
	}

	public static int countEven(int num) {
		int count = 0;
		for(int i = 2; i <= num; i++) {
			int j = i;
			int sum = 0;
			while(j > 0) {
				sum += j % 10;
				j /= 10;
			}
			System.out.println("i = " + i + " ;sum = " + sum);
			if(sum % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	public static int maxDivScore(int[] n, int[] d) {
		Arrays.sort(d);
		int prev = -1; int cur = 0;
		int[] a = new int[d.length];
		for(int i = 0; i < d.length; i++) {
			int c = 0;
			cur = d[i];
			if(cur == prev) {
				a[i] = a[i - 1];
				prev = cur;
				continue;
			}
			for(int j = 0; j < n.length; j++) {
				if(n[j] % cur == 0) {
					c++;
				}
			}
			a[i] = c;
			prev = cur;
		}
		int idx = 0; int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
				idx = i;
			}
		}
		return d[idx];
	}

	public static int pivotInteger(int n) {
		int t = ((n * ( n + 1)) / 2);

		for(int i = 1 ; i <= n; i++) {
			int c = ((i * ( i + 1)) / 2);
			if(t - c == c - i) {
				return i;
			}
		}
		return -1;
	}

	public static int minimumOperations(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for(Integer n : nums) {
			if(n != 0 && s.add(n)) {
				s.add(n);
			}
		}
		return s.size();
	}

	public static String finalString(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'i') {
				sb.reverse();
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public static String reverseOnlyLetters(String s) {
		/*
		 * 
		 * string
		 * 
		 * gtrins
		 * 
		 * gnrits
		 * 
		 * gnirts
		 */



		int i = 0; int j = s.length() - 1;
		char[] arr = s.toCharArray();
		while(j > i) {
			if(!Character.isLetter(s.charAt(i))) {
				i++;
			} else if(!Character.isAlphabetic(s.charAt(j))) {
				j--;
			} else {
				arr[i] = s.charAt(j);
				arr[j] = s.charAt(i);
				j--;
				i++;
			}
		}
		return new String(arr);
	}

	public static int vowelStrings(String[] words, int left, int right) {
		int count = 0;
		for(int i = left; i <= right; i++) {
			String s = words[i];
			Integer len = s.length() - 1;
			if((s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u') && 
					(s.charAt(len) == 'a' || s.charAt(len) == 'e' || s.charAt(len) == 'i' || s.charAt(len) == 'o' || s.charAt(len) == 'u')) {
				count++;
			}
		}
		return count;
	}

	public static int maxPower(String s) {
		int max = Integer.MIN_VALUE;
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			char prev = arr[i];
			int j = i + 1;
			int curmax = 1;
			while (j < arr.length && prev == arr [j]) {
				curmax++;
				j++;
			}
			if(curmax > max) {
				max = curmax;
			}
		}
		return max;
	}

	public static List<String> alertNames(String[] keyName, String[] keyTime) {
		Set<String> ans = new HashSet<>();
		Map<String, List<Integer>> map = new HashMap<>();
		for(int i = 0; i < keyName.length; i++) {
			List<Integer> time = null;
			if(map.get(keyName[i]) == null) {
				time = new ArrayList<>();
			} else {
				time = map.get(keyName[i]);
			}
			time.add(getTime(keyTime[i]));
			map.put(keyName[i], time);
		}

		for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> timestamps = entry.getValue();
			Collections.sort(timestamps);

			for(int i = 2; i < timestamps.size(); i++) {
				if(timestamps.get(i) - timestamps.get(i - 2) <= 60) {
					ans.add(entry.getKey());
					break;
				}
			}
		}
		List<String> anss = new ArrayList<>(ans);
		Collections.sort(anss);
		return anss;
	}



	private static Integer getTime(String time) {
		return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
	}

	public static String largestNumber(int[] nums) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(nums);

		return sb.toString();

	}

	public static int numRabbits(int[] answers) {
		Map<Integer, Integer> map = new HashMap<>();
		for(Integer ans : answers) {
			map.put(ans, map.getOrDefault(ans, 0) + 1);
		}
		Integer rabbit = 0;
		for(Integer key : map.keySet()) {
			double val = (double) map.get(key);
			key += 1;
			rabbit += (int) Math.ceil(val / (1.0 * key)) * key;
		}
		return rabbit;
	}

	public static List<String> splitWordsBySeparator(List<String> words, char separator) {
		List<String> ans = new LinkedList<>();

		for(String w : words) {
			String[] arr = w.split(Pattern.quote(Character.toString(separator)));
			for(String s : arr) {
				if(s != null && s.length() > 0) {
					ans.add(s);
				}
			}
		}
		return ans;
	}

	public static String smallestString(String s) {
		String ans = "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			while(i < s.length() && s.charAt(i) != 'a') {
				sb.append(s.charAt(i));
			}
		}



		return ans;
	}

	public static int partitionString(String s) {
		int count = 1;
		String sb = "";
		for(int i = 0; i < s.length(); i++) {
			if(sb.contains(Character.toString(s.charAt(i)))) {
				sb = "";
				count++;
			}
			sb += s.charAt(i);
		}
		return count;
	}

	private static HashMap<String, PriorityQueue<String>> map= new HashMap<>();//Starting airport -> Destination airport(lexically asc sorted)
	private static LinkedList<String> res= new LinkedList<>();//result 

	public static List<String> findItinerary(List<List<String>> tickets) {
		/*Note::
		 *->The main idea is to traverse every edge atmost once
		 *->And we are starting from JFK airport
		 *->We use Priority Queue to store the adjacent airport in Lexically sorted manner
		 *->We use a topological sort like approach for displaying the result, i.e, we start from an no in-dependency edge to the most in-dependenncy edge
		 *->We are considering the euler path to traverse the graph 
		 *->Priority Queue is also helping us keep track of the visited and non-visited edge 
		 *->Hash Map is Used like a adjacency list here 
		 */
		tickets = new ArrayList<>();
		List<String> t1 = new ArrayList<>();t1.add("muc");t1.add("lhr");
		List<String> t2 = new ArrayList<>();t2.add("jfk");t2.add("muc");
		List<String> t3 = new ArrayList<>();t3.add("sfo");t3.add("sjc");
		List<String> t4 = new ArrayList<>();t4.add("lhr");t4.add("sfo");
		tickets.add(t1);tickets.add(t2);tickets.add(t3);tickets.add(t4);

		for (List<String> ticket: tickets) {
			String u= ticket.get(0);//starting airport
			String v= ticket.get(1);//destination airport

			PriorityQueue<String> temp= map.getOrDefault(u, new PriorityQueue<>());
			temp.offer(v);//adding the desitination airport 
			map.put(u, temp);//adding to the map 
		}

		dfs("jfk");//Journey Starting Airport
		return res;
	}

	private static void dfs(String src) {
		PriorityQueue<String> pq= map.get(src);//Adjacent Airports

		while (pq != null && pq.size() > 0) {//processsing all the destination Airport of the current Airport(src)
			String temp= pq.poll();//removing the edge//visited 
			dfs(temp);//recursing down 
		}
		res.addFirst(src);//adding the Airport while backtracking//least in-dependency as far as possible 
		return;
	}

	public static String[] findWords(String[] words) {
		String r1 = "qwertyuiop";
		String r2 = "asdfghjkl";
		String r3 = "zxcvbnm";
		List<String> ans = new ArrayList<>();
		for(String g : words) {
			String s = g.toLowerCase();
			Set<String> set = new HashSet<>();
			for(int i = 0; i < s.length(); i++) {
				String c = Character.toString(s.charAt(i));
				set.add(c);
			}
			String ss = new ArrayList<>(set).get(0);

			if(r1.contains(ss)) {
				boolean flag = true;
				for(String c : set) {
					if(!r1.contains(c)) {
						flag = false;
						break;
					}
				}
				if(flag) ans.add(g);
			} else if(r2.contains(ss)) {
				boolean flag = true;
				for(String c : set) {
					if(!r2.contains(c)) {
						flag = false;
						break;
					}
				}
				if(flag) ans.add(g);
			} else if(r3.contains(ss)) {
				boolean flag = true;
				for(String c : set) {
					if(!r3.contains(c)) {
						flag = false;
						break;
					}
				}
				if(flag) ans.add(g);
			}
		}
		return ans.toArray(new String[0]);
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
		for(int i = 0; i < nums1.length; i++) {
			int a = nums1[i];
			int b = -1;
			int j = 0;
			boolean flag = false;
			while(j < nums2.length) {
				if(nums2[j] == a) {
					flag = true;
					break;
				}
				j++;
			}
			if(flag) {
				for(int k = j; k < nums2.length; k++) {
					if(nums2[k] > a) {
						b = nums2[k];
						break;
					}
				}
			}
			ans[i] = b;
		}
		return ans;
	}

	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {

		System.out.println(nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}));

		System.out.println(findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"}));

		System.out.println(findItinerary(null));

		System.out.println(partitionString("ssssss"));

		System.out.println(splitWordsBySeparator(Arrays.asList("one.two.three","four.five","six"), '.'));

		System.out.println(numRabbits(new int [] {10, 10, 10}));

		System.out.println(numRabbits(new int [] {1, 1, 2}));

		System.out.println(alertNames(new String[] {"daniel","daniel","daniel","luis","luis","luis","luis"}, new String[] {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}));

		System.out.println(maxPower("leetcode"));

		System.out.println(reverseOnlyLetters("ab-cd"));

		System.out.println(finalString("poiinter"));

		System.out.println(pivotInteger(8));

		System.out.println(maxDivScore(new int[] {4,7,9,3,9}, new int[] {5,2,3}));

		System.out.println(maxDivScore(new int[] {20,14,21,10}, new int[] {5,7,5}));

		System.out.println(maxDivScore(new int[] {4,7,9,3,9}, new int[] {10,16}));

		System.out.println(countEven(38));

		System.out.println(separateDigits(new int[] {13, 25, 83, 77}));

		System.out.println(alternateDigitSum(12));

		System.out.println(findMinDifference(null));

		System.out.println(findClosestNumber(new int[] {-4,-2,1,4,8}));

		System.out.println(findClosestNumber(new int[] {-4,-2,-4,-8}));

		System.out.println(findClosestNumber(new int[] {-2,-1,1}));


		//		System.out.println(summaryRanges(new int[] {0,1,2,4,5,7}));
		//		
		//		
		//		System.out.println(canBeTypedWords("abc de", "abc"));
		//		System.out.println(canBeTypedWords("world hello", "ad"));

	}

}
