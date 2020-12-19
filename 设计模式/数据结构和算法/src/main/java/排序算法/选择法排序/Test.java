package 排序算法.选择法排序;

import java.util.Arrays;

/**
 * @author lxy
 * @date 2020/12/19 17:01
 **/
public class Test {

    public static void main(String[] args) {
        /**选择法排序:
         * 每一个位置上的数和它后面的数做一次对比
         * 如果比后面的数小或者大则进行一次交换
         *
         * */
        /**测量大数据(3秒)*/
        int arg[]=new int[80000];
        for(int p=0;p<8000;p++){
            arg[p]=(int)(Math.random()*80000);
        }
        sortSelect(arg);
        System.out.println("测量小数据");

        int arr[] = {1,2,3,8,10,4,5,6,7,9};
        int tep =0;
         boolean flag = false;
        for(int i=0;i<arr.length;i++){
            System.out.println("第"+(1+i)+"轮");
            int j;
            for(j=i;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    flag = true;
                    tep=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tep;
                }
                System.out.println(Arrays.toString(arr)+":"+j);
            }
        }
        System.out.println("最终结果");
        System.out.println(Arrays.toString(arr));
    }
    public  static  void  sortSelect(int arr[]){
        long start = System.currentTimeMillis();
        int tep =0;
        for(int i=0;i<arr.length;i++){
            int j;
            for(j=i;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    tep=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tep;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000+"秒");
    }

}
