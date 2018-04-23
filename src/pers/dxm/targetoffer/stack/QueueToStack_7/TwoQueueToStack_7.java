package pers.dxm.targetoffer.stack.QueueToStack_7;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by douxm on 2018\4\3 0003.
 * title：用两个队列实现栈
 * viewpoint：
 */
public class TwoQueueToStack_7 {
    public Queue<Integer> queue1 = new PriorityQueue<>();
    public Queue<Integer> queue2 = new PriorityQueue<>();

    public void push(Integer node) {
        queue1.add(node);
    }

    public Integer pop() {
        //将queue1中除对尾外的所有元素放入queue2
        while (queue1.size() != 1) {
            queue2.add(queue1.poll());
        }
        //返回queue1对尾的元素，即最后被压入的元素（模拟栈后入先出的原则）
        Integer result = queue1.poll();
        //将queue2中的元素再压入queue1
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        TwoQueueToStack_7 twoQueueToStack_7 = new TwoQueueToStack_7();
        twoQueueToStack_7.push(1);
        twoQueueToStack_7.push(2);
        twoQueueToStack_7.push(3);
        System.out.println(twoQueueToStack_7.pop());
        System.out.println(twoQueueToStack_7.pop());
        System.out.println(twoQueueToStack_7.pop());
    }
}
