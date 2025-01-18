package org.exercise.linkedNode;

public class LinkedTable {


    /** leetcdoe2095 删除链表的中间节点 */
    public ListNode deleteMiddle(ListNode head) {
        ListNode nextNode = head;

        int num = 1;
        while(nextNode.next!=null) {
            nextNode=nextNode.next;
            num++;
        }

        if (num==1) {
            return null;
        } else if(num==2) {
            head.next = null;
            return head;
        }

        int mid = num/2;
        ListNode preNode = head;
        ListNode midNode = head;
        nextNode = head;
        for (int i=0; i<mid; i++) {
            preNode = midNode;
            midNode = midNode.next;
            nextNode = midNode.next;
        }
        preNode.next = nextNode;
        return head;
    }

}
