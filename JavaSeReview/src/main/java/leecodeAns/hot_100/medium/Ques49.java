package leecodeAns.hot_100.medium;

import java.util.*;

/**
 * 49 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Ques49 {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Ques49 ques49 = new Ques49();
        List<List<String>> lists = ques49.groupAnagrams(strings);
        System.out.println(lists);

    }

    public List<List<String>> groupAnagrams(String[] strs) {


        //循环字符串列表 将每个字符串进行从小到大排序，排序后如果在Map,存在，就把这个添加到value
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);//字符串排序
            //排序后相同的字符串分到同一组
            //computeIfAbsent：如果 key 不在哈希表中，则插入一个新的 ArrayList
            map.computeIfAbsent(new String(chars), xx -> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(map.values());

    }

    public List<List<String>> groupAnagrams_changgui(String[] strs) {


        //循环字符串列表 将每个字符串进行从小到大排序，排序后如果在Map,存在，就把这个添加到value
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            //包含排序后的内容
            map.get(key).add(s);

        }

        return new ArrayList<>(map.values());

    }
}
