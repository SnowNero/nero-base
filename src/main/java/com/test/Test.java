package com.test;


import com.nero.utils.MD5Utils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2020-09-24
 * Time: 21:56
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode l = new TreeNode(4);
        l.left = new TreeNode(1);
        TreeNode r = new TreeNode(7);
        r.left = new TreeNode(5);
        r.right = new TreeNode(8);
        treeNode1.left = l;
        treeNode1.right = r;

        TreeNode treeNode2 = new TreeNode(4);
        TreeNode l2 = new TreeNode(1);
        l2.left = new TreeNode(8);
        l2.right = new TreeNode(9);
        TreeNode r2 = new TreeNode(6);
        treeNode2.left = l2;
        treeNode2.right = r2;

        TreeNode res = test.mergeTrees(treeNode1, treeNode2);
        System.out.println(res);
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null && t2 != null)
            return t2;
        if (t1 != null && t2 == null)
            return t1;
        t1.val = Math.max(t1.val, t2.val);
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
