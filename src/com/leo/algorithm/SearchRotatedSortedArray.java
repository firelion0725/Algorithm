package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        SearchRotatedSortedArray a = new SearchRotatedSortedArray();
        int result = a.search(nums, 0);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            }
            if (nums[1] == target) {
                return 1;
            }
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;


        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }

            if (nums[left] < nums[mid] && target >= nums[left] && target <= nums[mid]) {
                right = mid - 1;
            } else if (nums[left] < nums[mid] && (target <= nums[left] || target >= nums[mid])) {
                left = mid + 1;
            } else if (nums[left] > nums[mid] && (target >= nums[left] || target <= nums[mid])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

}
