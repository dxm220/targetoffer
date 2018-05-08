package pers.dxm.targetoffer.binarytree.FindPath_25;

import pers.dxm.targetoffer.binarytree.BinaryUtils.TreeNode;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: dxm
 * Date: 2018\5\8 0008
 * Time: 16:06
 * title:二叉树中和为某一值得路径
 * viewpoint:利用递归本身的特性（入栈和出栈），如果某个节点有左子树，先一条黑走左子树走到底（叶子结点），判断这条路的和是否等于target
 * 如果不等的话，再按原路往上回，回到父节点时，看父节点有没有右子树，如果有的话再走到右子树继续先左后右的累加判断过程，直到整个树走完为止
 * （详细过程看剑指offer144页过程表）
 */
public class FindPath_25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return arr;
        ArrayList<Integer> a1=new ArrayList<Integer>();
        int sum=0;
        path(root,target,arr,a1,sum);
        return arr;
    }
    public void path(TreeNode root,int target,ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1,int sum){
        if(root==null){
            return;
        }
        sum+=root.getData();

        if(root.getLeftNode()==null&&root.getRightNode()==null){
            if(sum==target) {
                a1.add(root.getData());
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size()-1);
            }
            return;
        }
        a1.add(root.getData());
        path(root.getLeftNode(),target,arr,a1,sum);
        path(root.getRightNode(),target,arr,a1,sum);
        a1.remove(a1.size()-1);

    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(7,null,null);
        TreeNode node3 = new TreeNode(4,null,null);
        TreeNode node2 = new TreeNode(12,null,null);
        TreeNode node1 = new TreeNode(5,node3,node4);
        TreeNode root = new TreeNode(10,node1,node2);
        FindPath_25 findPath_25 = new FindPath_25();
        ArrayList<ArrayList<Integer>> list = findPath_25.FindPath(root,22);
        for(int i = 0;i<list.size();i++){
            for(int j = 0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j)+";");
            }
            System.out.println();
        }
    }
}
