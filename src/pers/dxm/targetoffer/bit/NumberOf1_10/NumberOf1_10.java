package pers.dxm.targetoffer.bit.NumberOf1_10;

/**
 * Created by douxm on 2018\4\13 0013.
 * title:二进制中1的个数
 */
public class NumberOf1_10 {
    //从目标数字拿1挨个左移与目标数做与运算，因为与运算只有1&1=1，由此可以判断目标数字哪位是1哪位是0
    private static int NumberOf1_low(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        //使用n=10,二进制形式为1010，则1的个数为2；
        int n = -10;
        System.out.println(n + "的二进制中1的个数：" + NumberOf1_low(n));
        System.out.println(1&7);
    }
}
