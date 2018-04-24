package pers.dxm.targetoffer.binarytree.HasSubtree_18;

import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: dxm
 * Date: 2018\4\24 0024
 * Time: 11:08
 * title:树的子结构
 * viewpoint:先递归找到A树中与B树根节点相同的节点，然后再将A子树与B树进行节点递归比较
 * 直到比较到子树为空时，证明B是A的子树。
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.getData() == root2.getData()) {
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = hasSubtree(root1.getLeftNode(), root2);
            }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = hasSubtree(root1.getRightNode(), root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.getData() != node2.getData()) {
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.getLeftNode(), node2.getLeftNode())
                && doesTree1HaveTree2(node1.getRightNode(), node2.getRightNode());
    }
}
