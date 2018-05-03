package pers.dxm.targetoffer.stack.PopMinStack_21;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: dxm
 * Date: 2018\5\3 0003
 * Time: 12:51
 * title:包含min函数的栈
 * viewpoint:既然要在o(1)时间内得到栈中最小的元素，且在o(1)时间内执行pop和push操作
 * 所以说不能破坏栈的已有特性（因为栈本身执行pop和push操作的时间复杂度就是o(1)）
 * 要想实现o(1)内得到栈中最小的元素，每次push元素后都要比较push的元素与上次push完成后栈中最小元素
 * 如果前者小于后者，将前者压入辅助栈；如果前者大于后者，将后者压入辅助栈（详细过程看兼职offer第132页表格）
 */
public class PopMinStack_21 {
    Stack<Integer> stack1 = new Stack<>();//原始栈
    Stack<Integer> stack2 = new Stack<>();//辅助栈

    //将元素压入原始栈的同时，将最小值压入辅助栈（最小值的确定需要比较后判断）
    public void push(int num) {
        if (stack1.empty() && stack2.empty()) {
            stack1.push(num);
            stack2.push(num);
        }
        int min = stack2.pop();
        if (num < min) {//待push元素小于辅助栈的栈顶元素
            stack1.push(num);
            stack2.push(num);
        } else if (num > min) {//待push元素大于辅助栈的栈顶元素
            stack1.push(num);
            stack2.push(min);
        } else {//待push元素等于辅助栈的栈顶元素
            stack1.push(num);
            stack2.push(num);
        }
    }

    //原始栈弹出栈顶元素的同时，辅助栈内最小的元素将被弹出
    public int pop() {
        stack1.pop();
        return stack2.pop();
    }

    public static void main(String[] args) {
        PopMinStack_21 popMinStack_21 = new PopMinStack_21();
        popMinStack_21.push(1);
        popMinStack_21.push(1);
        popMinStack_21.push(2);
        popMinStack_21.push(3);
        popMinStack_21.push(4);
        System.out.println(popMinStack_21.pop());
    }
}

