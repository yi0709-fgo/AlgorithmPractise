package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlideWindow {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        findRepeatedDnaSequences(s);
        String s1 = "aaabb";
        int k = 3;


    }
    //the window is fixed
    public static List<String> findRepeatedDnaSequences(String s) {
        int left = 0;
        int right = 10;
        Map<String, Integer> counter = new HashMap<>();
        List<String> res = new ArrayList<>();
        while(right<=s.length()){
            String sub = s.substring(left, right);
            //can be improved by setting flag
            if(counter.containsKey(sub)){
                int value = counter.get(sub);
                counter.put(sub, value+1);
            }else{
                counter.put(sub, 1);
            }
            left++;
            right++;
        }
        for(Map.Entry<String, Integer> entry:counter.entrySet()){
            if(entry.getValue()>1){
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public int longestSubstring(String s, int k) {
        int left = 0;
        int right = k;
        return 0;
    }
}
