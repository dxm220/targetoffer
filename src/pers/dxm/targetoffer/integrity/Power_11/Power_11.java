package pers.dxm.targetoffer.integrity.Power_11;

/**
 * Created by IntelliJ IDEA.
 * User: dxm
 * Date: 2018\4\17 0017
 * Time: 14:19
 * title:数值的整数次方
 * pointview:该题考察对问题思考的完整性，幂次方要考虑正，0，负三种情况(正常思考)
 * 另外一种思考方式：比如说2的7次方，7表示成二进制为0111，然而7次方=4次方*2次方*1次方
 * 即2^0111=2^0100*2^0010*2^0001，可以想到之前的一个题用0001挨个往左移动做与运算，
 * 结果为1的则表示原数该位为1
 */
public class Power_11 {
    public double power1(double base, int exponent) {
        int result = 1;
        if (exponent > 0) {//幂次方大于0时
            for (int i = 0; i < exponent; i++) {
                result *= base;
                if (result > 1.7976931348623157E308) {
                    System.out.println("结果已越界，请重新计算");
                    return -1;
                }
            }
            return result;
        } else if (exponent < 0) {//幂次方小于0时
            for (int i = 0; i < Math.abs(exponent); i++) {
                result *= base;
                if (result > 1.7976931348623157E308) {
                    System.out.println("结果已越界，请重新计算");
                    return -1;
                }
            }
            return 1.0 / result;
        } else {//幂次方等于0时
            return 1;
        }
    }

    //用与运算的方式实现
    public double power2(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        double result = 1;
        int index = 1;
        int flag = index & Math.abs(exponent);
        while (index < Math.abs(exponent)) {
            if (flag != 0) {
                result *= base;
            }
            base *= base;
            index <<= 1;
            flag = index & Math.abs(exponent);
        }
        return exponent > 0 ? result : 1.0 / result;
    }


    public static void main(String[] args) {
        Power_11 power_11 = new Power_11();
        System.out.println(power_11.power2(5.0, -3));
    }

}
