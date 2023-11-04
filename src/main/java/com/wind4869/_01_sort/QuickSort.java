package com.wind4869._01_sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 5};
//        quickSort(nums, 0, nums.length - 1);
        quickSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int j = partition(nums, left, right);
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    private static void quickSort(int[] nums) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, nums.length - 1});
        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int left = range[0], right = range[1];
            if (left >= right) continue;
            int j = partition(nums, left, right);
            stack.push(new int[]{j + 1, right});
            stack.push(new int[]{left, j});
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int i = left - 1, j = right + 1, pivot = nums[(left + right) / 2];
        while (i < j) {
            do i++; while (nums[i] < pivot);
            do j--; while (nums[j] > pivot);
            if (i < j) swap(nums, i, j);
        }
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
