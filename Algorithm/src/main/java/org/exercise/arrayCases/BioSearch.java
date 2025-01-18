package org.exercise.arrayCases;

public class BioSearch {

    public static void main(String[] args) {

    }

    /**
     * leetcdoe704 二分查找
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid]<target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    /** leetcode 35 搜索插入位置 */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while( left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /** leetcode 34 在排序数组中查找元素的第一个和最后一个位置 */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) {
            return new int[]{-1,-1};
        }
        int rightResult = -1;
        int leftResult = -1;

        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        rightResult = left-1;

        left = 0;
        right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        leftResult = right+1;

        return leftResult<=rightResult && leftResult!=-1 &&rightResult !=-1 ?
                new int[] {leftResult, rightResult} : new int[]{-1,-1};
    }

}
