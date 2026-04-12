package codesuixiang.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 第454题.四数相加II
 *给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 两个元组如下:
 * (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Lee_454 {

    public static void main(String[] args) {

        int[] A = {1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0 , 2};

        int count = getFourSumCount(A, B, C, D);
        System.out.println(count);


    }

    public static int getFourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
        //遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。

        Map<Integer,Integer> unordered_map = new HashMap<Integer,Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                unordered_map.put(A[i] + B[j], unordered_map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        //定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
        int count = 0;
        //再遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
        for(int i: C){
            for(int j: D){
                 int temp = i + j;
                 if(unordered_map.containsKey(0 - temp)){
                     count += unordered_map.get(0 - temp);
                 }
            }
        }
        //最后返回统计值 count 就可以了

        return count;
    }


}
