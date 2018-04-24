package pers.dxm.targetoffer.binarytree.SerializeBinaryTree;

import pers.dxm.targetoffer.binarytree.BinaryTreeSearch.SearchByRecursion;
import pers.dxm.targetoffer.binarytree.BinaryUtils.InitBinaryTree;
import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by douxm on 2018\3\8 0008.
 * title：序列化二叉树
 * viewpoint：序列化二叉树就是将二叉树转换成一个字符串序列，空的地方用#代替
 * 反序列化二叉树就是将String字符串恢复成一个二叉树（所以说序列化时得按照一定的格式规范来操作，否则无法进行反序列化）
 */
public class SerializeBinaryTree {

    int index = -1;//反序列化到第n个节点

    public String Serialize(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Serialize2(node, sb);
        return sb.toString();
    }

    //递归序列化所有节点
    public void Serialize2(TreeNode node, StringBuffer sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.getData());
        sb.append(",");
        Serialize2(node.getLeftNode(), sb);
        Serialize2(node.getRightNode(), sb);
    }

    public TreeNode deSerialize(String string) {
        if (string.length() == 0) {
            return null;
        }
        String[] str = string.split(",");
        return deSerialize2(str);
    }

    //递归反序列化所有节点
    public TreeNode deSerialize2(String[] str) {
        index++;
        if (!str[index].equals("#")) {
            TreeNode node = new TreeNode(Integer.parseInt(str[index]), null, null);
            node.setLeftNode(deSerialize2(str));
            node.setRightNode(deSerialize2(str));
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        TreeNode node = InitBinaryTree.initSimpleTree();
        String serialize = serializeBinaryTree.Serialize(node);
        System.out.println(serialize);
        TreeNode treeNode = serializeBinaryTree.deSerialize(serialize);
        SearchByRecursion searchByRecursion = new SearchByRecursion();
        System.out.print("反序列化后先序遍历:");
        searchByRecursion.firstSerach(treeNode);
    }
}
