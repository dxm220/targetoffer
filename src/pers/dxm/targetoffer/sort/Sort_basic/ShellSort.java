package pers.dxm.targetoffer.sort.Sort_basic;

/**
 * Created by douxm on 2018\4\9 0009.
 */
public class ShellSort {

    public void sort(int[] array) {
        int temp;
        //增量选取为数组长度递归除以二
        for (int increment = array.length / 2; increment > 0; increment /= 2) {
            //从增量位开始依次往右挪动1位
            for (int j = increment; j < array.length; j++) {
                //拆分后的数组采用插入排序
                for (int k = j; k - increment >= 0; k -= increment) {
                    if (array[k] < array[k - increment]) {
                        temp = array[k];
                        array[k] = array[k - increment];
                        array[k - increment] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = {4, 2, 1, 3, 7, 5, 8, 6, 9};
        shellSort.sort(array);
        for (int i : array) {
            System.out.print(i + ";");
        }
    }
}
