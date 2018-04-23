package pers.dxm.targetoffer.binarytree.BinaryTreeImage;

import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

import java.util.Stack;

/**
 * title:二叉树先序遍历，中序遍历，后序遍历两种实现方式（递归、循环）
 * Created by douxm on 2018\3\1 0001.
 */
public class SearchByRecursion {

    //递归的思想进行先序遍历
    public void firstSerach(TreeNode node) {
        MainEntrance.printNode(node);
        if (node.getLeftNode() != null) {
            firstSerach(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            firstSerach(node.getRightNode());
        }
    }

    //非递归（循环）的思想进行先序遍历
    public void firstSearch2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {  //将所有左孩子压栈
            if (node != null) {   //压栈之前先访问
                MainEntrance.printNode(node);
                stack.push(node);
                node = node.getLeftNode();
            } else {
                node = stack.pop();
                node = node.getRightNode();
            }
        }
    }

    //递归的思想进行中序遍历
    public void middleSerach(TreeNode node) {
        if (node.getLeftNode() != null) {
            middleSerach(node.getLeftNode());
        }
        MainEntrance.printNode(node);
        if (node.getRightNode() != null) {
            middleSerach(node.getRightNode());
        }
    }

    //非递归（循环）的思想进行中序遍历
    public void middleSerach2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.getLeftNode();
            } else {
                node = stack.pop(); //出栈并访问
                MainEntrance.printNode(node);
                node = node.getRightNode();
            }
        }
    }

    //递归的思想进行后序遍历
    public void lastSerach(TreeNode node) {
        if (node.getLeftNode() != null) {
            lastSerach(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            lastSerach(node.getRightNode());
        }
        MainEntrance.printNode(node);
    }

    //非递归（循环）的思想进行后序遍历
    public void lastSerach2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();//构造一个中间栈来存储逆后序遍历的结果
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightNode();
            } else {
                node = stack.pop();
                node = node.getLeftNode();
            }
        }
        System.out.println(output.size());
        while (output.size() > 0) {
            MainEntrance.printNode(node);
        }
    }

    public static void main(String[] args) {
        MainEntrance.resursionInit();
    }
}
