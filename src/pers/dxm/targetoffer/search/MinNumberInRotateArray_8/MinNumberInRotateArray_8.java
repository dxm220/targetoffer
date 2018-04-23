package pers.dxm.targetoffer.search.MinNumberInRotateArray_8;

/**
 * Created by douxm on 2018\4\12 0012.
 * title:旋转数组的最小数字
 */
public class MinNumberInRotateArray_8 {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        //确保能旋转
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            //若出现这种｛1，1，1，0，1｝,无法确定中间元素是属于前面还是后面的递增子数组,需要从头到尾顺序遍历找到最小值
            if (array[left] == array[right] && array[left] == array[middle]) {
                return MinOrder(array, left, right);
            }
            //如果中间元素大于最左边元素，说明最小数目标在后面的子序列；如果中间元素小于最左边元素，说明最小数目标在前面的子序列
            if (array[middle] >= array[left]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return array[middle];
    }

    public static int MinOrder(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left + 1; i < right; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinNumberInRotateArray_8 minNumberInRotateArray = new MinNumberInRotateArray_8();
        int[] array = {5, 6, 7, 8, 2, 3};
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(array));
    }
}
