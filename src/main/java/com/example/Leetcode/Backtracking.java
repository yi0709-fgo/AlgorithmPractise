package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(arrayToList(nums));
            return res;
        }
        backtracking(nums, 0, res);
        return res;
    }

    public void backtracking(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(arrayToList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            backtracking(nums, start + 1, res);
            swap(nums, i, start);
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}


