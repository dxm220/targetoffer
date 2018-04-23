package pers.dxm.targetoffer.search.Search_basic;

/**
 * Created by douxm on 2018\4\9 0009.
 * title:顺序查找
 * viewpoint:遍历序列，找到匹配的数返回，没找到返回错误信息
 */
public class LinearSearch {
    public int search(int[] array, int searchNumber) {
        for (int index = 0; index < array.length; index++) {
            if (searchNumber == array[index]) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int[] array = {4, 5, 2, 6, 8, 1, 3};
        System.out.println(linearSearch.search(array,6));
    }
}
