package algorithm.easy;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int... args) {
        ListNode tmp = this;
        for (int i = 0; i < args.length; i++) {
            tmp.val = args[i];
            if (i == args.length - 1)
                break;
            tmp.next = new ListNode(args[i]);
            tmp = tmp.next;
        }
    }
}

public class mergeTwoLists {

    public static ListNode Solution(ListNode l1, ListNode l2) {
        // 初始化一个res,值为0
        ListNode res = new ListNode(0);
        // 用tmp别名替代res,以免改变返回结果的指向
        ListNode tmp = res;
        // 有一个方为空,则返回另一方
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 开始遍历l1和l2
        while (l1 != null && l2 != null) {
            // l1链表的值大于l2链表的值
            if (l1.val > l2.val) {
                // tmp是别名,指向当前l2,l2改变的时候当前tmp值不会改变
                tmp.next = l2;
                // l2为下一个节点
                l2 = l2.next;
            } else {
                // tmp是别名,指向当前l1,l1改变的时候当前tmp的值不会改变
                tmp.next = l1;
                // l1为下一个节点
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        // 如果l1或者l2其中一个到了节点尾部,将另一个链表接到tmp上并直接返回
        tmp.next = (l1 == null ? l2 : l1);
        return res.next;
    }

    public static void printList(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, 2, 4);
        ListNode l2 = new ListNode(1, 3, 4);
        printList(l1);
        printList(l2);
        printList(Solution(l1, l2));
    }
}
