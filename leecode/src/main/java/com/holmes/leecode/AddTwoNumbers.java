package com.holmes.leecode;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author Administrator
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        new AddTwoNumbers();
    }

    public AddTwoNumbers() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(9);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node = addTwoNumbers(node1, node4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode currentNode = null;
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        while (null != a || null != b) {

            int sum = (null == a ? 0 : a.val) + (null == b ? 0 : b.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode p = new ListNode(sum);
            if (null == result) {
                result = p;
                currentNode = p;
            } else {
                currentNode.next = p;
                currentNode = p;
            }
            a = (null == a ? null : a.next);
            b = (null == b ? null : b.next);
        }
        if(carry == 1) {
            currentNode.next = new ListNode(carry);
        }
        return result;
    }
}
