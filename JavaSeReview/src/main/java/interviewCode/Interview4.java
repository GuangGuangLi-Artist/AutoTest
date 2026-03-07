package interviewCode;

import java.util.*;
import java.util.stream.Collectors;

public class Interview4 {

    public static void main(String[] args) {

        /**
         * 将list<user>按年龄分组，统计每个年龄段用户数量，使用map<intergre,list<user>>
         */


        ArrayList<User> users = new ArrayList<>();
        users.add(new User(12,"a"));
        users.add(new User(12,"b"));
        users.add(new User(13,"c"));
        Map<Integer, List<User>> groupUser = new HashMap<>();
        //获取用户年龄
        Map<Integer, Long> integerLongMap = users.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.counting()

                ));

        integerLongMap.forEach((age, count) -> {
            System.out.println(age + " " + count);
        });
    }




}
