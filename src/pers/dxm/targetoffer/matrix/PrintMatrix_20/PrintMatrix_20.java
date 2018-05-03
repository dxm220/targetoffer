package pers.dxm.targetoffer.matrix.PrintMatrix_20;

import java.util.ArrayList;

/**
 * Created by douxm on 2018\4\26 0026.
 * title:顺时针打印矩阵
 * viewpoint:定义四个角的位置，每转一圈四个角的位置做相应的缩小处理，直到四个角的数据重合为止。
 */
public class PrintMatrix_20 {
    public ArrayList<Integer> printMatrix(int[][] martix) {
        //如果矩阵非法，直接返回
        if (martix.length == 0) {
            return null;
        }
        //初始化矩阵四个角的下标位置
        int left = 0, right = martix.length - 1, top = 0, bottom = martix[0].length - 1;
        //初始化返回的list
        ArrayList<Integer> result = new ArrayList<>();
        while (left <= right && top <= bottom) {//该条件限制住跳出循环时只剩下一个元素
            //从左到右
            for (int i = left; i <= right; i++) {
                result.add(martix[top][i]);
            }
            //从上到下
            for (int i = top + 1; i <= bottom; i++) {
                result.add(martix[i][right]);
            }
            //从右到左
            for (int i = right - 1; i >= left; i--) {
                result.add(martix[bottom][i]);
            }
            //从下到上
            for (int i = bottom - 1; i >= top + 1; i--) {
                result.add(martix[i][left]);
            }
            left += 1;
            right -= 1;
            top += 1;
            bottom -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] martix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        PrintMatrix_20 printMatrix_20 = new PrintMatrix_20();
        ArrayList<Integer> list = printMatrix_20.printMatrix(martix);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ";");
        }

    }
}
