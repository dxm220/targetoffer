package pers.dxm.targetoffer.sort.Sort_basic;

/**
 * Created by douxm on 2018\4\3 0003.
 * title:冒泡排序
 * viewpoint:每一趟排序从前往后挨个比较，找到一个最大的放到数列末段
 * 这样每趟都能把待排数列中最大的元素放到最后，下一次比较时待排数列中就少一个数
 * 以此类推，直到待排数列中只有一个数时（该数一定是最小数或者最大数），排序完毕
 */
public class BubbleSort {
    //从前往后比较，每一趟减少一个最大的比较数
    public int[] bubbleSort1(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
    //从后往前比较，每一趟减少一个最大的比较数
    public int[] bubbleSort2(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {4, 5, 2, 6, 8, 1, 3};
        int[] SortedArray = bubbleSort.bubbleSort2(array);
        for (int i = 0; i < SortedArray.length; i++) {
            System.out.print(SortedArray[i] + ";");
        }
    }
}
