package pers.dxm.targetoffer.stack.IsPopOrder_22;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: dxm
 * Date: 2018\5\4 0004
 * Time: 9:28
 * title:栈的压入，弹出序列
 * viewpoint:借用一个辅助的栈，遍历压栈顺序，先将第一个放入栈中，然后判断栈顶元素是不是出栈顺序的第一个元素
 * 如果不相等，继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，
 * 如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
 * 举例：入栈1,2,3,4,5；出栈4,5,3,2,1
 * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
 * 此时栈顶2≠4，继续入栈3
 * 此时栈顶3≠4，继续入栈4
 * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
 * 此时栈顶3≠5，继续入栈5
 * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
 * 依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
 */
public class IsPopOrder_22 {
    public boolean ispoporder(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack();
        //用于标识弹出序列的位置
        int popIndex = 0;
        //将push序列依次入栈比较，直到push序列全部出栈完成，判断pop序列索引是否移动到最后
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while (!stack.empty() && stack.peek() == pop[popIndex]) {
                stack.pop();//出栈
                popIndex++;//弹出序列向后一位
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        IsPopOrder_22 isPopOrder_22 = new IsPopOrder_22();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 2, 5, 3, 1};
        System.out.println(isPopOrder_22.ispoporder(push,pop));
    }
}
