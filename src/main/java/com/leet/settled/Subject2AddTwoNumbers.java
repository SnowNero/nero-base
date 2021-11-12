package com.leet.settled;

import com.leet.utils.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-07-08
 * Time: 22:59
 */

public class Subject2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int x;
        int y;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                x = l1.val;
            } else {
                x = 0;
            }
            if (l2 != null) {
                y = l2.val;
            } else {
                y = 0;
            }
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }*/

}
