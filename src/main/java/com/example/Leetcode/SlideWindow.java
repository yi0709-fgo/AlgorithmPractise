package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlideWindow {
    public static void main(String[] args) {
//        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        findRepeatedDnaSequences(s);
        String s1 = "aaabbb";
        int k = 3;
        System.out.println(longestSubstring1(s1,k));

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

    //two pointer
    public static int longestSubstring(String s, int k) {
        int n = s.length();
        int res = Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            for(int j=i+1; j<=n; j++){
                String sub = s.substring(i,j);
                if(isValid(sub,k)){
                    res = Math.max(res, j-i);
                }
            }
        }

        return res;
    }
    public static boolean isValid(String s, int n){
        boolean flag = true;
        int[] freq = new int[26];
        for(char i: s.toCharArray()){
            freq[i-'a']++;
        }
        for(char i: s.toCharArray()){
            if(freq[i-'a']<n){
                flag = false;
                break;
            }
        }
        return flag;
    }

    //divide and conqure
//    Time complexity: O(nlogn)
//    O(n) as we are iterating over the whole string
//    O(logn) is the number of levels in recursion tree as we are dividing the string whenever needed
//    Space complexity: O(n)
//    O(n) for recursion stack space
//    O(1) for frequency array(independent of input size)
    public static int longestSubstring1(String s, int k) {
        int[] freq = new int[26];
        int res = 0;
        for(char i: s.toCharArray()){
            freq[i-'a']++;
        }
        boolean flag = true;
        for(char i: s.toCharArray()){
            if(freq[i-'a']<k){flag = false; break;}
        }
        if(flag){return s.length();}

        int current = 0;

        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i)-'a']<k){
                String subString = s.substring(current, i);
                res = Math.max(res,longestSubstring1(subString,k));
                current = i+1;
            }
        }
        String subString = s.substring(current);
        res = Math.max(res,longestSubstring1(subString,k));
        return res;
    }

}
