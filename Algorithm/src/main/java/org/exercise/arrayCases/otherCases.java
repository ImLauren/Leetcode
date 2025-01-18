package org.exercise.arrayCases;

import java.util.*;

public class otherCases {
    public static void main(String[] args) {
        String s = "aabbccc";
        int re = compress(s.toCharArray());

    }

    /** leetcode1 两数之和 */
    public int[] twoSum(int[] nums, int target) {
        // 滑动窗口
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int numOne = nums[i];
                int numTwo = nums[j];
                if (numOne+numTwo == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 哈希表
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (numMap.containsKey(target-nums[i])) {
                return new int[]{numMap.get(target-nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[2];

    }

    /** leetcode1768 交替合并字符串 */
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1==0) {
            return word2;
        }
        if (len2==0) {
            return word1;
        }

        int i=0, j=0;
        StringBuilder result = new StringBuilder();
        while(i<len1 || j<len2) {
            if (i<len1) {
                result.append(word1.charAt(i));
                i++;
            }
            if (j<len2) {
                result.append(word2.charAt(j));
                j++;
            }
        }
        return result.toString();
    }

    /** leetcode151 反转字符串中的单词 */
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> sArr = Arrays.asList(s.split("\\s+"));
        StringBuilder result = new StringBuilder();
        Collections.reverse(sArr);
        return String.join(" ", sArr);
    }

    /** leetcode238 除自身以外数组的乘积 */
    public int[] productExceptSelf(int[] nums) {
        int[] preMulti = new int[nums.length];
        preMulti[0] = 1;
        for (int i=1; i<nums.length; i++) {
            preMulti[i] = preMulti[i-1] * nums[i-1];
        }
        int[] lastMulti = new int[nums.length];
        lastMulti[nums.length-1] = 1;
        for (int i=nums.length-2; i>=0; i--) {
            lastMulti[i] = lastMulti[i+1] * nums[i+1];
        }
        int[] result = new int[nums.length];
        for (int i=0; i< nums.length; i++) {
            result[i] = preMulti[i] * lastMulti[i];
        }
        return result;
    }

    /** leetcode1071 字符串的最大公因子 */
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i=Math.max(len1, len2); i>0; i--) {
            if (len1%i==0 && len2%i==0) {
                String str = str1.substring(0,i);
                if (check(str, str1) && check(str, str2)) {
                    return str;
                }
            }
        }
        return "";
    }

    public boolean check(String t, String s) {
        int len = s.length() / t.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=1; i<=len; i++) {
             stringBuilder.append(t);
        }
        return stringBuilder.toString().equals(s);
    }

    /** leetcode334 递增的三元子序列 */
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len<3) {
            return false;
        }

        // 双向遍历
//        int[] leftMin = new int[len];
//        leftMin[0] = nums[0];
//        for (int i=1; i<len; i++) {
//            leftMin[i] = Math.min(leftMin[i-1], nums[i]);
//        }
//
//        int[] rightMax = new int[len];
//        rightMax[len-1] = nums[len-1];
//        for (int i=len-2; i>0; i--) {
//            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
//        }
//
//        for (int i=1; i<len-1; i++) {
//            if (leftMin[i-1]<nums[i] && nums[i] < rightMax[i+1]) {
//                return true;
//            }
//        }
//        return false;

        // 贪心
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            if (num>second) {
                return true;
            } else if (num>first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }


    /** leetcode443 压缩字符串 */
    public static int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        int num = 1;
        for (int i=0; i<chars.length; i++) {
            if (i==chars.length-1) {
                s.append(chars[i]);
                if(num>1) {
                    s.append(num);
                }
                break;
            }

             if (chars[i] == chars[i+1]) {
                 num++;
             } else {
                 s.append(chars[i]);
                 if (num>1) {
                     s.append(num);
                 }
                 num=1;
             }
        }

        for (int i=0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }

    /** leetcode374 猜数字大小 */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while(true) {
            int mid = left + (right - left) / 2;
            int guessNum = guess(mid);
            if (guessNum==-1) {
                right=mid;
            } else if (guessNum==1) {
                left=mid+1;
            } else if (guessNum==0) {
                return mid;
            }
        }

    }

    int guess(int num) {
        return -1;
    }


}



