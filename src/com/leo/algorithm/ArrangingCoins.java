package com.leo.algorithm;

public class ArrangingCoins {

    public static void main(String[] args) {
        int n = 8;
        int result = arrangeCoins2(n);
        System.out.println("" + result);
    }

    public static int arrangeCoins(int n) {
        if (n < 1) {
            return 0;
        }
        return helper(1, n);
    }

    private static int helper(int level, int n) {
        //递归退出条件
        if (n < level) {
            return level - 1;
        }
        //尾部递归原则
        return helper(level + 1, n - level);
    }


    public static int arrangeCoins2(int n) {
        int i = 1;
        while (n >= i) {
            i++;
            n -= i;
        }
        return i - 1;
    }

    //============有人拿数学法求解 ... ennn =======================

    /**
     * 根据数学公式，k(k+1) /2 = n，可以得到其正数解为：k = sqrt(2n+1/4) - 1/2。然后求整即可。
     * 唯一的问题是，这里2n+1/4有可能会超出sqrt函数的参数范围。
     * 于是，我们可以变换一下， k = sqrt(2) * sqrt(n+1/8) - 1/2，这样求平方根就不会超限了。
     * 于是，我们就有了这么一行代码
     *
     * 作者：homesway
     * 链接：https://leetcode-cn.com/problems/arranging-coins/solution/zhi-jie-qiu-kk1-2-nde-jie-ran-hou-qu-zheng-ji-ke-y/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int arrangeCoins3(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

}
