package pers.dxm.targetoffer.binarytree.BinaryTreeImage_19;

import pers.dxm.targetoffer.binarytree.BinaryTreeSearch.SearchByRecursion;
import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by douxm on 2018\3\5 0005.
 * title：二叉树的镜像
 * viewpoint：左子节点和右子节点交换，依次递归执行到底
 */
public class BinaryTreeImage_19 {
    public TreeNode image(TreeNode rootNode) {
        //二叉树左右变换位置操作
        TreeNode tmp = rootNode.getLeftNode();
        rootNode.setLeftNode(rootNode.getRightNode());
        rootNode.setRightNode(tmp);
        if (rootNode.getLeftNode() != null) {
            image(rootNode.getLeftNode());
        }
        if (rootNode.getRightNode() != null) {
            image(rootNode.getRightNode());
        }
        return rootNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = InitBinaryTree.initSimpleTree();
        //首先先序遍历初始的二叉树
        SearchByRecursion searchByRecursion = new SearchByRecursion();
        System.out.print("初始时先序遍历:");
        searchByRecursion.firstSerach(treeNode);
        BinaryTreeImage_19 binaryTreeImage = new BinaryTreeImage_19();
        TreeNode node = binaryTreeImage.image(treeNode);
        //将左右对调过的
        System.out.print("结束时先序遍历:");
        searchByRecursion.firstSerach(node);
    }
}
