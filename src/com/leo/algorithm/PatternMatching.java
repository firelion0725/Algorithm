package com.leo.algorithm;

public class PatternMatching {
    public boolean patternMatching(String pattern, String value) {

        //特例情况的判定================================
        //字符串长度为0时
        if (value.length() == 0) {
            //匹配串长度不为0
            if (pattern.length() != 0) {
                for (int i = 1; i < pattern.length(); i++) {
                    //如果匹配串不是只有a或者只有b
                    if (pattern.charAt(i - 1) != pattern.charAt(i))
                        return false;
                }
            }
            //匹配串长度为0
            return true;
        }
        //匹配串长度为0，或者1时，不需要多余判断
        if (pattern.length() == 0) return false;
        if (pattern.length() == 1) return true;
        //================================================

        //出现在首个位置的，无论是a还是b，都视为a
        char a = pattern.charAt(0);
        //匹配串中a，b的个数
        int ca = 0, cb = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == a) ca++;
            else cb++;
        }


        int lv = value.length(), lp = pattern.length();
        //b没有出现，此处的真实情况可能为'a'没出现，也可能为'b'没出现，但只会被视为b没出现 即只有一种匹配类型
        if (cb == 0) {
            //满足ca*la=lv即可 先看个数是否匹配
            if (lv % ca != 0) return false;
            //再看内容是否匹配 整个字符串长度/类型个数 = 单个类型的长度
            int la = lv / ca;
            //获取单个数据的内容
            String aa = value.substring(0, la);
            for (int i = aa.length(); i < value.length(); i += aa.length()) {
                //用截取字符串的方法 比每个子串是否一致
                if (!value.substring(i, i + aa.length()).equals(aa)) return false;
            }
            return true;
        }


        //lv=ca*la+cb*lb
        for (int la = 0; la * ca <= value.length(); ++la) {
            //以上方程中lv,ca,la,cb均已知，那么就可以计算出lb
            int rest = lv - ca * la;
            //la的值不满足方程，跳过此次判定
            if (rest % cb != 0) continue;
            int lb = rest / cb, ci = 0;
            //匹配标识
            boolean isMatch = true;
            //aa，bb设定默认值
            String aa = "", bb = "";
            //开始匹配
            for (char c : pattern.toCharArray()) {
                if (c == a) {
                    String cur_a = value.substring(ci, ci += la);
                    //此处理论上有两个入口会进这个if
                    // 1.初次进入
                    // 2.不是初次进入，但la长度为0
                    if (aa.length() == 0)
                        aa = cur_a;
                        //字符串不相同，退出匹配串遍历
                    else if (!aa.equals(cur_a)) {
                        isMatch = false;
                        break;
                    }
                } else {
                    //同上
                    String cur_b = value.substring(ci, ci += lb);
                    if (bb.length() == 0)
                        bb = cur_b;
                    else if (!bb.equals(cur_b)) {
                        isMatch = false;
                        break;
                    }
                }
            }
            //如果此次已经全部匹配，那么就不用继续枚举，通过匹配
            if (isMatch && !aa.equals(bb)) return true;
        }
        //都不满足，默认出口
        return false;
    }

    public boolean patternMatching2(String pattern, String value) {
        // 如果pattern不含任意字符，则返回为value是否为空
        if (pattern == null || pattern.length() == 0) {
            return value == null || value.length() == 0;
        }

        int cntA = 0, cntB = 0;
        // 其实a和b是可以互相替换的，因此为了下面方便起见，将首次出现的字母当作a
        char first = pattern.charAt(0);
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == first) {
                cntA++;
            } else {
                cntB++;
            }
        }

        // 如果a和b有一个是只出现一次，那么一定可以正确表示（另一个表示为空串即可）
        if (cntA != cntB && (cntA == 1 || cntB == 1)) {
            return true;
        }

        int aPresentLength = 0, bPresentLength;
        while (aPresentLength * cntA <= value.length()) {
            // 除去所有a表示字符串后，剩余的字符串长度
            int left = value.length() - aPresentLength * cntA;

            // 如果cntB是0 或者 剩余的字符串是cntB的倍数，则才有可能组成value
            if ((cntB == 0 && left == 0) || (cntB != 0 && left % cntB == 0)) {
                // 计算b表示的字符串长度
                bPresentLength = cntB == 0 ? 0 : left / cntB;

                // 计算a表示的字符串
                String aPresent = value.substring(0, aPresentLength), bPresent = "";

                int index = 1;
                // 找到b首次出现的位置，得到b代表的字符串
                while (index < pattern.length() && pattern.charAt(index) == first) {
                    ++index;
                }
                // 避免越界
                if (index < pattern.length()) {
                    // 计算b表示的字符串
                    int from = aPresentLength * index, to = from + bPresentLength;
                    bPresent = value.substring(from, to);
                }

                // 如果此时a和b表示的字符串相等，则不符合题意
                if (aPresent.equals(bPresent)) {
                    ++aPresentLength;
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pattern.length(); i++) {
                    if (pattern.charAt(i) == first) {
                        sb.append(aPresent);
                    } else {
                        sb.append(bPresent);
                    }
                }
                if (sb.toString().equals(value)) {
                    return true;
                }
            }
            // 这里如果cntA为0的话，则在上面的if语句里已经计算过了，如果一味增加
            // a的长度，那么会陷入死循环
            if (cntA == 0) {
                break;
            }

            aPresentLength++;
        }
        return false;
    }


}
