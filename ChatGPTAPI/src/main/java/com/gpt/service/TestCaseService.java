
package com.gpt.service;

import dao.TestCaseMapper;
import entity.TestCase;
import utils.MyBatisUtils;

import java.util.List;

public class TestCaseService {
    public static List<TestCase> getAllTestCases() {
        return MyBatisUtils.getMapper(TestCaseMapper.class).getAllTestCases();
    }
}
