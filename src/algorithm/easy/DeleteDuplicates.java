package algorithm.easy;

public class DeleteDuplicates {
    public static ListNode solution(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next != null && tmp.next.val == tmp.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNodes = new ListNode(1, 1, 2,3,3);
        printList(listNodes);
        printList(solution(listNodes));
    }

    public static void printList(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
