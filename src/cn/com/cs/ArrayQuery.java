package cn.com.cs;

public class ArrayQuery<T extends Comparable<T>> {
	private T[] data;
	public ArrayQuery(T[] data) {
		this.data = data;
	}
	
	/**
	 * 二分查找。数组已完成排序。
	 * 
	 * @param key
	 * @return
	 */
	public int binarySearch(T key) {
		int low;
		int high;
		int mid;
		if (null == data) return -1;
		low = 0;
		high = data.length - 1;
		while (low < high) {
			mid = (low + high)/2;
			System.out.println("the mid data is " + data[mid]);
			if (key.compareTo(data[mid]) < 0) high = mid-1;
			else if (key.compareTo(data[mid]) > 0) low = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = {1, 4, 5, 8, 15, 33, 48, 77, 96};
		ArrayQuery<Integer> aq = new ArrayQuery<Integer>(data);
		int mid = aq.binarySearch(77);
		System.out.println("mid = " + mid + ", data[mid] = " + data[mid]);
	}

}
