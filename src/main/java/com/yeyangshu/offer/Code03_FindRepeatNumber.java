package com.yeyangshu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 最笨的方法
 */
public class Code03_FindRepeatNumber {

    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                Integer num = map.get(nums[i]);
                map.put(nums[i], ++num);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrs = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arrs));
    }
}