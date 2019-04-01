package com.company;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode (int val) {
        this.val = val;
    }
    ListNode (int[] values) {
        this.val = values[0];
        ListNode pNode = this;
        for (int i = 1; i < values.length; i++) {
            pNode.next = new ListNode(values[i]);
            pNode = pNode.next;
        }
    }

    public void print() {
        ListNode pHead = this;
        while (pHead != null) {
            System.out.print(pHead.val);
            System.out.print(' ');
            pHead = pHead.next;
        }
        System.out.print('\n');
    }
}
