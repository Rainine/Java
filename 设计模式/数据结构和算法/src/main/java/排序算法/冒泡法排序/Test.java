package 排序算法.冒泡法排序;

import java.util.Arrays;

/**
 * @author lxy
 * @date 2020/12/19 16:20
 **/
public class Test {

    public static void main(String[] args) {

        /**冒泡法排序:
         *  相邻两个做比较,以本案例为例子,
         *  前一个比后一个大的话则进行交换
         *  否则不进行交换
         * */

         /**测量的数据10秒*/
        int arg[] = new int[80000];
//        for (int a = 0; a < 80000; a++) {
//            arg[a] = (int) (Math.random() * 80000);
//        }
      //  sortArray(arg);
        System.out.println("***************小数据量测试****************");
        // int arr[] = {24, 6, 8, 10, 1, 3, 5, 7, 9};
        int arr[] = {24, 6, 8, 10, 1, 3, 5, 7, 9,0};
        //int arr[] = {1, 2, 3,5,4, 6, 7, 8, 9};
        boolean flag = false;
        int tmp = 0;
        long start = System.currentTimeMillis();
        int num=0;
        for (int j = 0; j < arr.length; j++) {
            System.out.println("第" + (1 + j) + "轮比较");
            for (int i = 0; i < arr.length - j - 1; i++) {
                num++;
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
                System.out.println(Arrays.toString(arr)+"执行了"+num+"次");
            }
            /**做一个简单的优化:如果某一个进行比较一次都没有交换数据
             * 则证明这个数组已经有序,则无需再进行排序
             **/
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("排序所花时间:" + (end - start) / 1000 + "秒"+num);
        System.out.println("最终结果");
        System.out.println(Arrays.toString(arr));
    }
     /**测试大数据用并计算所需要的排序时间*/
    public static void sortArray(int arr[]) {
        int tmp = 0;
        long start = System.currentTimeMillis();
        /**做一个简单的优化:如果某一个进行比较一次都没有交换数据
         * 则证明这个数组已经有序,则无需再进行排序
         **/
        boolean flag = false;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - j - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            /**做一个简单的优化:如果某一个进行比较一次都没有交换数据
             * 则证明这个数组已经有序,则无需再进行排序
             **/
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("排序所花时间:" + (end - start) / 1000 + "秒");
    }

}
