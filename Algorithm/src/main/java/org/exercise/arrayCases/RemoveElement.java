package org.exercise.arrayCases;

import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {

    }

    /** leetcode 27 移除元素 */
    public int removeElement(int[] nums, int val) {
        if (nums.length==0) {
            return 0;
        }
        int slowIndex = 0;
        for (int fastIndex=0; fastIndex<nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /** leetcode 345 移除元素 */
    public String reverseVowels(String s) {
        List<Character> ahpleList = Arrays.asList('a','e','i', 'o', 'u','A','E','I', 'O', 'U');
        char[] charArr = s.toCharArray();

        int left = 0;
        int right  = charArr.length -1;

        while(left<right) {
            char leftChar = charArr[left];
            char rightChar = charArr[right];
            if (ahpleList.contains(leftChar) && ahpleList.contains(rightChar)) {
                charArr[left] = rightChar;
                charArr[right] = leftChar;
                left++;
                right--;
            }
            if (!ahpleList.contains(leftChar)) {
                left++;
            }
            if (!ahpleList.contains(rightChar)) {
                right--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArr) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
