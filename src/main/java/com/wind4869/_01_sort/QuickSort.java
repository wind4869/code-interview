package com.wind4869._01_sort;

import java.util.*;

class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 5};
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left - 1, j = right + 1, pivot = nums[(left + right) / 2];
        while (i < j) {
            do i++; while (nums[i] < pivot);
            do j--; while (nums[j] > pivot);
            if (i < j) swap(nums, i, j);
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
