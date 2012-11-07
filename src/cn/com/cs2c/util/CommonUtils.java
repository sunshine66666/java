package cn.com.cs2c.util;

public class CommonUtils {
	
    public static void printArray(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
		    System.out.print(array[i] + " , ");
		}
		System.out.print(array[array.length - 1] + "\n");
    }
}
