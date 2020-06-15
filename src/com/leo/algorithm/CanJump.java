package com.leo.algorithm;

import javafx.util.Pair;

import java.util.*;

public class CanJump {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {2, 1, 1, 1, 1};
        CanJump c = new CanJump();
        int result = c.jump(nums);
        System.out.println(result);
    }

    public boolean canJump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        q.add(0);
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                // idx is current position
                int idx = q.remove();
                // if this condition is true, we can find an answer
                if (idx >= nums.length - 1) return true;
                // i is the next rightmost position we can reach
                for (int i = idx + 1; i < nums.length &&
                        i <= idx + nums[idx]; i++) {
                    if (visited[i]) continue;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return false;
    }

    public boolean canJumpOffice(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean jump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        List<Integer> result = new ArrayList<>();
        //key :value  value:index
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int step = nums[0];

        queue.add(new Pair<>(step, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int key = pair.getKey();
            int value = pair.getValue();

            if (value + key >= nums.length - 1) {
                return true;
            }

            for (int i = 1; i <= key; i++) {
                if (value + i < nums.length) {
                    queue.add(new Pair<>(nums[value + i], value + i));
                }
            }
        }
        return false;
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        List<Integer> result = new ArrayList<>();
        //key :value  value:index
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int step = nums[0];

        queue.add(new Pair<>(step, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int key = pair.getKey();
            int value = pair.getValue();

            if (value + key >= nums.length - 1) {
                result.add(count + 1);
            }

            if (queue.isEmpty()) {
                count++;
            }

            for (int i = 1; i <= key; i++) {
                if (value + i < nums.length) {
                    queue.add(new Pair<>(nums[value + i], value + i));
                }
            }

        }
        result.sort(Comparator.naturalOrder());

        return result.get(0);
    }
}
