package pers.dxm.targetoffer.list.DeleteNode_13;

import pers.dxm.targetoffer.list.ListNode;

/**
 * Created by douxm on 2018\4\19 0019.
 * title:在O(1)时间删除链表节点
 * viewpoint:由于单链表只有指向后节点的指针，所以说给定一个节点是找不到该节点的前面一个节点的
 * 所以说这个题只能在后面的节点上做文章。比如说3->4->5->6要删除4，只能将4位置的值赋为5，然后将4位置的指针指向6
 * 即3->5->5->6，3->5->6
 */
public class DeleteNode_13 {
    public void deleteNode(ListNode headNode, ListNode deleteNode) {
        //如果头结点为null即链表为空，直接跳出方法
        if (headNode == null) {
            return;
        }
        //如果待删除节点不是链表尾节点
        if (deleteNode.getNextNode() != null) {
            deleteNode.setValue(deleteNode.getNextNode().getValue());
            deleteNode.setNextNode(deleteNode.getNextNode().getNextNode());
        } else if (deleteNode == headNode) {//删除的节点是头结点
            headNode = null;//删除头结点
        } else {//删除的节点是尾节点
            //将尾节点删除并保证头结点不移动，用一个temp实现
            ListNode temp = headNode;
            while (deleteNode != null) {
                if (temp.getNextNode() == deleteNode) {
                    temp.setNextNode(null);
                    break;
                }
                temp = temp.getNextNode();
            }
        }
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        headNode.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        DeleteNode_13 deleteNode_13 = new DeleteNode_13();
        deleteNode_13.deleteNode(headNode, headNode);
        while (headNode != null) {
            System.out.println(headNode.getValue());
            headNode = headNode.getNextNode();
        }
    }
}
