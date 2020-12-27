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
        int ark[] = new int[80000];
        for(int j=0;j<80000;j++){
            ark[j] = (int)(Math.random()*80000);
        }
        sortInsert(ark);
        /**小数据量*/
        /**for循环+while()循环*/
        int arr[] = {4,3,1,7,9,2,5,69,8,10};
        System.out.println("原来的数据"+Arrays.toString(arr));

        for(int i=1;i<arr.length;i++){
            int insertIndex=i-1;
            int insertValue=arr[i];
            while(insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertValue;
        }
        System.out.println("for循环+while排序后的数据");
        System.out.println(Arrays.toString(arr));

        int arg[] = {4,3,1,7,9,2,5,69,8,10};
          boolean flag=false;
        for(int i=1;i<arr.length;i++){
            int tmp=arg[i];
            int j;
            for( j=i;j>0;j--){
                if(tmp<arg[j-1]){
                    flag=true;
                    arg[j]=arg[j-1];
                }
                if(!flag){
                    break;
                }else{
                    flag=false;
                }
            }
            arg[j]=tmp;
        }
        System.out.println("双重for循环排序后的数据");
        System.out.println(Arrays.toString(arg));

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
