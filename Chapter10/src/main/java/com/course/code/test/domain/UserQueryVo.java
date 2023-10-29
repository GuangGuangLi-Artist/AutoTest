package com.course.code.test.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserQueryVo{
    public List<Integer> ids;

    private User user;

}
