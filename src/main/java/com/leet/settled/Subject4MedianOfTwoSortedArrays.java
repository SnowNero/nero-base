package com.leet.settled;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-07-09
 * Time: 22:55
 */
public class Subject4MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (1 == 1) {
            if (i != nums1.length && j != nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums[k] = nums1[i];
                    i++;
                    k++;
                } else if (nums1[i] > nums2[j]) {
                    nums[k] = nums2[j];
                    j++;
                    k++;
                } else {
                    nums[k] = nums1[i];
                    nums[k + 1] = nums2[j];
                    i++;
                    k++;
                    j++;
                    k++;
                }
            } else if (i == nums1.length) {
                nums[k] = nums2[j];
                j++;
                k++;
            } else {
                nums[k] = nums1[i];
                i++;
                k++;
            }
            if (k == nums.length) {
                break;
            }
        }
        if (nums.length % 2 == 0) {
            int a = (nums.length / 2) - 1;
            int b = nums.length / 2;
            return (double) (nums[a] + nums[b]) / 2;
        } else {
            int a = (nums.length - 1) / 2;
            return (double) nums[a];
        }
    }

}
