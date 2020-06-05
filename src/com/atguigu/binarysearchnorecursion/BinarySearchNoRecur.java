package com.atguigu.binarysearchnorecursion;

/**
 * Created by ChengQian on 2020/6/4 12:41
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int i = binarySearch(arr, 8);
        System.out.println("index=" + i);
    }
    //二分查找非递归
    /**
     * arr[mid] > target 中间值比要查找的值大  左边
     * @param arr 要查找的数组
     * @param target 需要查找的数字
     * @return 返回对应下标 -1表示没有找到
     */
    public static int binarySearch(int[] arr,int target) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {//继续查找
            int mid = (left + right) / 2;//计算出中间值
            if (arr[mid] == target) {
                return mid;//说明找到返回
            } else if (arr[mid] > target) {//中间值 大于 要查找的值
                right = mid -1; //往左边找
            } else {
                left = mid + 1; //往右边走
            }
        }
        return -1;
    }

}