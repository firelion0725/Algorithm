package com.leo.algorithm.model;

import java.util.HashMap;

public class TrieNode {
    public int path;
    public int end;
    public HashMap<Character, TrieNode> next;

    public TrieNode() {
        path = 0;
        end = 0;
        next = new HashMap<>();
    }


}
