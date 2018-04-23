package pers.dxm.targetoffer.list.FindKthToTail_15;

import pers.dxm.targetoffer.list.ListNode;

/**
 * Created by douxm on 2018\4\19 0019.
 * title:寻找链表中倒数第k个节点
 * pointview:找两个指针，第一个指针先往后走k-1步（即走到索引为k-1的位置），然后两个指针同时往后走，确保两个指针始终相隔k个距离
 * 直到先走的指针走到链表尾时，后走的指针自然指向倒数第k个节点
 */
public class FindKthToTail_15 {
    public ListNode findKthToTail(int k, ListNode headNode) {
        //如果头节点为空，返回null
        if (headNode == null) {
            return null;
        }
        //如果链表的长度小于k，返回null
        int count = 1;
        ListNode temp = headNode;
        while (temp.getNextNode() != null) {
            count++;
            temp = temp.getNextNode();
        }
        if (count < k) {
            return null;
        }
        int first = k - 1;
        ListNode temp1 = headNode;
        int second = 0;
        ListNode temp2 = headNode;
        int i = 0;
        //先让第一个指针走k步
        while (i < k - 1) {
            temp1 = temp1.getNextNode();
            i++;
        }
        while (temp1.getNextNode() != null) {
            temp1 = temp1.getNextNode();
            temp2 = temp2.getNextNode();
        }
        return temp2;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        headNode.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node6);
        FindKthToTail_15 findKthToTail_15 = new FindKthToTail_15();
        ListNode node = findKthToTail_15.findKthToTail(3, headNode);
        if (node==null) {
            System.out.println("输入非法");
        }else{
            System.out.println(node.getValue());
        }
    }
}
