package pers.dxm.targetoffer.array.ReOrderArray_14;

/**
 * Created by douxm on 2018\4\19 0019.
 * title:调整数组顺序使奇数位于偶数前面
 * pointview:使用两个指针分别从前往后走和从后往前走，当满足正序指针遇到偶数，倒叙指针遇到奇数时，两数交换，直到两指针相遇
 */
public class ReOrderArray_14 {
    public void soulution(int[] array) {
        int first = 0;//正序指针
        int last = array.length - 1;//倒序指针
        int num = 0;
        int index1 = 0, index2 = 0;
        while (last - first >= 1) {
            int a = 0, b = 0;
            if (array[first] % 2 == 0) {
                System.out.println("第" + (index1 + 1) + "个需要交换的偶数的索引位置是第" + first + "位");
                a = array[first];
                num++;
            } else {
                first++;
            }
            if (array[last] % 2 == 1) {
                System.out.println("第" + (index2 + 1) + "个需要交换的奇数的索引位置是第" + last + "位");
                b = array[last];
                num++;

            } else {
                last--;
            }
            if (a != 0 && b != 0 && num == 2) {
                array[first] = b;
                array[last] = a;
                num = 0;
                index1++;
                index2++;
            } else {
                num = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13};
        ReOrderArray_14 reOrderArray_14 = new ReOrderArray_14();
        reOrderArray_14.soulution(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ";");
        }
    }
}
