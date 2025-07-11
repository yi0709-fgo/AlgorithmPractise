package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListP {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));


    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int count = 0;
        for(int i=count; i<intervals.length; i++){
            if(intervals[i][1]<newInterval[0]){
                res.add(intervals[i]);
                count++;
            }
        }
        for(int i=count; i<intervals.length; i++){
            if(intervals[i][0]>newInterval[1]){
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.min(newInterval[1],intervals[i][1]);
                count++;
            }
        }
        res.add(newInterval);
        for(int i=count; i<intervals.length; i++){
            res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);

    }

    //    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=nums1.length-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

    }

    //convert sort array to BST
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){return null;}

        TreeNode res = recursion(0, nums.length - 1,nums);
        return res;
    }
    public TreeNode recursion(int left, int right, int[] nums){
        if(left>right){return null;}

        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(left, mid-1,nums);
        root.right = recursion(mid+1, right,nums);
        return root;
    }
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        res.add(first);
        for(int i=0;i<nums.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=i;j<nums.length;j++){
                temp.add(nums[j]);
                res.add(new ArrayList<>(temp));

            }
        }
        List<List<Integer>> distinctList = res.stream().distinct().collect(Collectors.toList());
        return distinctList;

    }
}
