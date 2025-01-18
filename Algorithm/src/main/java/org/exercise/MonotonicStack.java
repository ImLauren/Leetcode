package org.exercise;

import java.util.Deque;
import java.util.LinkedList;

public class MonotonicStack {

    /**
     * leetcdoe739 每日温度
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i<len; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                int nearIndex = stack.pop();
                res[nearIndex] = i - nearIndex;
            }
            stack.push(i);
        }
        return res;

        // 暴力解法
//        int len = temperatures.length;
//        int[] res = new int[len];
//        for (int i=0; i<len; i++) {
//            int j=i+1;
//            while(j<len && temperatures[j]<=temperatures[i]){
//                j++;
//            }
//            if (j<len) {
//                res[i] = j-i;
//            } else {
//                res[i] = 0;
//            }
//        }
//        return res;
    }

}
