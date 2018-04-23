package pers.dxm.targetoffer.stack.StackToQueue_7;

import java.util.Stack;

/**
 * Created by douxm on 2018\4\2 0002.
 * title：用两个栈实现队列
 * viewpoint：队列是先进先出，栈是先进后出；push时放入stack1,pop时先把stack1中的元素全部压入stack2
 * 然后从stack2中pop出第一个元素，再将stack2中剩下的元素再次push到stack1中，下次pop操作时重新执行该操作
 */
public class TwoStackToQueue_7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //队列的push操作
    public void push(int node) {
        stack1.push(node);
    }

    //队列的pop操作
    public int pop() {
        //pop之前先把stack1中的元素全部压入stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int first = stack2.pop();
        //pop完以后把stack2中的元素再全压入stack1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }

    public static void main(String[] args) {
        TwoStackToQueue_7 twoStackToQueue = new TwoStackToQueue_7();
        twoStackToQueue.push(1);
        twoStackToQueue.push(2);
        twoStackToQueue.push(3);
        System.out.println(twoStackToQueue.pop());
        System.out.println(twoStackToQueue.pop());
        System.out.println(twoStackToQueue.pop());
    }
}
