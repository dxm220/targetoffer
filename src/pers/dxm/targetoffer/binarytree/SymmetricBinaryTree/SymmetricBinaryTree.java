package pers.dxm.targetoffer.binarytree.SymmetricBinaryTree;

import pers.dxm.targetoffer.binarytree.BinaryTreeImage.BinaryTreeImage;
import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by douxm on 2018\3\5 0005.
 * title：对称的二叉树
 * viewpoint：将传入的二叉树与其镜像二叉树进行先序遍历（什么序遍历都可以），如果遍历的结果一样就说明是对称的
 */
public class SymmetricBinaryTree {
    public boolean isSymmetrical(TreeNode node) {
        BinaryTreeImage binaryTreeImage = new BinaryTreeImage();
        //这里需要重新构建一棵树传给image方法返回镜像树，不能直接将node作为参数直接传给image方法进行镜像转换（即不能在node本身上进行任何修改）
        //下面三行代码是将node复制给一个新的Treenode
        TreeNode treeNode = new TreeNode(node.getData(),null,null);
        treeNode.setLeftNode(node.getLeftNode());
        treeNode.setRightNode(node.getRightNode());
        //将复制后的treenode进行镜像处理返回
        TreeNode imageNode = binaryTreeImage.image(treeNode);
        if (leftTree(node, imageNode) && rightTree(node, imageNode)) {
            return true;
        }
        return false;
    }

    public boolean leftTree(TreeNode node, TreeNode imageNode) {
        while (node.getLeftNode() != null && imageNode.getLeftNode() != null) {
            if (node.getLeftNode().getData() == imageNode.getLeftNode().getData()) {
                node = node.getLeftNode();
                imageNode = imageNode.getLeftNode();
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean rightTree(TreeNode node, TreeNode imageNode) {
        while (node.getRightNode() != null && imageNode.getRightNode() != null) {
            if (node.getRightNode().getData() == imageNode.getRightNode().getData()) {
                node = node.getRightNode();
                imageNode = imageNode.getRightNode();
            } else {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        SymmetricBinaryTree symmetricBinaryTree = new SymmetricBinaryTree();
        TreeNode node = InitBinaryTree.initImageTree();
        System.out.println(symmetricBinaryTree.isSymmetrical(node));
    }

}
