package com.course.code;


import java.util.*;

/**
 *  HJ45 名字的漂亮度.
 *
 *  给出一个字符串，该字符串仅由小写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个字符串，计算每个字符串最大可能的“漂亮度”
 *
 * 第一行一个整数N，接下来N行每行一个字符串
 * 每个字符串可能的最大漂亮程度
 *
 */
public class HuaWeiHJ45 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();

        int n = Integer.valueOf(scanner.nextLine());//n行字符串

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            res.add(beautifulDegree(name));
        }

        res.forEach(System.out::println);

        scanner.close();



    }

    public static int beautifulDegree(String name){
        Map<Character,Integer> map = new HashMap<>();
        for (char c: name.toCharArray()){
            Integer count = map.get(c);
            if(count == null){
                count = 1;
            }else {
                count++;
            }

            map.put(c,count);
        }

        //Map值转List
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }

        //从小到达排序
        list.sort(Comparator.naturalOrder());

        //总和
        int size = map.size();
        int beautyValue = 26 - size + 1;
        int total = 0;
        for (int count: list){
            total += count * beautyValue;
            beautyValue++;
        }

        return total;


    }
}
