package pers.dxm.targetoffer.search.Search_basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by douxm on 2018\4\10 0010.
 * title:分块查找（索引顺序查找）
 * pointview:索引表有两种形式，一种是索引表每块对应固定数量的元素，最后一块对应的元素可以数量不足
 * 另一种是索引表每块对应的元素数量是随机不固定的。但是无论固定还是不固定，待排序数组必须满足能够创建索引表的条件
 * 即都要满足前一块中最大的元素小于后一块中最小的元素
 */
public class BlockSearch {
    //创建索引表（顺序查找找到每个块中最大的数）
    public static int[] initIndexTable(int[] array, int gap) {
        //初始化索引表
        int[] chunkArray = new int[(array.length / gap) + 1];
        int index = 0;//索引表的下标
        //将数组分块拆开选出每个块中最大的元素放入索引表中
        for (int i = 0; i < array.length; i += gap) {
            int max = array[i];
            for (int j = 0; j < gap; j++) {
                if ((Integer) array[i + j] != null && array[i + j] > max) {
                    max = array[i + j];
                }
            }
            chunkArray[index] = max;
            index++;
        }
        return chunkArray;
    }

    //根据searchNumber确定索引块（顺序查找）,在对应块内进行值的精确查询（顺序查找）
    public static int getChunk(int[] array, int SearchNumber) {
        int[] chunkArray = initIndexTable(array, 4);//手动设定索引块的大小为4
        int chunkIndex = -1;
        //将待查询元素与索引表比较，确定索引块位置
        for (int i = 0; i < chunkArray.length; i++) {
            if (i == 0 && chunkArray[i] >= SearchNumber) {
                chunkIndex = i;
                break;
            }
            if (chunkArray[i + 1] >= SearchNumber && chunkArray[i] <= SearchNumber) {
                chunkIndex = i + 1;
                break;
            }
        }
        if (chunkIndex == -1) {
            return -1;
        }
        //创建临时数组，将索引块对应的元素放到临时数组中进行顺序查询
        int[] temp = new int[4];
        for (int j = 0; j < 4; j++) {
            if ((Integer) array[4 * chunkIndex + j] != null) {
                temp[j] = array[4 * chunkIndex + j];
            }
        }
        //对temp进行顺序查找，找到匹配值返回，没有的话返回-1
        for (int k = 0; k < temp.length; k++) {
            if (temp[k] == SearchNumber) {
                return 4 * chunkIndex + k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 7, 9, 12, 11, 10, 32, 56, 63, 53};
        System.out.println(getChunk(array, 3));
    }
}
