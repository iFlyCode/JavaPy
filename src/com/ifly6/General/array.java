package com.ifly6.General;

import java.util.ArrayList;

public class array {
	
	/**
	 * Takes an ArrayList of integers, and returns an array of the same contents
	 * 
	 * @author ncolaprete
	 * 
	 * @param inList
	 *            - ArrayList to transform
	 * @return formed array
	 */
	public static int[] ArrayListToArray(ArrayList<Integer> inList) {
		int[] to_sender = new int[inList.size()];
		for (int i=0;i<inList.size();i++) {
			to_sender[i] = inList.get(i);
		}
		return to_sender;
	}
}
