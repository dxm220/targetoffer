package pers.dxm.targetoffer.search.JumpFloor_9;

/**
 * Created by douxm on 2018\4\13 0013.
 * title:青蛙跳台阶
 */
public class JumpFloor {

    //按题意推理一下步骤，可以得出如下规律：(格式为：台阶数——方案)
    //1——1；
    //2——2；2——1+1；
    //3——1+1+1；3——1+2；3——2+1；
    //4——2+1+1；4——1+2+1；4——1+1+2；4——1+1+1+1；4——2+2；
    //5——2+2+1；5——2+1+2；5——1+2+2；5——2+1+1+1；5——1+2+1+1；5——1+1+2+1；5——1+1+1+2；5——1+1+1+1+1；
    //从上面的排列可以看出，n正好形成一个斐波那契数列，所以说问题就变成求斐波那契数列的第n项
    public int jumpFloor(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        int number1 = array[0];
        int number2 = array[1];
        int number3 = 0;
        if (n > 2) {
            for (int i = 2; i < array.length; i++) {
                number3 = number1 + number2;
                number1 = number2;
                number2 = number3;
            }
        }
        return number3;
    }

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.jumpFloor(6));
    }
}
