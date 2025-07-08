package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations  {
    public static void main(String[] args) {

        System.out.println("answer "+combine(4,3));

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(1,path,n,k,res);
        return res;
    }

    public static void backTrack(int cur, List<Integer> path, int n, int k, List<List<Integer>> res ){
        System.out.println("this turn is " +path);
        if(path.size()==k) {
            res.add(new ArrayList<>(path));
            return;
        }
//        if(cur<=n){
            for(int i = cur; i<=n;i++){
                System.out.println(" turn" +i);
                path.add(i);
                backTrack(i+1, path,n,k,res);
                System.out.println("time to remove " );
                path.removeLast();
                System.out.println("after remove " +path);
            }

//        }
    }
}
