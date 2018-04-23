package pers.dxm.targetoffer.list;

/**
 * Created by douxm on 2018\4\2 0002.
 */
public class ListNode {
    private int value;
    private ListNode nextNode;

    public ListNode(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
