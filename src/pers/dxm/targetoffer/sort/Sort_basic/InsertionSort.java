package pers.dxm.targetoffer.sort.Sort_basic;

/**
 * Created by douxm on 2018\4\9 0009.
 * title:插入排序
 */
public class InsertionSort {
    public void sort(int[] array) {
        int num = array.length;//待排数列的长度
        int temp;
        for (int i = 1; i < num; i++) {
            //从待排数列中取出第一个数，依次往前比较，若该数小于已排序列的数则替换，依次往前类推
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {4, 2, 1, 3, 7, 5, 8, 6, 9};
        insertionSort.sort(array);
        for (int i : array) {
            System.out.print(i + ";");
        }
    }
}
