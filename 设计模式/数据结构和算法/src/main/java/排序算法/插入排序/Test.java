package 排序算法.插入排序;

import java.util.Arrays;
import javax.swing.GroupLayout.ParallelGroup;

/**
 * @author lxy
 * @date 2020/12/19 18:14
 **/
public class Test {

    public static void main(String[] args) {

        /**大数据量*/
//        int arg[] = new int[80000];
//        for(int j=0;j<80000;j++){
//            arg[j] = (int)(Math.random()*80000);
//        }
    //    sortInsert(arg);
        /**小数据量*/
        int arr[] = {4,3,1,7,9,2,5,6,8,10};
        /**for循环+while()循环*/
//        for(int i=1;i<arr.length;i++){
//            int insertIndex=i-1;
//            int insertValue=arr[i];
//            while(insertIndex>=0 && insertValue<arr[insertIndex]){
//                arr[insertIndex+1]=arr[insertIndex];
//                insertIndex--;
//            }
//            arr[insertIndex+1]=insertValue;
//            System.out.println(Arrays.toString(arr));
//        }
          boolean flag=false;
        for(int i=1;i<arr.length;i++){
            int tmp=arr[i];
            int j;
            for( j=i;j>=0;j--){
                if(tmp<arr[j-1]){
                    flag=true;
                    arr[j]=arr[j-1];
                }
                if(!flag){
                    break;
                }else{
                    flag=false;
                }
            }
            arr[j-1]=tmp;
        }
        System.out.println(Arrays.toString(arr));

    }
    public static  void sortInsert(int arr[]){
        long start = System.currentTimeMillis();
        for(int i=1;i<arr.length;i++){
            int insertIndex=i-1;
            int insertValue=arr[i];
            while(insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertValue;
          //  System.out.println(Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        System.out.println("排序时间"+(end-start)+"毫秒");
    }

}
