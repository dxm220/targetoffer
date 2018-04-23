package pers.dxm.targetoffer.binarytree.BinaryTreeNextNode;
import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by douxm on 2018\3\5 0005.
 * title：二叉树的下一个节点
 * viewpoint：根据中序遍历的特点，要想找已知节点的下一个节点，下一个节点一定在已知节点的右子节点的某个左子节点上
 */
public class BinaryTreeNextNode {
    public void search(TreeNode treeNode){
        if(treeNode.getRightNode()!=null){
            treeNode = treeNode.getRightNode();
            System.out.println(getLeftNode(treeNode).getData());
        }
    }

    public TreeNode getLeftNode(TreeNode node){
        while(node.getLeftNode()!=null){
            return node.getLeftNode();
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = InitBinaryTree.initSimpleTree();
        BinaryTreeNextNode binaryTreeNextNode = new BinaryTreeNextNode();
        binaryTreeNextNode.search(node);
    }
}
