package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeBinaryTree {

    public static void main(String[] args) {
        String string = "1,2,3,null,5";
        SerializeBinaryTree s = new SerializeBinaryTree();
        TreeNode treeNode = s.deserialize(string);

        String result = s.serialize(treeNode);
        System.out.println(result);
    }

    //=========================================== 不太对
    // Encodes a tree to a single string.
    //广度优先遍历
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        helper(stringBuilder, root);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String helper(StringBuilder stringBuilder, TreeNode node) {
        if (node != null) {
            stringBuilder.append(node.val);
            stringBuilder.append(",");
            String s = helper(stringBuilder, node.left);
            return helper(new StringBuilder(s), node.right);
        } else {
            stringBuilder.append("null");
            stringBuilder.append(",");
            return stringBuilder.toString();
        }
    }
//===============================================================


    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if(root==null) return new String();
        StringBuilder result=new StringBuilder();
        result.append('[');
        Deque<TreeNode> quque=new LinkedList<>();
        quque.add(root);
        TreeNode cur;
        int validNum=1;//此时队列非空结点为1
        while(validNum!=0){
            cur=quque.remove();
            if(cur!=null){
                validNum--;//非空结点-1
                result.append(cur.val);
                result.append(',');
                if(cur.left!=null){
                    quque.add(cur.left);
                    validNum++;//非空结点+1
                }
                else quque.add(null);
                if(cur.right!=null){
                    quque.add(cur.right);
                    validNum++;//非空结点+1
                }
                else quque.add(null);
            }
            else result.append("null,");
        }
        result.setLength(result.length() - 1);//去掉最后一个逗号
        result.append(']');
        return result.toString();
    }





    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String temp = data.replace("[", "").replace("]", "");
        String[] strings = temp.split(",");
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(new TreeNode(0));
        for (String s : strings) {
            if (!s.equals("null")) {
                TreeNode node = new TreeNode(Integer.valueOf(s));
                nodes.add(node);
            } else {
                nodes.add(null);
            }
        }

        for (int i = 1; i < nodes.size(); i++) {
            TreeNode n = nodes.get(i);
            if (n != null) {
                if (2 * i < nodes.size()) {
                    n.left = nodes.get(2 * i);
                }
                if (2 * i + 1 < nodes.size()) {
                    n.right = nodes.get(2 * i + 1);
                }
            }
        }
        return nodes.get(1);
    }
}
