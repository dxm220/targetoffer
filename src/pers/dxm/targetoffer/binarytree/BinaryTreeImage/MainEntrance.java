package pers.dxm.targetoffer.binarytree.BinaryTreeImage;

import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by douxm on 2018\3\1 0001.
 */
public class MainEntrance {
    public static void resursionInit(){
        SearchByRecursion search = new SearchByRecursion();
        TreeNode treeNode = InitBinaryTree.initSimpleTree();
        System.out.print("先序遍历:");
        search.firstSerach(treeNode);
        System.out.println();
        System.out.print("中序遍历:");
        search.middleSerach(treeNode);
        System.out.println();
        System.out.print("后序遍历:");
        search.lastSerach(treeNode);
    }

    public static void printNode(TreeNode node) {
        System.out.print(node.getData() + ";");
    }
}
