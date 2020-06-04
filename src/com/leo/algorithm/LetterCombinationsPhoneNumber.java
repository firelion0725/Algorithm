package com.leo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber l = new LetterCombinationsPhoneNumber();
        l.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        backTrance(result, chars, 0, new StringBuffer());
        return result;
    }

    private void backTrance(List<String> result, char[] chars, int begin, StringBuffer stringBuffer) {
        if (stringBuffer.length() == chars.length) {
            result.add(stringBuffer.toString());
            return;
        }

        for (int i = begin; i < chars.length; i++) {
            String[] data = getChars(chars[i]);
            for (int j = 0; j < data.length; j++) {
                stringBuffer.append(data[j]);
                backTrance(result, chars, i + 1, stringBuffer);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
    }

    private String[] getChars(char num) {

        switch (num) {
            case '2':
                return new String[]{"a", "b", "c"};
            case '3':
                return new String[]{"d", "e", "f"};
            case '4':
                return new String[]{"g", "h", "i"};
            case '5':
                return new String[]{"j", "k", "l"};
            case '6':
                return new String[]{"m", "n", "o"};
            case '7':
                return new String[]{"p", "q", "r", "s"};
            case '8':
                return new String[]{"t", "u", "v"};
            case '9':
                return new String[]{"w", "x", "y", "z"};
            default:
                return new String[0];
        }
    }

    //===========================================================================

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinationsOffice(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }


}
