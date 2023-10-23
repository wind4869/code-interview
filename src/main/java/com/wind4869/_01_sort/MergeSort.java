package com.wind4869._01_sort;

import java.util.*;

class MergeSort {
    private static int[] temp;

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 5};
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (k = left; k <= right; k++) {
            nums[k] = temp[k];
        }
    }
}
