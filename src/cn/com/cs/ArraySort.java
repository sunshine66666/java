package cn.com.cs;

import cn.com.cs2c.util.CommonUtils;

public class ArraySort {

    /**
     * 冒泡排序
     * 
     * @param array
     * @return
     */
    public void bubbleSort(int[] array) {
		for(int i = array.length-1; i > 0; i--) {
		    for(int j = 0; j < i; j++) {
				if(array[j]>array[j+1]) {
//				   int tmp=array[j];
//				   array[j]=array[j+1]; 
//				   array[j+1]=tmp; 
					array[j] = array[j] + array[j+1];
					array[j+1] =array[j]-array[j+1];
					array[j] = array[j]- array[j+1];
					
				}
		    } 
		}
    }
    
    /**
     * 选择排序
     * 
     * @param array
     * @return
     */
    public void selectSort(int[] array) {
    	int min;
    	for (int i = 0; i < array.length - 1; i ++) {
    		min = i;
    		for (int j = i + 1; j < array.length; j ++) {
    			if (array[j] < array[min]) {
    				min = j;
    			}
    		}
    		if (min != i) {
			   int tmp=array[min];
			   array[min]=array[i]; 
			   array[i]=tmp; 
    		}
    	}
    }
    
    /**
     * 插入排序
     * 场景：数组基本有序，效率高
     * 思想：从第一个无序的数据开始向后扫描，记录该位置和值，向前查找比该值小的数，比它大的向后移动。
     *      循环完成后将空出的位置（比它小的数后面）插入该数据。
     * @param array
     * @return
     */
    public void insertSort(int[] array) {
    	for (int i = 1; i < array.length; i++) {
    		int temp = array[i];
    		int index = i;
    		while (index > 0 && array[index - 1] > temp) {
    			array[index] = array[index - 1];
    			index --;
    		}
    		array[index] = temp;
    	} 
    }
    
    /**
     * 快速排序
     * 思想：分治+递归。将一个排序问题转为两个排序问题。
     * 
     * @param array
     * @param low
     * @param high
     */
    public void quickSort(int[] array, int low, int high) {
    	if(low > high) {
    		return ;
    	}
    	int index = array[low];  //设置key进行划分
    	int i = low;
        int j = high;
        while (i < j) {
        	 while (i < j && index < array[j]) {  //判断右边元素,向左查找比index小的数下标，存入i位置上。
                 j --;
             }
        	 array[i] = array[j];
        	 while (i < j && index > array[i]) {  //判断左边元素，向右查找比index大的数下标，存入j位置上。
                 i ++;
             }
        	 array[j]=array[i];
        }
        array[i]=index; // 将key值放入i位置上。此时，三个数的位置是从小到大排序的，且，中间数之前的数都小于之间数之后的数。将大问题变成两个小问题，正好使用分治递归实现。
        quickSort(array, low, i-1);  //进行递归
        quickSort(array, i+1, high); //进行递归
    }
    
    public static void main(String[] args) {
		int[] array = {1, 3, 4, 5, 2, 8, 7, 9, 6, 0};
		ArraySort j1 = new ArraySort();
		
		System.out.println("排序前的数组： ");
		CommonUtils.printArray(array);
//		j1.arraySort(array);
//		j1.selectSort(array);
//		j1.insertSort(array);
		j1.quickSort(array, 0, array.length - 1);
		System.out.println("排序后的数组： " );
		CommonUtils.printArray(array);
    }

}
