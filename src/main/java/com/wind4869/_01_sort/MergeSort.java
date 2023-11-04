package com.wind4869._01_sort;

import java.util.Arrays;

class MergeSort {
    private static int[] temp;

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 5};
        temp = new int[nums.length];
//        mergeSort(nums, 0, nums.length - 1);
        mergeSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void mergeSort(int[] nums) {
        int n = nums.length;
        for (int size = 1; size < n; size *= 2) {
            int left = 0;
            while (left < n) {
                int right = Math.min(n - 1, left + 2 * size - 1);
                int mid = (left + right) / 2;
                merge(nums, left, mid, right);
                left = right + 1;
            }
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (i = left; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
