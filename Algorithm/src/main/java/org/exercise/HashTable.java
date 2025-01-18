package org.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HashTable {

    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "aabbss"));
    }

    /**
     * leetcdoe1657 确定两个字符穿是否接近
     */
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i=0; i<word1.length(); i++) {
            char c = word1.charAt(i);
            map1.put(c, map1.containsKey(c) ? map1.get(c)+1 : 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<word2.length(); i++) {
            char c = word2.charAt(i);
            map2.put(c, map2.containsKey(c) ? map2.get(c)+1 : 1);
        }

        for(Character oneChar : map1.keySet()) {
            if (!map2.containsKey(oneChar)) {
                return false;
            }
        }

        List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());

        for (int i=0; i<list1.size(); i++) {
            if (!Objects.equals(list2.get(i), list1.get(i))) {
                return false;
            }
        }

        return true;
    }

}
