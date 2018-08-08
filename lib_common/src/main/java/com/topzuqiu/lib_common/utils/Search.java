package com.topzuqiu.lib_common.utils;

import java.util.Arrays;

/**
 * Created by rocky on 2018/8/8.
 */

public class Search {

    /**
     * 二分法查找
     *
     * @param args
     * @param target
     * @return
     */
    public static int binearSearch(int[] args, int target) {
        Arrays.sort(args);
        int start = 0;
        int end = args.length - 1;
        int result = -1;
        while (start <= end) {
            int miidol = (start + end) / 2;
            if (args[miidol] == target) {
                return miidol;
            }
            if (args[miidol] > target) {
                end = miidol;
            }
            if (args[miidol] < target) {
                start = miidol;
            }
        }
        return result;
    }

    /**
     * 冒泡排序
     * <p>
     * 它重复地走访过要排序的元素列，一次比较两个相邻的元素，
     * 如果他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来。
     * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素已经排序完成。
     *
     * @param args
     */
    public static void bubbleSort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length - i - 1; j++) {
                if (args[j] > args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {

        int[] array = {1, 3, 5, 7, 9, 10, 15, 20, 34, 67};
        int search = binearSearch(array, 15);
        System.out.println(search);

        int[] arrays = {7, 67, 9, 20, 1, 5, 15, 34, 10, 3};
        bubbleSort(arrays);
        System.out.println(arrays[0] + " " + arrays[9]);
    }
}
