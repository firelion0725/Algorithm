package com.leo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BullsAndCows {

    public static void main(String[] args) {
        String secret = "1123", guess = "0111";
//        String secret = "1807", guess = "7810";
        String result = getHint(secret, guess);
        System.out.println(result);
    }

    //通过hash 和 list 存储值 进行对比
    public static String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                list.add(guess.charAt(i));
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        for (Character c : list) {
            if (map.get(c) != null && map.get(c) > 0) {
                B++;
                map.put(c, map.get(c) - 1);
            }
        }
        return A + "A" + B + "B";
    }
}
