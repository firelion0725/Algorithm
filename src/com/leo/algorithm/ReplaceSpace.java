package com.leo.algorithm;

public class ReplaceSpace {


    /**
     * 首个独立写出的双百题解 happy！
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();

        StringBuffer stringBuffer = new StringBuffer();
        for (char aChar : chars) {
            if (aChar == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(aChar);
            }
        }
        return stringBuffer.toString();
    }
}
