package codesuixiang.hash;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 两个数组的交集
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 * 输入 nums1 = {1,2,2,1} nums2 = {2,2}
 * 输出 {2}
 */
public class Lee_349 {


    @Test
    public void testGetintersection(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ints = getintersection(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] getintersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for(int i: nums2) {
            if(set1.contains(i)) {
                resSet.add(i);
            }
        }


        //方法1
        /*int[] res = new int[resSet.size()];
        int j = 0;
        for(int i: resSet) {
            res[j] = i;
            j++;
        }

        return res;*/

        //方法2
        //return resSet.stream().mapToInt(i -> i).toArray();
        return resSet.stream().mapToInt(Integer::intValue).toArray();

    }
}
