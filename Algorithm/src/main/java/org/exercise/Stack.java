package org.exercise;

import java.util.Deque;
import java.util.LinkedList;

public class Stack {


    /**
     * leetcdoe2390 从字符串中移除星号
     */
    public String removeStars(String s) {
        char[] chars = s.toCharArray();

        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if (c=='*') {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.removeFirst());
        }
        return res.toString();
    }

}
