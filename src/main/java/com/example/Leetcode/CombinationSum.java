package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
//        backtracking
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,candidates,new ArrayList<>(),res,0,target);
        return res;
    }
    public static void backtrack(int i, int[] candidates, List<Integer> curr, List<List<Integer>> res,int total, int target){
        if(total==target){
            //add copy of list not reference
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i>=candidates.length || total>target){
            return;
        }

        curr.add(candidates[i]);
        backtrack(i,candidates,curr,res,total+candidates[i],target);
        //avoid duplicate res
        curr.remove(curr.size()-1);
        backtrack(i+1,candidates,curr,res,total,target);

    }



//    pseudo code
//    backtrack(candidate, target, currentpath){
//        if currentpath==target{
//        update the answer and/or end recursion}
//        for cand in candidate{
//            if cand is valid{
//                currentpath.add(cand);
//                backtrack(candidate, target, currentpath)
//                currentPath.remove(cand)
//            }
//        }
//    }
}
