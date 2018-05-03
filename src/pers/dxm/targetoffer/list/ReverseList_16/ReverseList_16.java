package pers.dxm.targetoffer.list.ReverseList_16;

import pers.dxm.targetoffer.list.ListNode;

/**
 * Created by douxm on 2018\4\23 0023.
 * title:反转链表
 * pointview:本题的思路是将从前往后的指针转变为从后往前的指针，在反转的过程中，一定会出现链表暂时性断裂的情况
 * 所以说需要一个专门的指针，指向断裂部分的链表，保证链表的每个数据都能被访问。综上所述一共需要三个指针完成这一操作
 */
public class ReverseList_16 {
    public ListNode reverseList(ListNode head) {
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        if (head == null) {
            return null;
        }
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点1->2->3->4->5变为1<-2<-3 4->5
        ListNode pre = null;
        ListNode next = null;
        //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre;如此就可以做到反转链表的效果；
        while (head != null) {
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.getNextNode();
            //保存完next，就可以让head从指向next变成指向pre了
            head.setNextNode(pre);
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
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
        ReverseList_16 reverseList_16 = new ReverseList_16();
        ListNode node = reverseList_16.reverseList(headNode);
        while (node != null) {
            System.out.print(node.getValue() + ";");
            node = node.getNextNode();
        }
    }
}
