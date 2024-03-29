package com.company.leetcode.M845;

public class Main {
    public static void main(String[] args) {
        assert new Solution().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}) == 5;
        assert new Solution().longestMountain(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}) == 0;
        assert new Solution().longestMountain(new int[]{2, 2, 2}) == 0;
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n) , space O(1)
    public int longestMountain(int[] arr) {
        int[] ldp = new int[arr.length];
        int[] rdp = new int[arr.length];
        for (int i = 1; i < ldp.length; i++) {
            if (arr[i] > arr[i - 1]) ldp[i] = ldp[i - 1] + 1;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) rdp[i] = rdp[i + 1] + 1;
        }
        int ans = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                ans = Math.max(ans, rdp[i] + ldp[i] + 1);
            }
        }
        return ans;
    }

    // time O(n ^ 2), space O(1)
//    public int longestMountain(int[] arr) {
//        int[] cache = new int[arr.length];
//
//        if (arr.length < 3) return 0;
//        int ans = 0;
//        for (int i = 1; i < arr.length - 1; i++) {
//            ans = Math.max(ans, mountLength(i, arr, cache));
//        }
//        if (ans == 1) return 0;
//        return ans;
//    }
//
//    public int mountLength(int idx, int[] arr, int[] cache) {
//        if (cache[idx] != 0) return cache[idx];
//        int l = idx - 1;
//        int r = idx + 1;
//        int ld = 0, rd = 0;
//        int cur = arr[idx];
//
//        while (l >= 0) {
//            if (arr[l] < cur) {
//                ld += 1;
//                cur = arr[l];
//                l--;
//            } else break;
//        }
//        cur = arr[idx];
//        while (r < arr.length) {
//            if (arr[r] < cur) {
//                rd += 1;
//                cur = arr[r];
//                r++;
//            } else break;
//        }
//        if (ld == 0 || rd == 0) return 0;
//        cache[idx] = ld + rd + 1;
//        return ld + rd + 1;
//    }
}