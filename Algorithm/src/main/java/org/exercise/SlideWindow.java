package org.exercise;

import java.util.Arrays;
import java.util.List;

public class SlideWindow {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    /**
     * leetcdoe1456 定长子串中元音的最大数目
     */
    public static int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        int re = 0;
        for (int i = 0; i < k; i++) {
            boolean isVowel = isVowel(s.charAt(i));
            if (isVowel) {
                count++;
            }
        }

        re = count;
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            re = Math.max(re, count);
        }
        return re;

//        int re = 0;
//        int left = 0;
//        int right = left+k;
//        while (right <= s.length()) {
//            String subStr = s.substring(left, right);
//            int vowelNum = checkVowel(subStr);
//            re = Math.max(re, vowelNum);
//
//            left++;
//            right++;
//        }
//
//        return re;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int checkVowel(String str) {
        List<String> vowel = Arrays.asList("a", "e", "i", "o", "u");
        int vowelNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vowel.contains(str.substring(i, i + 1))) {
                vowelNum++;
            }
        }
        return vowelNum;
    }

    /**
     * leetcdoe1004 最大连续1的个数 III
     */
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int ans = 0;
        int count =0;
        int zero = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
            if (zero > k) {
                while (left < n - 1 && nums[left] == 1) {
                    left++;
                    count--;
                }
                left++;
                count--;
                zero--;
            }
            count++;
            ans = Math.max(ans, count);
        }
        return ans;
    }

    /**
     * leetcdoe643 子数组最大平均数 I
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum = sum + nums[i];
        }

        int i = 1;
        int j = i+k;
        int num = sum;
        while(j<nums.length) {
            num = num + nums[j] - nums[i-1];
            sum = Math.max(sum, num);
            i++;
            j++;
        }
        return (double)sum/k;
    }


}
