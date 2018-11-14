package algorithm.easy;

public class IsSymmetric {
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return subCompare(root.left, root.right);
        }
    }

    public boolean subCompare(TreeNode p, TreeNode q) {
        boolean lc = false;
        boolean rc = false;

        // 如果p和q均为空,镜像对称,true
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            // 如果p和q都不为空,比较值是否相同,相同,递归遍历
            if (p.val == q.val) {
                // 比较p的左和q的右是否一致
                lc = subCompare(p.left, q.right);
                // 比较q的左和p的右是否一致
                rc = subCompare(p.right, q.left);
            } else {
                // 不同,不是镜像对称
                return false;
            }
        } else {
            // 如果p和q其中一方为空,镜像不对称,false
            return false;
        }

        return lc && rc;
    }
}
