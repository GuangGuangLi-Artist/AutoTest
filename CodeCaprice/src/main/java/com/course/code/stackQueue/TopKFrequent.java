package com.course.code.stackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 *     输入: nums = [1,1,1,2,2,3], k = 2
 *     输出: [1,2]
 */
public class TopKFrequent {
    /*Comparator接口说明:
     * 返回负数，形参中第一个参数排在前面；返回正数，形参中第二个参数排在前面
     * 对于队列：排在前面意味着往队头靠
     * 对于堆（使用PriorityQueue实现）：从队头到队尾按从小到大排就是最小堆（小顶堆），
     *                                从队头到队尾按从大到小排就是最大堆（大顶堆）--->队头元素相当于堆的根节点
     * */

    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (pair1,pair2) ->pair2[1] -  pair2[1]
        );
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}
