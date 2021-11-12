package com.test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-09-17
 * Time: 19:28
 */
public class TreeNode {

    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
