package pers.dxm.targetoffer.binarytree.BinaryUtils;

import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by douxm on 2018\3\5 0005.
 */
public class InitBinaryTree {

    //初始化普通二叉树
    public static TreeNode initSimpleTree() {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;   //返回二叉树的根节点
    }

    //初始化搜索二叉树
    public static TreeNode initSearchTree() {
        TreeNode J = new TreeNode(5, null, null);
        TreeNode I = new TreeNode(3, null, null);
        TreeNode H = new TreeNode(1, null, null);
        TreeNode G = new TreeNode(10, null, null);
        TreeNode F = new TreeNode(8, null, null);
        TreeNode E = new TreeNode(6, J, null);
        TreeNode D = new TreeNode(2, H, I);
        TreeNode C = new TreeNode(9, F, G);
        TreeNode B = new TreeNode(4, D, E);
        TreeNode A = new TreeNode(7, B, C);
        return A;
    }

    //初始化镜像二叉树
    public static TreeNode initImageTree() {
        TreeNode G = new TreeNode(3, null, null);
        TreeNode F = new TreeNode(3, null, null);
        TreeNode E = new TreeNode(3, null, null);
        TreeNode D = new TreeNode(3, null, null);
        TreeNode C = new TreeNode(2, F, G);
        TreeNode B = new TreeNode(2, D, E);
        TreeNode A = new TreeNode(1, B, C);
        return A;
    }
}
