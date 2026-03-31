package codesuixiang.arrayoption;

import java.util.Arrays;

public class Lee_977 {

    public static void main(String[] args) {
        int [] arr = {4,-1,0,3,10};
        int[] ints = getIntarr(arr);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] getIntarr(int[] arr){
        //双指针法

        int right = arr.length -1;
        int left = 0;
        int[] res = new int[arr.length];
        int index = res.length -1;
        while(left <= right){
            if(arr[left] * arr[left] > arr[right] * arr[right]){
                //正数的相对位置是不变的，需要调整的是负数的位置
                res[index--] = arr[left] * arr[left];
                left++;
            }else {
                res[index--] = arr[right] * arr[right];
                right--;
            }
        }
        return res;
    }
}
