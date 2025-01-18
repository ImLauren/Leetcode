package org.exercise.twoPointor;

public class twoPointor {

    public static void main(String[] args) {

    }

    /** leetcdoe283 移动零 */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast<nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow< nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    /** leetcdoe11 盛最多水的容器 */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while(left<right) {
            int area = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, area);
            if (height[left]<height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
