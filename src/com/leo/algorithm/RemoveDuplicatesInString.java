package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

public class RemoveDuplicatesInString {

    public static void main(String[] args) {
        String s = "abbaca";
//        String s = "aaaaaaaa";
//        String s = "abbbabaaa";
        String n = removeDuplicates2(s);
        Utils.showResult(n);
    }

    public static String removeDuplicates(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        chars = helper(chars);
        return String.valueOf(chars);
    }

    private static char[] helper(char[] result) {
        if (result.length < 2 || (result.length == 2 && result[0] != result[1])) {
            return result;
        }

        int index = 0;
        while (index < result.length - 1) {
            if (result[index] == result[index + 1]) {
                result = deleteDoubleChar(result, index);
                return helper(result);
            }

            index++;
        }

        return result;

    }

    private static char[] deleteDoubleChar(char[] chars, int index) {
        char[] char2 = new char[chars.length - 2];
        int index2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i != index && i != index + 1) {
                char2[index2] = chars[i];
                index2++;
            }
        }
        return char2;
    }

    //=====================标答======================

    public static String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- - 1);
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }


//    private static String removeDuplicates2(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] chars = s.toCharArray();
//
//        stack.push(chars[0]);
//
//        for (int i = 1; i < chars.length; i++) {
//            try {
//                if (stack.lastElement() == chars[i]) {
//                    stack.pop();
//                } else {
//                    stack.push(chars[i]);
//                }
//            } catch (NoSuchElementException e) {
//                stack.push(chars[i]);
//            }
//        }
//        char[] result = new char[stack.size()];
//
//        int i = 0;
//        while (stack.size() != 0) {
//            result[i] = stack.pop();
//            i++;
//        }
//
//        return String.valueOf(result);
//    }
}
