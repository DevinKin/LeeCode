package algorithm.medium;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = tmp;

        int carry = 0;
        while (p1 != null || p2 != null) {

            int x = (p1 == null) ? 0 : p1.val;
            int y = (p2 == null) ? 0 : p2.val;
            int sum = x + y + carry;
            // 判断是否有进位
            carry = sum / 10;
            // 取结果的mod 10
            sum %= 10;

            tmp.next = new ListNode(sum);

            tmp = tmp.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        // 最后还有进位,添加到节点的末尾
        if (carry == 1) {
            tmp.next = new ListNode(carry);
        }
        return res.next;
    }
}
