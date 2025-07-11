package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayListP {
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

}
