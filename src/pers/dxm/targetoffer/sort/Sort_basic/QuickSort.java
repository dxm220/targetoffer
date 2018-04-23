package pers.dxm.targetoffer.sort.Sort_basic;

/**
 * Created by douxm on 2018\4\3 0003.
 * title:快速排序
 * viewpoint:
 */
public class QuickSort {
    public void sort(int[] array, int lo, int hi) {
        int temp;
        int start = lo;
        int end = hi;
        if (lo > hi) {
            return;
        }
        //设置基准值为第一个数
        //如果设置第一个数是基准数，先从后往前找再从前往后找
        //如果设置最后一个数是基准数，先从前往后找再从后往前找
        int base = array[lo];
        //如果lo<hi说明第一趟排序还没有结束,当lo=hi时，第一趟排序结束，数列被分为左右两个子数列
        //左子数列皆小于base，右子数列皆大于base
        while (lo < hi) {
            //从后往前找，如果都大于base的话，hi索引往前走
            while (lo < hi && array[hi] > base) {
                hi--;
            }
            //当跳出while循环时说明已经满足array[hi]<base,此时就要进行交换
            temp = array[hi];
            array[hi] = array[lo];
            array[lo] = temp;
            //从前往后找，如果都小于base的话，lo索引往后走
            while (lo < hi && array[lo] < base) {
                lo++;
            }
            //当跳出while循环时说明已经满足array[lo]>base,此时就要进行交换
            temp = array[lo];
            array[lo] = array[hi];
            array[hi] = temp;
        }
        //递归遍历base左右两个子数列
        sort(array, start, lo - 1);
        sort(array, lo + 1, end);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {4, 2, 1, 3, 7, 5, 8, 6, 9};
        quickSort.sort(array, 0, 8);
        for (int i : array) {
            System.out.print(i + ";");
        }
    }
}
