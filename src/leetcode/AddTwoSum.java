package leetcode;

// s : 2021-01-21 01:01

import java.util.LinkedList;
import java.util.List;

public class AddTwoSum {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;

        int carry = 0;
        while(q != null || p != null) {
            int x = (q != null)? q.val : 0;
            int y = (p != null)? p.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if ( p != null) p = p.next;
            if ( q != null) q = q.next;
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode num2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(num1, num2);



    }
}
