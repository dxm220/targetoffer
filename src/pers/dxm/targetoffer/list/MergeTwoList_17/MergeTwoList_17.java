package pers.dxm.targetoffer.list.MergeTwoList_17;

import pers.dxm.targetoffer.list.ListNode;
import pers.dxm.targetoffer.list.ReverseList_16.ReverseList_16;

/**
 * Created by douxm on 2018\4\23 0023.
 * title:合并两个排序的链表
 * viewpoint:既然两个链表都已经是排好序的，那么准备两个指针分别从两个链表的头结点出发，挨个遍历两个链表
 * 每一步都比较两个链表的头指针，将更小的那个放入新的链表，删除该节点并将头指针往后挪动一位
 */
public class MergeTwoList_17 {
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode result = null;
        while (head1 != null && head2 != null) {
            if (head1.getValue() < head2.getValue()) {
                if (result == null) {
                    result = new ListNode(head1.getValue());
                } else {
                    result.setNextNode(new ListNode(head1.getValue()));
                    result = result.getNextNode();
                }

                head1 = head1.getNextNode();
            } else if (head1.getValue() > head2.getValue()) {
                if (result == null) {
                    result = new ListNode(head2.getValue());
                } else {
                    result.setNextNode(new ListNode(head2.getValue()));
                    result = result.getNextNode();
                }
                head2 = head2.getNextNode();
            } else {
                if (result == null) {
                    result = new ListNode(head1.getValue());
                    result.setNextNode(new ListNode(head2.getValue()));
                    result = result.getNextNode();
                } else {
                    result.setNextNode(new ListNode(head1.getValue()));
                    result.getNextNode().setNextNode(new ListNode(head2.getValue()));
                    result = result.getNextNode().getNextNode();
                }
                head1 = head1.getNextNode();
                head2 = head2.getNextNode();
            }
        }
        //当某个链表为空时，此时只剩下一个已经排好序的链表，只需要将剩余一个链表的剩余元素拼接到result上即可
        if (head1 != null) {
            while (head1 != null) {
                result.setNextNode(head1);
                head1 = head1.getNextNode();
            }
        } else if (head2 != null) {
            while (head2 != null) {
                result.setNextNode(new ListNode(head2.getValue()));
                result = result.getNextNode();
                head2 = head2.getNextNode();
            }
        }
        return result;//返回的是合并完成后的末尾节点
    }

    public static void main(String[] args) {
        ListNode headNode1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode headNode2 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(6);
        headNode1.setNextNode(node2);
        node2.setNextNode(node3);
        headNode2.setNextNode(node5);
        node5.setNextNode(node6);
        MergeTwoList_17 mergeTwoList_17 = new MergeTwoList_17();
        ListNode result = mergeTwoList_17.merge(headNode1, headNode2);
        System.out.println(result.getValue() + "----------");
        //先将链表反转，再逐个打印
        ReverseList_16 reverseList_16 = new ReverseList_16();
        ListNode node = reverseList_16.reverseList(result);
        while (node != null) {
            System.out.print(node.getValue() + ";");
            node = node.getNextNode();
        }
    }
}
