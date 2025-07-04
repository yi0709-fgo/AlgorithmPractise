package com.example.Leetcode;

public class SearchInsertPosition {
//    Given a sorted array of distinct integers and a target value, return the index if the target is found.
//    If not, return the index where it would be if it were inserted in order.
    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;
        //to avoid deal loop
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            //shrink list
            else if(nums[mid]<target){
                left = mid;
                left ++;
            }else{
                right = mid;

            }
        }
        return nums[left]<target?left+1:left;
    }
}
