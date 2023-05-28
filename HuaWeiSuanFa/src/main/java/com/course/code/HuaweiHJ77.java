package com.course.code;


import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出
 *
 * 输入：第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 * 输出：输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 *
 *  输入：
 * 3
 * 1 2 3
 * 输出：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 说明：
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class HuaweiHJ77 {
    // 队列表示未进站的火车。先进先出
    // 栈表示已进站的火车。先进后出
    // 每次火车进站后有两种选择：1.直接出站 2.等待下列火车进站  使用递归考虑

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()) {
                int n = sc.nextInt();
                // 未进站的火车
                Queue<Integer> queue = new LinkedList<>();
                // 已进站的火车
                Stack<Integer> stack = new Stack<>();

                for (int i = 0; i < n; i++) {
                    queue.offer(sc.nextInt());
                }
                // 存储，每种进出情况，出站顺序
                List<String> outQueueList = new ArrayList<>();

                // 获取所有出站队列保存到outQueueList
                processOutQueue(queue, stack, "", outQueueList);

                // 排序
                Collections.sort(outQueueList);
                for (String str : outQueueList) {
                    System.out.println(str);
                }

            }
        }

        private static void processOutQueue(Queue<Integer> queue, Stack<Integer> stack, String outQueue, List<String> outQueueList) {
            // 如果队列和栈都为空，表示火车已全部进出完成。则保存出站信息
            if (queue.isEmpty() && stack.isEmpty()) {
                outQueueList.add(outQueue.trim());
                return;
            }

            // 队列和栈有两种情况：出栈或进栈
            // 一：出栈,已进站的需要更新出站信息outQueue
            if (!stack.isEmpty()) {
                // 先克隆
                Queue<Integer> tempQueue = new LinkedList<>(queue);
                Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
                String tempOutQueue = outQueue + (tempStack.pop() + " ");
                processOutQueue(tempQueue, tempStack, tempOutQueue, outQueueList);
            }

            // 二：队列进栈：没进站的继续进站
            if (!queue.isEmpty()) {
                // 先克隆
                Queue<Integer> tempQueue = new LinkedList<>(queue);
                Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
                tempStack.push(tempQueue.poll());
                processOutQueue(tempQueue, tempStack, outQueue, outQueueList);
            }
        }
}
