package org.exercise.dynamicProgramming;

public class DPOneDimensional {

    /**
     * leetcdoe198 打家劫舍
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len==0) {
            return 0;
        }
        if (len==1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }

    public int robMoney(int[] nums, int n) {
        if(n==0) {
            return nums[0];
        }
        if (n==1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robMoney(nums, n-1), robMoney(nums, n-2)+nums[n]);
    }

    /**
     * leetcdoe746 使用最小花费爬楼梯
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len==1) {
            return cost[0];
        }
        if (len==2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2; i<=len; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[len];
    }

}
