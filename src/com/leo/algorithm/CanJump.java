package com.leo.algorithm;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanJump {

    public static void main(String[] args) {
        CanJump c=new CanJump();

    }

    public int jump(int[] nums) {
        //key :value  value:index
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int step = nums[0];

        queue.add(new Pair<>(step, 0));
        int count = 1;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int key = pair.getKey();
            int value = pair.getValue();

            if(value + key >= nums.length-1){
                return count +1;
            }

            for (int i = 1; i <= key; i++) {
                queue.add(new Pair<>(nums[value + i], value + i));
            }
            count++;
        }
        return count;
    }
}
