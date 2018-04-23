package pers.dxm.targetoffer.binarytree.BinaryTreeKthNode;

import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by douxm on 2018\3\8 0008.
 * title：二叉搜索树的第K个节点
 * viewpoint：对于一颗二叉搜索树，其中序遍历的结果就是将节点从小到大排列的结果，
 * 要想找到第K大的节点，只需要中序遍历后取遍历结果中的第K个值即可
 */
public class BinaryTreeKthNode {
    int count = 0;//当前遍历到二叉树的第n个节点

    public void KthNode(TreeNode node, int k) {
        if (count > 11-k) {//若当前遍历节点数超过K值则停止操作
            return;
        }
        if (node == null) {
            return;
        }
        if (node.getLeftNode() != null) {
            KthNode(node.getLeftNode(), k);
        }
        count++;
        if (count == 11-k) {
            System.out.println("第" + k + "大的数为：" + node.getData());
            return;
        }
        if (node.getRightNode() != null) {
            KthNode(node.getRightNode(), k);
        }
    }

    public static void main(String[] args) {
        TreeNode node = InitBinaryTree.initSearchTree();
        BinaryTreeKthNode binaryTreeKthNode = new BinaryTreeKthNode();
        binaryTreeKthNode.KthNode(node, 4);
    }

}
