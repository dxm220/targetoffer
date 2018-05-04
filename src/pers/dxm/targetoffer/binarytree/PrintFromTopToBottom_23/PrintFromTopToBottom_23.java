package pers.dxm.targetoffer.binarytree.PrintFromTopToBottom_23;

import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: dxm
 * Date: 2018\5\4 0004
 * Time: 9:59
 * title:从上往下打印二叉树
 * viewpoint:这个题的本质是二叉树的按层打印，具体过程：首先打印根节点，再打印根节点的左右子节点，再打印左子节点的左右子节点，右子节点的左右子节点
 * 以此类推，所以说在打印某个节点的同时，就要将该节点的左右子节点放入一个容器，按照先访问先打印的原则，我们选用的容器是队列（符合先进先出的原则）
 * 注意：以后遇到二叉树按层遍历，一定要用到队列作为辅助工具
 */
public class PrintFromTopToBottom_23 {
    public ArrayList<Integer> print(TreeNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            list.add(node.getData());
            if (node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.add(node.getRightNode());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        PrintFromTopToBottom_23 printFromTopToBottom_23 = new PrintFromTopToBottom_23();
        ArrayList list = printFromTopToBottom_23.print(A);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ";");
        }
    }
}
