package pers.dxm.targetoffer.list.PrintListReverse_5;

import pers.dxm.targetoffer.list.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by douxm on 2018\4\2 0002.
 * title：从尾到头打印链表
 * viewpoint：可以将二维数组看作是一个m*n矩阵，利用递归的思想。选取矩阵中右上角的数与target进行比较
 * 如果相等直接结束查找，如果target>右上角数，剔除掉对应列后递归
 * 如果target<右上角数，剔除掉对应行后递归。逐步剔除递归，最终得到true或false
 */
public class PrintListReverse_5 {
    /**
     * 方法1：遍历链表，边遍历边入栈（利用栈先进后出的特点），遍历完成后依次出栈即为反序输出的结果
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (listNode == null) {
            return null;
        }
        while (listNode != null) {
            stack.push(listNode.getValue());
            listNode = listNode.getNextNode();
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 方法2：利用递归的方式，递归到最后一个元素后依次往前打印
     */
    public void printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        if (listNode.getNextNode() != null) {
            printListFromTailToHead2(listNode.getNextNode());
        }
        System.out.println(listNode.getValue());
    }


    public static void main(String[] args) {
        PrintListReverse_5 printListReverse_5 = new PrintListReverse_5();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.setNextNode(listNode2);
        listNode2.setNextNode(listNode3);
        ArrayList<Integer> list = printListReverse_5.printListFromTailToHead1(listNode1);
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("--------------------------------------------");
        printListReverse_5.printListFromTailToHead2(listNode1);

    }
}
