package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class AssertUtil {
    private static final Logger logger = LoggerFactory.getLogger(AssertUtil.class);

    public static void assertTrue(boolean condition, String message) {
        logger.info("断言是否为真：{}",message);
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        logger.error("断言失败：{}",message);
        Assert.fail(message);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        logger.info("断言相等：{}  ==> 实际: {}, 期望: {}", message, actual, expected);
        Assert.assertEquals(actual, expected, message);
    }
}
