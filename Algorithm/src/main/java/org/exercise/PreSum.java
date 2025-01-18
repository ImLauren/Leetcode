package org.exercise;

public class PreSum {

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,1,1,1};
        System.out.println(pivotIndex(nums));
    }


    /**
     * leetcdoe724 寻找数组的中心下标
     */
    public static int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;

        for (int i=0; i<nums.length; i++) {
            preSum[i+1] = nums[i] + preSum[i];
        }

        for (int i=0; i<preSum.length-1; i++) {
            if (preSum[i] == preSum[preSum.length-1]-preSum[i+1] && i<nums.length) {
                return i;
            }
        }
        return  -1;
    }


    /**
     * leetcdoe1732 找到最高海拔
     */
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int ans = 0;
        for (int n : gain) {
            sum = sum + n;
            ans = Math.max(ans, sum);
        }
        return ans;
    }


}
