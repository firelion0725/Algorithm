package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        String input = "(()())(())";
        String result = removeOuterParentheses(input);
        System.out.println(result);
    }

    public static String removeOuterParentheses(String S) {
        StringBuffer stringBuffer = new StringBuffer(S);
        int sum = 0;
        int start = -1;
        int index = 0;
        while (index < stringBuffer.length()) {
            char c = stringBuffer.charAt(index);
            if (c == '(') {
                sum++;
                //如果index没有标记 则给index初始位置
                if (start == -1) {
                    start = index;
                }
            } else {
                sum--;
            }

            if (sum == 0) {
                //TODO remove start index 的位置 和i的位置 既最外层的括号
                stringBuffer.deleteCharAt(index);
                stringBuffer.deleteCharAt(start);
                index-=2;
                start = -1;
            }

            index ++;
        }
        return stringBuffer.toString();
    }

}
