package com.leo.algorithm;

import java.util.HashSet;

/**
 * 菜狗式解法
 */
public class Trie {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("ab");
        boolean r1 = t.search("abc");
        System.out.println(r1);
        boolean r2 = t.search("ab");
        System.out.println(r2);
        boolean r3 = t.startsWith("abc");
        System.out.println(r3);
        boolean r4 = t.startsWith("ab");
        System.out.println(r4);
        t.insert("ab");
        boolean r5 = t.search("abc");
        System.out.println(r5);
        boolean r6 = t.startsWith("abc");
        System.out.println(r6);
        t.insert("rental");
        boolean r7 = t.search("abc");
        System.out.println(r7);
        boolean r8 = t.startsWith("rest");
        System.out.println(r8);
    }


    HashSet<String> strings;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        strings = new HashSet<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        strings.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return strings.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (String str : strings) {
            if (str.startsWith(prefix)) {
                return true;
            }
//            if (str.length() < prefix.length()) {
//                continue;
//            }
//            for (int i = 0; i < prefix.length(); i++) {
//                if (str.charAt(i) != prefix.charAt(i)) {
//                    break;
//                }
//            }
        }
        return false;
    }
}
