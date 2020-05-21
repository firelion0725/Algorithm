package com.leo.algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 45;
        int result = climbStairsOffice(n);

        System.out.printf("" + result);
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int step1, step2;
        if (map.get(n - 1) != null) {
            step1 = map.get(n - 1);
        } else {
            step1 = climbStairs(n - 1);
            map.put(n - 1, step1);
        }
        if (map.get(n - 2) != null) {
            step2 = map.get(n - 2);
        } else {
            step2 = climbStairs(n - 2);
            map.put(n - 2, step2);
        }

        int result = step1 + step2;
        map.put(n, result);
        return result;
    }


    //============================================

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int climbStairsOffice(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


}
