package algorithm.easy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class IsSameTree {
    private boolean lc = true;
    private boolean rc = true;
    public boolean solution(TreeNode p, TreeNode q) {
        // 一旦有false,直接返回false
        if (!(lc && rc)) {
            return false;
        }
        // 如果p和q都为空树返回true
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            // p为空, q不为空
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        lc = solution(p.left, q.left);
        rc = solution(p.right, q.right);
        // 比较完成,均通过
        return lc && rc;
    }
}
