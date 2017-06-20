package algorithm.qsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hzwangqiqing
 * on 2017/6/20.
 */
public class Qsort<T extends Comparable> {
    public void quickSort(List<T> array, Integer left, Integer right) {
        if (left >= right) {
            return;
        }
        Integer tempLeft = left;
        Integer tempRight = right;
        T pivot = array.get(left);
        while (true) {
            //从右侧找到一个比他小的，否则一直递减
            while (right > left && array.get(right).compareTo(pivot) > 0) {
                right--;
            }
            if (right > left) {
                array.set(left, array.get(right));
            }
            //从左侧一直找到一个比他大的，否则一直递增
            while (right > left && array.get(left).compareTo(pivot) < 0) {
                left++;
            }
            if (right > left) {
                array.set(right, array.get(left));
            }
            if (left >= right) {
                quickSort(array, tempLeft, left - 1);
                quickSort(array, left + 1, tempRight);
                array.set(left, pivot);
                return;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer i = 0; i < 20; i++) {
            list.add(new Random().nextInt(100));
        }
        System.out.println(list);
        new Qsort<Integer>().quickSort(list, 0, list.size() - 1);
        System.out.println(list);
    }
}
