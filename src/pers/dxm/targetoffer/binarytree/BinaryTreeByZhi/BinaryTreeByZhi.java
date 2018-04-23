package pers.dxm.targetoffer.binarytree.BinaryTreeByZhi;

import pers.dxm.targetoffer.binarytree.BinaryTreeRowPrint.BinaryTreeRowPrint;
import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by douxm on 2018\3\7 0007.
 * title：按之字形顺序打印二叉树
 * viewpoint：两个栈来回倒，第一行从左到右放到stack1,第二行从右向左放到stack2（利用的就是栈先进后出的特点）
 * 比如说，stack1弹出来的顺序是按某行从左到右的顺序弹出的，放到stack2中最顶端的就是该行最右边，
 * 最先出栈的也是该节点，然后再将该节点的右子节点，左子节点放入stack1，以此类推即可实现蛇形遍历
 */
public class BinaryTreeByZhi {
    public ArrayList<ArrayList<Integer>> Print(TreeNode rootNode) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (rootNode == null) {
            return list;
        }
        stack1.add(rootNode);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                row.add(node.getData());
                if (node.getLeftNode() != null) {
                    stack2.push(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    stack2.push(node.getRightNode());
                }
            }
            list.add(new ArrayList<>(row));
            row.clear();
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                row.add(node.getData());
                if (node.getRightNode() != null) {
                    stack1.push(node.getRightNode());
                }
                if (node.getLeftNode() != null) {
                    stack1.push(node.getLeftNode());
                }
            }
            list.add(new ArrayList<>(row));
            row.clear();
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = InitBinaryTree.initSimpleTree();
        BinaryTreeByZhi binaryTreeByZhi = new BinaryTreeByZhi();
        ArrayList<ArrayList<Integer>> list = binaryTreeByZhi.Print(node);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("第" + i + "行:");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + ";");
            }
            System.out.println();
        }
    }
}
