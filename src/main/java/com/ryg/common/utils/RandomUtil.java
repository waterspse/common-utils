package com.ryg.common.utils;

import java.util.Random;

public class RandomUtil {

	
	public static int random(int min,int max) {
		Random random =  new Random();
		int nextInt = random.nextInt(max-min+1);
		if(nextInt<min) {
			return random(min,max);
		}
		return nextInt;
	}
	
	public static int[] random(int min,int max,int num) {
		int []intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min,max);
		}
		return intArray;
	}
	
	public static void main(String[] args) {
		
	}
}
