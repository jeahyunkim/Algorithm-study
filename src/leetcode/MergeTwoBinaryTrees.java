package leetcode;

import java.util.Stack;

public class MergeTwoBinaryTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.val = t1.val + t2.val;
        t1.left = mergeTrees1(t1.left, t2.left);
        t1.right = mergeTrees1(t1.right, t2.right);

        return t1;
    }

    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if ( t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val = t[0].val + t[1].val;
            if(t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }

            if(t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }

        }

        return t1;
    }



    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3, new TreeNode(5), new TreeNode());
        root1.right = new TreeNode(2, new TreeNode(), new TreeNode());

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1, new TreeNode(), new TreeNode(4));
        root2.right = new TreeNode(3, new TreeNode(), new TreeNode(7));

        TreeNode result = mergeTrees1(root1, root2);
        System.out.println(result);
    }
}
