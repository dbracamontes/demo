package com.dbracamo.challenges.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class Duplicate {

	static int solution(int[] a) {
		HashSet<Integer> duplicatesMap = new HashSet<>();
		int firstDuplicated = -1;

		for (int i = 0; i < a.length; i++) {
			boolean isDuplicated = duplicatesMap.contains(a[i]);
			if (isDuplicated) {
				firstDuplicated = a[i];
				return firstDuplicated;
			} else {
				duplicatesMap.add(a[i]);
			}
		}
		return firstDuplicated;
	}
	
	public static void main(String[] args) {
		solution(new int[]{2,2});
	}
	
	String[][] solution(String[][] dishes) {
	    TreeMap<String, List<String>> dishesMap = new TreeMap<>();
	    
	    for(int i=0; i < dishes.length; i++){
	        for(int j = 0; j < dishes[i].length; j++){
	            String[] jS = dishes[0];

	        }
	    }
	}
}
