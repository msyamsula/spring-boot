package com.playground;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class playground {

	public static void main(String[] args) {
		Vector<Integer> arr = new Vector<>();
		
		arr.add(2);
		
		System.out.println(arr.size());
		
		for(Integer i=0; i<10; i++) {
			arr.add(i);
		}
		
		System.out.println(arr.get(2));
		System.out.println(arr.size());
		System.out.println(arr.toString());
		
		Set<Integer> s = new HashSet<>();
		
		s.add(10);
		s.add(11);
		s.add(5);
		System.out.println(s.size());
		s.add(8);
		System.out.println(s.size());
		System.out.println(s.toString());
		System.out.println(s.contains(12));
		System.out.println(s.contains(8));
		
		Map<Character, Integer> m = new HashMap<>();
		
		m.put('a', 1);
		m.put('b', 2);
		m.put('b', 3);
		
		System.out.println(m);
		System.out.println(m.size());
		for(Map.Entry<Character, Integer> p : m.entrySet()) {
			System.out.println(p.getKey().toString() + ' ' + p.getValue()); 
		}
	}

}
