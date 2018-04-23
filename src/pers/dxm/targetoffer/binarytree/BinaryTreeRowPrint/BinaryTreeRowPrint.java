package pers.dxm.targetoffer.binarytree.BinaryTreeRowPrint;

import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by douxm on 2018\3\5 0005.
 * title：把二叉树打印成多行
 * viewpoint：借助队列先进先出的原则来实现，越早进去的肯定是层越小的，所以出来的也是按照层来排列的。
 */
public class BinaryTreeRowPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode rootNode) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (rootNode == null) {
            return list;
        }
        int now = 1;//当前队列中剩余节点数
        int next = 0;//下一行节点数
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            now--;
            row.add(node.getData());
            if (node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
                next++;
            }
            if (node.getRightNode() != null) {
                queue.add(node.getRightNode());
                next++;
            }
            if (now == 0) {
                list.add(new ArrayList<Integer>(row));
                row.clear();
                now = next;
                next = 0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = InitBinaryTree.initSimpleTree();
        BinaryTreeRowPrint binaryTreeRowPrint = new BinaryTreeRowPrint();
        ArrayList<ArrayList<Integer>> list = binaryTreeRowPrint.Print(node);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("第"+i+"行:");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + ";");
            }
            System.out.println();
        }
    }
}
