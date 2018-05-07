package pers.dxm.targetoffer.binarytree.VerifySquenceOfBST_24;

/**
 * Created by IntelliJ IDEA.
 * User: dxm
 * Date: 2018\5\7 0007
 * Time: 16:03
 * title:二叉搜索树的后序遍历序列
 * viewpoint:以后序遍历序列{5,7,6,9,11,10,8}为例，二叉搜索树的后序遍历的最后一个数一定是根节点，
 * 又因为二叉搜索树根节点的左子树都小于根节点，右子树都大于根节点。后序遍历序列可以分为两部分，前半部分肯定是左子树，后半部分肯定是右子树
 * 所以说只需要判断前半部分的值是否都小于根节点，后半部分是否都大于根节点即可。同理可以递归对各级别子树进行判断。
 * 5,7,6都小于8;9,11,10都大于8;递归到左右子树，5小于6;7大于6;9小于10;11大于10，所以说以上序列是二叉搜索树的后序遍历序列
 */
public class VerifySquenceOfBST_24 {
    public boolean VerifySquenceOfBST(int[] squence) {
        if (squence.length == 0) {
            return false;
        }
        return IsTreeBST(squence, 0, squence.length - 1);
    }

    public boolean IsTreeBST(int[] squence, int start, int end) {
        //如果end<=start说明递归完毕，直接返回true
        if (end <= start) {
            return true;
        }
        int i = start;
        //找到左右子树的分界点
        for (; i < end; i++) {
            if (squence[i] > squence[end]) {
                break;
            }
        }
        //如果右子树有小于根节点的，返回false
        for (int j = i; j < end; j++) {
            if (squence[j] < squence[end]) {
                return false;
            }
        }
        //递归判断子树
        return IsTreeBST(squence, start, i - 1) && IsTreeBST(squence, i, end - 1);
    }

    public static void main(String[] args) {
        int[] squence = {5, 7, 6, 9, 11, 10, 8};
        int[] squence2 = {5, 7, 6, 9, 11, 3, 8};
        VerifySquenceOfBST_24 verifySquenceOfBST_24 = new VerifySquenceOfBST_24();
        System.out.println(verifySquenceOfBST_24.VerifySquenceOfBST(squence2));
    }
}
